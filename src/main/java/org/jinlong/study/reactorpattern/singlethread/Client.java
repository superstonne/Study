package org.jinlong.study.reactorpattern.singlethread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost", 6666));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("Hello, this is the message from Client".getBytes());
        buffer.flip();
        while (true) {
            channel.write(buffer);
            TimeUnit.SECONDS.sleep(30);
        }
    }
}
