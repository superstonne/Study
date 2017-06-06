package org.jinlong.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by nick on 06/06/2017.
 */
public class DatagramChannelPractice {

    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(9999));

        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.clear();
        datagramChannel.receive(buffer);
        System.out.println("Ready for receiving data.");

        DatagramChannel sendChannel = DatagramChannel.open();
        String data = "This is sent by DatagramChannel.";
        ByteBuffer sendBuffer = ByteBuffer.allocate(48);
        sendBuffer.clear();
        sendBuffer.put(data.getBytes());
        sendBuffer.flip();
    }
}
