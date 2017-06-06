package org.jinlong.study.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by nick on 06/06/2017.
 * FileChannel 使得我们可以向文件写入内容或者读取文件的内容，该类始终运行于阻塞模式。
 */
public class FileChannelPractice {

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("pom.xml", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        System.out.println("File size: " + fileChannel.size());

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int bytesRead = fileChannel.read(byteBuffer);
        while (bytesRead != -1) {
            byteBuffer.flip();
            for (int i = 0; i < byteBuffer.limit(); i++) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.flip();
            bytesRead = fileChannel.read(byteBuffer);
        }
        fileChannel.close();

        byteBuffer.clear();
        String data = "This is string written by file channel.";
        byteBuffer.put(data.getBytes());
        fileChannel = new RandomAccessFile("data.bin", "rw").getChannel();
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            fileChannel.write(byteBuffer);
        }

        fileChannel.force(true);
        fileChannel.close();


    }
}
