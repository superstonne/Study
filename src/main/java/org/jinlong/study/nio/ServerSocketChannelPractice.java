package org.jinlong.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class ServerSocketChannelPractice {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                TimeUnit.SECONDS.sleep(3);
            } else {
                System.out.println("Request from:" + socketChannel.socket().getRemoteSocketAddress());
                ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                byteBuffer.put("Hello remote client.".getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                socketChannel.close();
            }
        }
    }
}
