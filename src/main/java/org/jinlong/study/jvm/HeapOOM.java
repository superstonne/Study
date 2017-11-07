package org.jinlong.study.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    public static void main(String[] args) {
        List list = new ArrayList();
        while (true) {
            list.add(new Object());
        }
    }
}
