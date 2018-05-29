package org.jinlong.study.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AdditionalAnnotations {

    public static void main(String[] args) {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    public @interface NotNull {

    }

    public static int add(@NotNull Integer a, @NotNull Integer b) {
        return a + b;
    }
}
