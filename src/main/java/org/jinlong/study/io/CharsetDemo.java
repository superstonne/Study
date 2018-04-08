package org.jinlong.study.io;

import java.nio.charset.Charset;

public class CharsetDemo {
    public static void main(String[] args) {
        String str = new String("I am 贺金龙".getBytes(), Charset.forName("UTF-8"));
        System.out.println(str);

        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));

        System.out.println(str.getBytes(Charset.forName("ISO-8859-1")));

        String str2 = new String(bytes);
        System.out.println(str2);

        System.out.println(Charset.defaultCharset());
    }
}
