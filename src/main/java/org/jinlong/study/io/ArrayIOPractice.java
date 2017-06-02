package org.jinlong.study.io;

import java.io.*;

/**
 * Created by nick on 02/06/2017.
 *
 * Array IO 主要用于从内存中将数组数组读入流中或者，将流中的数据传入内存数组中。
 * Java提供了字节数组流和字符数组流：
 * ByteArrayInputStream，ByteArrayOutputStream
 * CharArrayReader，CharArrayWriter
 */
public class ArrayIOPractice {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "I am a bytes array!".getBytes();
        System.out.println(bytes.length);
        byte a = 'a';
        byte b = 1;
        System.out.println(a);
        System.out.println((char) a);

        InputStream inputStream = new ByteArrayInputStream(bytes);
        int data = inputStream.read();
        while (data != -1) {
            System.out.print((char) data);
            data = inputStream.read();
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("This is a string!".getBytes());
        System.out.println(outputStream.toByteArray());

        char[] chars = "This is a char array".toCharArray();
        CharArrayReader charArrayReader = new CharArrayReader(chars);
        int charData = charArrayReader.read();
        while (charData != -1) {
            System.out.print((char) charData);
            charData = charArrayReader.read();
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        charArrayWriter.write("This is from char array!".toCharArray());
        char[] chars1 = charArrayWriter.toCharArray();
        System.out.println(chars1);
    }
}
