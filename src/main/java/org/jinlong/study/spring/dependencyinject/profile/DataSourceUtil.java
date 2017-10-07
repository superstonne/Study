package org.jinlong.study.spring.dependencyinject.profile;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

public class DataSourceUtil {
    @Bean
    @Profile("dev")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DataSource getDevelopmentDataSource() {
        return null;
    }

    @Bean
    @Profile("test")
    public DataSource getTestDataSource() {
        return null;
    }

    @Bean
    @Profile("prod")
    public DataSource getProdDataSource() {
        return null;
    }
}
