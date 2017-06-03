package org.jinlong.study.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by nick on 03/06/2017.
 *
 * System.out, System.err, System.in 这三个流通常用于将数据输出到控制台，或者从控制台读入数据。
 *
 *
 */
public class SystemIOPractice {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This is System.out PrintStream!");
        OutputStream out = new FileOutputStream("test.txt");
        PrintStream printStream = new PrintStream(out);
        System.setOut(printStream);
        System.out.println("Print data into txt.");
        printStream.flush();
    }
}
