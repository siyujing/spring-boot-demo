package com.testingedu.demos.jdbc_template.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class LocalDataSource {

    // 使用jdbcTempalate 操作,直接注入该Bean
    @Bean(name = "jdbcBebaseTemplate")
    @Primary
    public JdbcTemplate jdbcBebaseTemplate(@Qualifier(value = "localBebaseDataSource") DataSource bebaseDataSource) {
        return new JdbcTemplate(bebaseDataSource);
    }

    @Bean(name = "localBebaseDataSource")
    @Primary
    @ConfigurationProperties(prefix="datasource.bebase")
    public DataSource bebaseDataSource() {
        return DataSourceBuilder.create().build();
    }

}
