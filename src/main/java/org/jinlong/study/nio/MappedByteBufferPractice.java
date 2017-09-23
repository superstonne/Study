package org.jinlong.study.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferPractice {
    public static void main(String[] args) throws Exception {
        RandomAccessFile textText = new RandomAccessFile("test.txt", "rw");
        FileChannel fileChannel = textText.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

        byteBuffer.put("data from read write buffer".getBytes());
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        byteBuffer.clear();

        byteBuffer.put("data from read write buffer".getBytes());
        byteBuffer.flip();
        fileChannel.write(byteBuffer, 8192);
        MappedByteBuffer read = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        MappedByteBuffer readWrite = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
        MappedByteBuffer copyWrite = fileChannel.map(FileChannel.MapMode.PRIVATE, 0, fileChannel.size());

        BufferUtil.printBufferContent(read);
        BufferUtil.printBufferContent(readWrite);
        BufferUtil.printBufferContent(copyWrite);

        readWrite.position(10);
        readWrite.put("rw buffer".getBytes());
        readWrite.force();
        readWrite.position (8194);
        readWrite.put (" R/W ".getBytes( ));

        System.out.println("data changed by read write buffer.");
        BufferUtil.printBufferContent(read);
        BufferUtil.printBufferContent(readWrite);
        BufferUtil.printBufferContent(copyWrite);

        System.out.println("data changed by copy write buffer.");
        copyWrite.position(10);
        copyWrite.put("cw buffer".getBytes());
        copyWrite.force();
        copyWrite.position (8194);
        copyWrite.put (" C/W ".getBytes( ));
        copyWrite.force();
        BufferUtil.printBufferContent(read);
        BufferUtil.printBufferContent(readWrite);
        BufferUtil.printBufferContent(copyWrite);

    }
}
