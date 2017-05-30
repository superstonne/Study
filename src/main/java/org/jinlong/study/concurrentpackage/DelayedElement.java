package org.jinlong.study.concurrentpackage;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by nick on 30/05/2017.
 */
public class DelayedElement implements Delayed{
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
