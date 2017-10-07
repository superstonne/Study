package org.jinlong.study.spring.aop.config;

import org.jinlong.study.spring.aop.Audience;
import org.jinlong.study.spring.aop.EncoreableIntroducer;
import org.jinlong.study.spring.aop.TrackNumberPerformance;
import org.jinlong.study.spring.aop.TrackTools;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.jinlong.study.spring.aop"})
@EnableAspectJAutoProxy
public class PerformanceConfig {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public TrackTools trackTools() {
        return new TrackTools();
    }

    @Bean(value = {"defaultEncoreable"})
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }

}
