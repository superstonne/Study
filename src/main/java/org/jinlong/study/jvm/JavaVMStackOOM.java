package org.jinlong.study.jvm;

/**
 * 当程序里面启动了大量的线程导致内存不足时会抛出OOM异常而不是SOF
 */
public class JavaVMStackOOM {

    public static void doNotStop() {
        while (true);
    }

    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                private byte[] bytes = new byte[1024 * 1024 * 2];
                @Override
                public void run() {
                    System.out.println("go");
                    doNotStop();
                }
            }).start();
        }
    }
}
