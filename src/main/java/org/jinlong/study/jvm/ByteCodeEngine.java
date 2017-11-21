package org.jinlong.study.jvm;

public class ByteCodeEngine {

    public static void main(String[] args) {
        {
            byte[] bytes = new byte[2024 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
