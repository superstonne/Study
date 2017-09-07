package org.jinlong.study.nio;

import java.nio.CharBuffer;

/**
 * three methods to copy a buffer
 */
public class CopyBuffer {

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(10);
        BufferUtil.printBufferProperty(buffer);

        // duplicate 方法会复制一个新的缓冲区，新旧缓冲区共享数据内容，但是不共享位置，上限指针
        CharBuffer duplicatedBuffer = buffer.duplicate();
        BufferUtil.printBufferProperty(buffer);

        // duplicate 方法会复制一个新的只读缓冲区，新旧缓冲区共享数据内容，但是不共享位置，上限指针，新缓冲区不可调用put方法
        CharBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        BufferUtil.printBufferProperty(buffer);

        // slice 方法会复制一个新的缓冲区，新旧缓冲区共享数据内容，但是不共享位置，上限指针，新缓冲区的容量只有旧缓冲区当前位置到limit之间的容量
        CharBuffer slicedBuffer = buffer.slice();
        BufferUtil.printBufferProperty(buffer);
    }
}
