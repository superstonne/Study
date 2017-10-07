package org.jinlong.study.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class TrackTools {

    private Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

    @Pointcut("execution(* org.jinlong.study.spring.aop.TrackNumberPerformance.perform(int)) && args(trackNumber)")
    public void trackPlay(int trackNumber) {}

    @Before("trackPlay(trackNumber)")
    public void trackCount(int trackNumber) {
        int countCount = counts.containsKey(trackNumber) ? counts.get(trackNumber) : 0;
        counts.put(trackNumber, countCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return counts.containsKey(trackNumber) ? counts.get(trackNumber) : 0;
    }
}
