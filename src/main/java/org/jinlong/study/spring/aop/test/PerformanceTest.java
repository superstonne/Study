package org.jinlong.study.spring.aop.test;

import junit.framework.TestCase;
import org.jinlong.study.spring.aop.*;
import org.jinlong.study.spring.aop.config.PerformanceConfig;
import org.jinlong.study.spring.dependencyinject.config.RobotConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.Perf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= PerformanceConfig.class)
public class PerformanceTest extends TestCase {

    @Autowired
    @Qualifier("malePerformance1")
    private Encoreable malePerformance;

    @Autowired
    @Qualifier("trackNumberPerformance")
    private TrackNumberPerformance numberPerformance;

    @Autowired
    private TrackTools trackTools;

    @Test
    public void testAdviceWithAnnotation() {
        malePerformance.performanceEncore();
        ((Performance)malePerformance).perform();
//        ((Encoreable) malePerformance).performanceEncore();
    }

    @Test
    public void testNumberPerformance() {
        numberPerformance.perform(1);
        numberPerformance.perform(1);
        numberPerformance.perform(1);
        numberPerformance.perform(1);
        Assert.assertEquals(4, trackTools.getPlayCount(1));
        Assert.assertEquals(0, trackTools.getPlayCount(4));
    }
}
