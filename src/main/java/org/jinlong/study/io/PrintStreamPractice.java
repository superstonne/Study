package org.jinlong.study.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Locale;

/**
 * Created by nick on 05/06/2017.
 * PrintStream 顾名思义是用来打印流的，它可以将流中的内容打印到文件中，屏幕上等，同时可以格式化输出。
 * 例如System.out， System.err就是PrintStream的实例。
 */
public class PrintStreamPractice {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(System.out);
        printStream.printf(Locale.UK, "", 123);
        printStream.println("Hello");
        printStream = new PrintStream(new FileOutputStream("data.bin"));
        printStream.println("Hello file.");
        printStream.close();
    }
}
