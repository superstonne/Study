package org.jinlong.study.jvm;

import sun.jvm.hotspot.ui.tree.DoubleTreeNodeAdapter;

/**
 * Created by nick on 23/07/2017.
 */
public class BasicDataType {

    public static void main(String[] args) {
        //byte占用1个字节
        System.out.println(Byte.BYTES);
        //short占用2个字节
        System.out.println(Short.BYTES);
        //int占用4个字节
        System.out.println(Integer.BYTES);
        //long占用8个字节
        System.out.println(Long.BYTES);
        //float占用4个字节
        System.out.println(Float.BYTES);
        //double占用8个字节
        System.out.println(Double.BYTES);
        //char咋用2个字节
        System.out.println(Character.BYTES);

        //byte max = 2^7 - 1= 127
        System.out.println(Byte.MAX_VALUE);
        //byte min = -2^7 = -128
        System.out.println(Byte.MIN_VALUE);
        byte maxB = (byte) -128;
        System.out.println(maxB);

        //short max = 2 ^ 15 - 1 = 32767;
        System.out.println(Short.MAX_VALUE);
        //short min = -2 ^ 15 = -32768
        System.out.println(Short.MIN_VALUE);
        short maxS = 32767;

        //int max = 2 ^ 31 - 1 = 2147483647
        System.out.println(Integer.MAX_VALUE);
        //int min = -2 ^ 31 = -2147483648
        System.out.println(Integer.MIN_VALUE);
        int maxI = 2147483647;

        //long max = 2 ^ 63 - 1 = 9223372036854775807
        System.out.println(Long.MAX_VALUE);
        //long min = -2 ^ 63 = -9223372036854775808;
        System.out.println(Long.MIN_VALUE);

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        float maxF = 3.4028235E38f;
        System.out.println(maxF);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);

        System.out.println(Character.MAX_VALUE);
        System.out.println(Character.MIN_VALUE);
        char maxC = 65535;
        char minC = 0;
        System.out.println(2.1E300);
        System.out.println(2.1E300);
    }
}
