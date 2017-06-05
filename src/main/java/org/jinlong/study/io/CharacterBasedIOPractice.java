package org.jinlong.study.io;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by nick on 05/06/2017.
 *
 * 基于字节的Java IO： Writer 和 Reader
 */
public class CharacterBasedIOPractice {
    public static void main(String[] args) throws IOException {

        /**
         * InputStreamReader and OutputStreamWriter 可以将基于字节的流转为基于字符的流。
         */
        Writer writer = new OutputStreamWriter(new FileOutputStream("data.bin"));
        writer.write("This string is written by Writer.".toCharArray());

        writer.flush();
        Reader reader = new InputStreamReader(new FileInputStream("data.bin"));
        int data = reader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }

        /**
         * 在初始化的时候字符流的时候我们可以指定编码，如果我们需要显示指定编码，那么输入输出的编码必须一致，否则会出现乱码现象。
         * 通常情况下，我们不需要指定输入流的编码，因为Java会帮我们处理好的。
         */
        writer = new OutputStreamWriter(new FileOutputStream("data.bin"), "utf-8");
        writer.write("This is a utf8 encoded string.".toCharArray());
        writer.flush();
        reader = new InputStreamReader(new FileInputStream("data.bin"), "utf-8");
        data = reader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }

        /**
         * FileReader, FileWriter 默认使用当前机器的编码，所以如果你想使用特定的编码读取流，那么请使用InputStreamReader and
         * OutputStreamReader
         */
        reader = new FileReader("data.bin");
        data = reader.read();
        while (data != -1) {
            System.out.print((char) data);
            data = reader.read();
        }

        writer = new FileWriter("data.bin");
        writer.write("This is written by FileWriter.");
        writer.flush();

        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("data.bin"));
        String line = lineNumberReader.readLine();
        while (line != null) {
            System.out.println(line);
            System.out.println(lineNumberReader.getLineNumber());
            line = lineNumberReader.readLine();
        }

        StringWriter stringWriter = new StringWriter();
        stringWriter.write("mykj fdlkj salfdksa");
        stringWriter.write("my computer kdjasl fkjdlsakjf lkdsaj flkdsajkfkldsa");
        StringBuffer stringBuffer = stringWriter.getBuffer();
        System.out.println(stringBuffer.toString());
        stringWriter.flush();

        StringReader stringReader = new StringReader(stringWriter.toString());
        StreamTokenizer streamTokenizer = new StreamTokenizer(
                reader);

        while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF){

            if(streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                System.out.println(streamTokenizer.sval);
            } else if(streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println(streamTokenizer.nval);
            } else if(streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println();
            }

        }

        writer.close();
        reader.close();
        lineNumberReader.close();
        stringWriter.close();
    }
}
