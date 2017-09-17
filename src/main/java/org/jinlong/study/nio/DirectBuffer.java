package org.jinlong.study.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/**
 * 直接缓冲区，只有ByteBuffer才会是直接缓冲区，使用它进行IO处理效率会很高，
 * 基于直接缓冲区创建的试图缓冲区共享内容，独享位置指针。试图缓冲区的长度会由
 * 当前缓冲区的position到limit位置之间的元素组成，长度=（limit-position）／ 视图缓冲区元素的字节数
 */
public class DirectBuffer {

    public static void main(String[] args) {
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(10);
        System.out.println(directBuffer.isDirect());

        directBuffer.put((byte)1);
        directBuffer.put((byte)2);
        directBuffer.put((byte)3);
        directBuffer.put((byte)4);
        directBuffer.put((byte)5);
        directBuffer.put((byte)6);
        directBuffer.flip();

        CharBuffer charBuffer = directBuffer.asCharBuffer();
        System.out.println(directBuffer.isDirect());
        BufferUtil.printBufferProperty(charBuffer);

        ShortBuffer shortBuffer = directBuffer.asShortBuffer();
        System.out.println(shortBuffer.isDirect());
        BufferUtil.printBufferProperty(shortBuffer);

        IntBuffer intBuffer = directBuffer.asIntBuffer();
        System.out.println(intBuffer.isDirect());
        BufferUtil.printBufferProperty(intBuffer);

    }
}
