package org.jinlong.study.nio;

import java.nio.Buffer;

public class BufferUtil {

    public static void printBufferProperty(Buffer buffer) {
        System.out.println("capacity:" + buffer.capacity() + " limit:" + buffer.limit() + " position:"
                + buffer.position() + " has array:" + buffer.hasArray());
    }
}
