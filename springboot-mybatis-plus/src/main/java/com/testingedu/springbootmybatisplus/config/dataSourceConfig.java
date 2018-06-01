package com.testingedu.springbootmybatisplus.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class dataSourceConfig {
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource") // application.properteis中对应属性的前缀
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    // 配置事物管理器
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
