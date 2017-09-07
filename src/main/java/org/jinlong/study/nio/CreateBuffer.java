package org.jinlong.study.nio;

import java.nio.CharBuffer;

/**
 * 创建buffer的 5 种方式, 后俩种方法为CharBuffer独有的创建方式
 */
public class CreateBuffer {

    public static void main(String[] args) {
        char[] chars = new char[100];
        CharBuffer buffer = null;

        //分配一个100 char 长度的缓冲区， 内部会创建一个数组来存储， 调用array（）可以获得存储的数组
        buffer = CharBuffer.allocate(100);
        BufferUtil.printBufferProperty(buffer);

        //包装一个100 char 长度的数组为缓冲区
        buffer = CharBuffer.wrap(chars);
        BufferUtil.printBufferProperty(buffer);

        //包装一个100 char 长度的数组为缓冲区，但是位置指针开始指向 10
        buffer = CharBuffer.wrap(chars, 10, 90);
        BufferUtil.printBufferProperty(buffer);

        //用CharSequence来封装一个buffer, 长度为该序列的长度
        buffer = CharBuffer.wrap("1234567");
        BufferUtil.printBufferProperty(buffer);

        //用CharSequence来封装一个buffer, 长度为该序列的长度， 位置指针为1， 上限指针指向4，即相当于调用过flip的状态
        buffer = CharBuffer.wrap("1234567", 1, 4);
        BufferUtil.printBufferProperty(buffer);

    }
}
