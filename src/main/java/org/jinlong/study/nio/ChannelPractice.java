package org.jinlong.study.nio;

import org.jboss.netty.util.internal.ByteBufferUtil;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelPractice {
    public static void main(String[] args) throws Exception {
        RandomAccessFile textText = new RandomAccessFile("test.txt", "rw");
        // 通过随机访问文件获得的管道，根据文件句柄初始化的mode，可以获得分别为只读，可读可写的管道
        // 本例中获得可读可写的channel
        // 同理，通过InputStream获得的管道只具备读功能。通过OuputStream获得的管道只具备写功能
        FileChannel fileChannel = textText.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        BufferUtil.printBufferProperty(byteBuffer);
        byteBuffer.put("data from byte buffer.".getBytes());
        BufferUtil.printBufferProperty(byteBuffer);
        byteBuffer.flip();
        BufferUtil.printBufferProperty(byteBuffer);
        fileChannel.write(byteBuffer);
        // 强制管道中的内容写入设备存储
        fileChannel.force(true);
        BufferUtil.printBufferProperty(byteBuffer);
        byteBuffer.clear();
        BufferUtil.printBufferProperty(byteBuffer);
        fileChannel.position(0);
        fileChannel.read(byteBuffer);
        BufferUtil.printBufferProperty(byteBuffer);
        byteBuffer.flip();
        BufferUtil.printBufferProperty(byteBuffer);
        while (byteBuffer.hasRemaining()) {
            System.out.print((char)byteBuffer.get());
        }
        System.out.println();
        BufferUtil.printBufferProperty(byteBuffer);
    }
}
