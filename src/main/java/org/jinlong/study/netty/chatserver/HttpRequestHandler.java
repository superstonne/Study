package org.jinlong.study.netty.chatserver;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private final String WEB_SOCKET_URI;

    private static File INDEX;

    static {
        URL location = HttpRequestHandler.class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation();
        try {
            String path = location.toURI() + "index.html";
            path = path.contains("file:") ? path.substring(5) : path;
            INDEX = new File(path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public HttpRequestHandler(String uri) {
        WEB_SOCKET_URI = uri;
    }

    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        if (WEB_SOCKET_URI.equalsIgnoreCase(request.uri())) {
            ctx.fireChannelRead(request.retain());
        } else {
            if (HttpUtil.is100ContinueExpected(request)) {
                FullHttpResponse response = new DefaultFullHttpResponse(
                        HttpVersion.HTTP_1_0, HttpResponseStatus.CONTINUE
                );
                ctx.writeAndFlush(response);
            }
            RandomAccessFile indexFile = new RandomAccessFile(INDEX, "r");
            HttpResponse response = new DefaultHttpResponse(
                    request.protocolVersion(), HttpResponseStatus.OK
            );
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html");

            boolean keepAlive = HttpUtil.isKeepAlive(request);
            if (keepAlive) {
                response.headers()
                        .set(HttpHeaderNames.CONTENT_LENGTH, indexFile.length())
                        .set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            }
            ctx.writeAndFlush(response);

            if (ctx.pipeline().get(SslHandler.class) == null) {
                ctx.write(new DefaultFileRegion(indexFile.getChannel(), 0, indexFile.length()));
            } else {
                ctx.write(new ChunkedNioFile(indexFile.getChannel()));
            }

            ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
            if (!keepAlive) {
                future.addListener(ChannelFutureListener.CLOSE);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
