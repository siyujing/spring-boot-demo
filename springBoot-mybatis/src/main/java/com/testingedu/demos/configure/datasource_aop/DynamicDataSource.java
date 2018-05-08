package com.testingedu.demos.configure.datasource_aop;

import com.testingedu.demos.configure.datasource_contex.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Configuration
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Autowired
    @Qualifier("titanMasterDS")
    private DataSource titanDataSource;

    @Autowired
    @Qualifier("ds2")
    private DataSource ds2DataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("+++------------");
        log.debug("数据源为[{}]", DataSourceContextHolder.getDB());

        return DataSourceContextHolder.getDB();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     */
    @Bean(name = "dynamicDS1")
    public DataSource dataSource() {
        // 默认数据源
        log.debug("daraSource1=" + titanDataSource);
        super.setDefaultTargetDataSource(titanDataSource);

        // 配置多数据源
        Map dsMap = new HashMap<>();
        dsMap.put("titan-master", titanDataSource);
        dsMap.put("ds2", ds2DataSource);

        super.setTargetDataSources(dsMap);
        return this;
    }
}
