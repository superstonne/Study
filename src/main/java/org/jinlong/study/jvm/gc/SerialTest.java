package org.jinlong.study.jvm.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SerialTest {
    public static final byte[] SIXTY_KB = new byte[64 * 1024];

    public static void main(String[] args) throws InterruptedException {
        OOMWithFixedSize();
    }

    public static void OOMWithFixedSize() throws InterruptedException {
        List<byte[]> list = new ArrayList<byte[]>();
        while (true) {
            list.add(SIXTY_KB);
            TimeUnit.MICROSECONDS.sleep(10);
        }
    }
}
