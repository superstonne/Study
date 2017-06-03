package org.jinlong.study.io;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.PushbackInputStream;

/**
 * Created by nick on 03/06/2017.
 */
public class PushBackIOPractice {
    public static void main(String[] args) throws Exception {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(new ByteArrayInputStream("This is a String".getBytes()));
        int data = pushbackInputStream.read();
        int time = 0;
        while (data != -1) {
            System.out.print((char) data);
            if ((char) data == 'S' && time < 3) {
                pushbackInputStream.unread(data);
                time++;
            }
            data = pushbackInputStream.read();
        }
        pushbackInputStream.close();

        System.out.println();
        time = 0;
        byte[] buffer = new byte[8];
        pushbackInputStream = new PushbackInputStream(new ByteArrayInputStream("This is a String".getBytes()), 8);
        data = pushbackInputStream.read(buffer);
        while (data != -1) {
            for (int i = 0; i < data; i++) {
                System.out.print((char) buffer[i]);
                if ((char) buffer[i] == 'g' && time < 3) {
                    pushbackInputStream.unread(data);
                    time++;
                    System.out.println("Pushed back.");
                }
            }
            data = pushbackInputStream.read(buffer);
        }
    }
}
