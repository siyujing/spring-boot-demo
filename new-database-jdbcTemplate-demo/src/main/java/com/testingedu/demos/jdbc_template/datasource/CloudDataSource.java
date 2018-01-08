package com.testingedu.demos.jdbc_template.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class CloudDataSource {
    // 使用jdbcTempalate 操作,直接注入该Bean
    @Bean(name = "cloudBebaseTemplate")
    public JdbcTemplate cloudBebaseTemplate(@Qualifier(value = "cloudBebaseDataSource") DataSource bebaseDataSource) {
        return new JdbcTemplate(bebaseDataSource);
    }

    @Bean(name = "cloudBebaseDataSource")
    @ConfigurationProperties(prefix="datasource.cloud")
    public DataSource cloudBebaseDataSource() {
        return DataSourceBuilder.create().build();
    }
}
