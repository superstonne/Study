package org.jinlong.study.io;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 01/06/2017.
 *
 * Pipe I/O 主要用于同一个JVM里面的俩个线程之间的通信，但是通常会有一些其他方式完成线程之间的通信功能，
 * 例如利用Object。 这里个Pipe和操作系统的Pipe不同。
 *
 * Java 提供了字节流和字符流2种类型的管道传输。
 */
public class PipeIOPractice {

    public static void main(String[] args) throws IOException, InterruptedException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);
        final PipedWriter writer = new PipedWriter();
        final PipedReader reader = new PipedReader(writer);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = input.read();
                    while (data != -1) {
                        System.out.print((char) data);
                        data = input.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    int data = reader.read();
                    while (data != -1) {
                        System.out.print((char) data);
                        data = reader.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        TimeUnit.SECONDS.sleep(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    output.write("Hello there! I'm a thread.".getBytes());
                    output.close();// 需要关闭输出流，否则另外一个线程中的InputStream read方法会抛出错误。
                    writer.write("This data written by PipedWriter.");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
