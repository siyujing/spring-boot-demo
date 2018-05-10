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
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.db2") // application.properteis中对应属性的前缀
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     */
//    @Bean(name = "dynamicDS1")
//    public DataSource dataSource() {
//        log.debug("dynamicDS1------");
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        // 配置多数据源
//        Map dsMap = new HashMap<>();
////        DataSource dataSource1 = dataSource1();
////        dsMap.put("TITANMASTER", dataSource1);
//
//        DataSource dataSource2 = dataSource2();
//        dsMap.put("DS2", dataSource2);
//
//        dynamicDataSource.setTargetDataSources(dsMap);
//
//        // 默认数据源
//        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
//        return dynamicDataSource;
//    }
}
