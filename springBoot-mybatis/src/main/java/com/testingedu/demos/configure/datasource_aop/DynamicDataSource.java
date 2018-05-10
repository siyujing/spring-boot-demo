//package com.testingedu.demos.configure.datasource_aop;
//
//import com.testingedu.demos.configure.datasource_contex.DynamicDataSourceContextHolder;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//@Slf4j
//public class DynamicDataSource extends AbstractRoutingDataSource {
//
//    @Override
//    protected Object determineCurrentLookupKey() {
//
//        log.debug("+++DynamicDataSource");
//        return DynamicDataSourceContextHolder.getDataSourceType();
//
//    }
//}
