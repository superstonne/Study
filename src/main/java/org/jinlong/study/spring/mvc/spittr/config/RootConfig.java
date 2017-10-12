package org.jinlong.study.spring.mvc.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"org.jinlong.study.spring.mvc.spittr"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
}
