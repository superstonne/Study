package org.jinlong.study.io;

import java.io.*;

public class InputStreamPractice {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(new File("pom.xml"));
        int result = -1;

        inputStream = new BufferedInputStream(inputStream);



        while ((result = inputStream.read()) != -1) {
            System.out.print(result);
        }
        System.out.println("over.");
        inputStream.mark(inputStream.available());
        inputStream.reset();

        while ((result = inputStream.read()) != -1) {
            System.out.print(result);
        }
        System.out.println("over.");
        System.out.println("finish.");
    }
}
