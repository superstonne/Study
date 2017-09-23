package org.jinlong.study.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferUtil {

    public static void printBufferProperty(Buffer buffer) {
        System.out.println("capacity:" + buffer.capacity() + " limit:" + buffer.limit() + " position:"
                + buffer.position() + " has array:" + buffer.hasArray());
    }

    public static void printBufferContent(ByteBuffer buffer) {
        buffer.position(0);
        while (buffer.hasRemaining()) {
            char c = (char) buffer.get();
            if (c == '\u0000') {
                continue;
            }
            System.out.print((char) c);
        }
        System.out.println();
    }
}
