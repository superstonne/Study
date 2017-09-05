package org.jinlong.study.nio;

import java.nio.Buffer;
import java.nio.CharBuffer;

/**
 * 对NIO缓冲区API的学习
 */
public class BufferDemo {
    public static void main(String[] args) {
        //新分配一个容量为10的缓冲区，此时位置指针为0，上限指针在缓冲区最末尾
        CharBuffer buffer = CharBuffer.allocate(10);
        printBufferProperty(buffer);

        //向缓冲区填入一个字符，此时位置指针向后移动一位，到达 1 的位置, 上限指针位置不变
        buffer.put('0');
        printBufferProperty(buffer);

        //向缓冲区填入一个字符，此时位置指针向后移动一位，到达 2 的位置, 上限指针位置不变
        buffer.put('1');
        printBufferProperty(buffer);

        //此时记录调用 mark 方法记录缓冲区的位置，则此时标记位置为2。
        buffer.mark();

        //继续向缓冲区推入内容，此时缓冲区位置指针指向 4
        buffer.put('3');
        buffer.put('4');
        printBufferProperty(buffer);

        //此时我们发现刚刚推入缓冲区的数据有误，则可以调用reset方法，使得位置指针可以回到标记的位置
        buffer.reset();
        printBufferProperty(buffer);

        //重新向缓冲区推入正确的内容
        buffer.put('2');
        buffer.put('3');
        printBufferProperty(buffer);

        //此时我们要开始读取缓冲区的内容，则调用flip方法，会使得位置指针指向0， 上限指针指向4为当前缓冲区的数据的个数
        buffer.flip();
        printBufferProperty(buffer);

        //读取缓冲区的数据, 位置指针向后移动一位，指向1， 上限指针位置不变
        char data = buffer.get();
        System.out.println(data);
        printBufferProperty(buffer);

        //标记位置，然后继续读取3个数据，此时缓冲区位置指向4
        buffer.mark();
        data = buffer.get();
        System.out.println(data);
        data = buffer.get();
        System.out.println(data);
        data = buffer.get();
        System.out.println(data);
        printBufferProperty(buffer);

        //此时业务需求，再次读取标记开始后面的数据，调用reset方法，可再次读取
        buffer.reset();
        printBufferProperty(buffer);
        data = buffer.get();
        System.out.println(data);
        data = buffer.get();
        System.out.println(data);
        data = buffer.get();
        System.out.println(data);
        printBufferProperty(buffer);

        //此时已到达缓冲区上限，若继续读取，缓冲区会报错
        try {
            buffer.get();
        } catch (Exception e) {
        }

        //调用rewind方法，回到初始化的位置可以重新操作缓冲区的内容
        buffer.rewind();
        printBufferProperty(buffer);

        //remaining 方法可以返回当前position位置到上限位置的距离
        System.out.println(buffer.remaining());
        buffer.get();
        System.out.println(buffer.remaining());

        //hasRemaining 方法判断当前position 是不是已经到达上限位置
        System.out.println(buffer.hasRemaining());

        //查看当前缓冲区是不是只读缓冲区
        System.out.println(buffer.isReadOnly());

        //利用当前缓冲区生成一个新的只读缓冲区，对当前缓冲区内容的更改会反映到只读缓冲区，2个缓冲区的位置是独立的
        CharBuffer readBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readBuffer.isReadOnly());

        //内容共享
        buffer.put(0, '3');
        System.out.println(readBuffer.get(0));

        //位置不共享
        buffer.clear();
        printBufferProperty(buffer);
        printBufferProperty(readBuffer);



    }

    public static void printBufferProperty(Buffer buffer) {
        System.out.println("capacity:" + buffer.capacity() + " limit:" + buffer.limit() + " position:"
                + buffer.position());
    }
}
