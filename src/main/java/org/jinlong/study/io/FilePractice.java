package org.jinlong.study.io;

import java.io.File;
import java.io.StringReader;

/**
 * Created by nick on 03/06/2017.
 *
 * Using the functions of File provided, we can operate file so easy;
 * mkdirs can make all the folders missing in the path
 * rename can rename a file name or move the file to a different location.
 */
public class FilePractice {

    public static void main(String[] args) {
        File file = new File("test/testsub/");
        if (!file.exists()) {
            file.mkdirs();
        }
        System.out.println("Exists: " + file.exists());
        System.out.println("Length: " + file.length());
        File testtxt = new File("test.txt");
        if (testtxt.exists()) {
            testtxt.renameTo(new File("test/testsub/test.txt"));
        }
    }
}
