package org.jinlong.study.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLockPractice {
    public static void main(String[] args) throws Exception {
        RandomAccessFile textText = new RandomAccessFile("test.txt", "rw");
        FileChannel fileChannel = textText.getChannel();
        FileLock lock = null;
        try {
            // 锁定该管道指向的文件，如果文件已经被其他进程锁定，则该方法阻塞。
            // 若是文件被同进程中的其他线程锁定，该方法仍可锁定文件，因为不可使用该方法来在线程之间做同步锁定文件
            lock = fileChannel.lock();
            // tryLock方法不会阻塞，而是立即返回结果，null代表锁定失败
            System.out.println("Locked file.");
            TimeUnit.SECONDS.sleep(60);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //使用完毕后要手动释放文件锁
            // 若该锁关联的管道被关闭或者线程终止，文件锁也会被释放
            lock.release();
            System.out.println("Released lock.");
        }
    }
}
