package org.jinlong.study.io;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

/**
 * Created by nick on 05/06/2017.
 * SequenceInputStream 可以将多个输入流，像链条一样链接起来，按照顺序一个个读完链条中所有流的内容。
 * 使用结束，只要关闭SequenceInputStream那么链条中的流就都会被关闭，无需一一关闭。
 */
public class SequenceIOPractice {

    public static void main(String[] args) throws IOException {
        InputStream inputStream1 = new ByteArrayInputStream("This is input stream 1.".getBytes());
        InputStream inputStream2 = new ByteArrayInputStream("This is input stream 2.".getBytes());
        SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2);
        int data = -1;
//        data = sequenceInputStream.read();
//        while (data != -1) {
//            System.out.print((char) data);
//            data = sequenceInputStream.read();
//        }

        InputStream inputStream3 = new ByteArrayInputStream("This is input stream 1.".getBytes());
        InputStream inputStream4 = new ByteArrayInputStream("This is input stream 2.".getBytes());
        SequenceInputStream sequenceInputStream2 = new SequenceInputStream(inputStream3, inputStream4);

        System.out.println("Start ");
        SequenceInputStream sequenceInputStream3 = new SequenceInputStream(sequenceInputStream, sequenceInputStream2);
        data = sequenceInputStream3.read();
        while (data != -1) {
            System.out.print((char) data);
            data = sequenceInputStream3.read();
        }

        sequenceInputStream3.close();

    }
}
