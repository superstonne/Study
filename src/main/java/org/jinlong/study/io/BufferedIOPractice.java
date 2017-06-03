package org.jinlong.study.io;

import java.io.*;

/**
 * Created by nick on 03/06/2017.
 * This is so slow if we use general read function from InputStream. If we want to speed up, we can
 * use BufferedInputStream or BufferedOutputStream.
 * Also we can set the buffer size according to our hardware performance, the best performance size should be
 * tested again according to the computer. Default Buffered IO has a internal buffer size.
 *
 * Buffered IO also support mark and reset functions, not all the sub implementations support those two functions,
 * use those two functions we can reread the data or reset the read pointer.
 *
 * Note: Some disks has a cache for mega bytes. Use different read operations can lead disk erase the cache and reload
 * data blocks, this would be more slower.
 *
 */
public class BufferedIOPractice {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new BufferedInputStream(new FileInputStream("test/testsub/test.txt"));
        int buffer = 1024 * 4;
        inputStream = new BufferedInputStream(new FileInputStream("test/testsub/test.txt"), buffer);

        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("test/testsub/test.txt"));
        outputStream = new BufferedOutputStream(new FileOutputStream("test/testsub/test.txt"), buffer);
    }
}
