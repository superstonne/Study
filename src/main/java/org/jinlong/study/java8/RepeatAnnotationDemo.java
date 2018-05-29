package org.jinlong.study.java8;

import java.lang.annotation.*;

/**
 * 重复注解
 */
public class RepeatAnnotationDemo {

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface PrintStrs {
        PrintStr[] value();
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( PrintStrs.class )
    public @interface PrintStr {
        String value();
    };

    @PrintStr("Hello 1")
    @PrintStr("Hello 2")
    public abstract static class Printable{}

    public static void main(String[] args) {
        for (PrintStr printStr : Printable.class.getAnnotationsByType(PrintStr.class)) {
            System.out.println(printStr.value());
        }
    }
}
