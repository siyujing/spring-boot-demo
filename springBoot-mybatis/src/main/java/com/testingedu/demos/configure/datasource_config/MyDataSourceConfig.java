package com.testingedu.demos.configure.datasource_config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class MyDataSourceConfig {
    @Bean(name = "titanMasterDS")
    @ConfigurationProperties(prefix = "spring.datasource.titan-master") // application.properteis中对应属性的前缀
    @Primary
    public DataSource dataSource1() {
        DataSource dataSource = DataSourceBuilder.create().build();
        log.debug("MyDataSourceConfig,[{}]",dataSource);
        return dataSource;
    }

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        DataSource dataSource = DataSourceBuilder.create().build();
        System.out.println("---MyDataSourceConfig,---");
        log.debug("MyDataSourceConfig,[{}]",dataSource);
        return dataSource;
    }

}
