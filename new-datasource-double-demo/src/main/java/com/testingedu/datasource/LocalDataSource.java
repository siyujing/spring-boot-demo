package com.testingedu.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by boxfish on 17/9/12.
 */
@Configuration
public class LocalDataSource {

    // 使用jdbcTempalate 操作时,可以打开注释,直接注入该Bean,双数据源不需要
//    @Bean(name = "jdbcBebaseTemplate")
//    @Primary
//    public JdbcTemplate jdbcBebaseTemplate(@Qualifier(value = "localBebaseDataSource") DataSource bebaseDataSource) {
//        return new JdbcTemplate(bebaseDataSource);
//    }

    // 配置数据源
    @Bean(name = "localBebaseDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.bebase")
    public DataSource bebaseDataSource() {
        return DataSourceBuilder.create().build();
    }

}
