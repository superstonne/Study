package org.jinlong.study.io;

import java.io.*;

/**
 * Created by nick on 05/06/2017.
 *
 * DataInputStream 可以从输入流中读出java的基本数据类型数据，通常和DataOutputStream搭配使用。
 */
public class DataIOPractice {
    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.bin"));
        dataOutputStream.writeInt(123);
        dataOutputStream.writeFloat(123);
        dataOutputStream.writeDouble(123);
        dataOutputStream.writeShort(123);
        dataOutputStream.writeChars("string");
        dataOutputStream.writeChar('1');
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.bin"));
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readInt());

        dataInputStream.close();
        dataOutputStream.close();

    }
}
