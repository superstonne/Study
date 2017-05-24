package org.jinlong.study.collections;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by nick on 24/05/2017.
 */
public class CollectionUtil {

    public static void doSomeAction(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
        }

    }
}
