package com.testingedu.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by boxfish on 17/9/13.
 */
@Configuration
public class ThirdDataSource {

    // 使用jdbcTempalate 操作时,可以打开注释,直接注入该Bean,双数据源不需要
//    @Bean(name = "cloudBebaseTemplate")
//    public JdbcTemplate cloudBebaseTemplate(@Qualifier(value = "cloudBebaseDataSource") DataSource bebaseDataSource) {
//        return new JdbcTemplate(bebaseDataSource);
//    }

    // 创建数据源
    @Bean(name = "thirdTestDataSource")
    @ConfigurationProperties(prefix="datasource.third")
    public DataSource cloudBebaseDataSource() {
        return DataSourceBuilder.create().build();
    }
}
