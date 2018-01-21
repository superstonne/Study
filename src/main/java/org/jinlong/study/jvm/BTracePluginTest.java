package org.jinlong.study.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 在visual vm里面安装BTrace插件，然后编写脚本可以在程序运行时，动态加入调试信息，
 * 获取堆栈调用信息等。
 * 参考如下脚本，获得add方法的调用堆栈信息，参数，返回结果
 * <code>
 *
 *  @OnMethod (clazz="org.jinlong.study.jvm.BTracePluginTest", method="add", location=@Location (Kind.RETURN))
 *
 *  public static void func (@Self org.jinlong.study.jvm.BTracePluginTest instance, int a, int b, @Return int result) {
 *  println("call stack trace");
 *  jstack();
 *  println(strcat("function parameter a:", str(a)));
 *  println(strcat("function parameter a:", str(b)));
 *  println(strcat("function result :", str(result)));
 *  }
 *
 *
 *
 *
 * </code>
 */
public class BTracePluginTest {
    public int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) throws IOException {
        BTracePluginTest bTracePluginTest = new BTracePluginTest();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            reader.readLine();
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(bTracePluginTest.add(a, b));
        }
    }
}
