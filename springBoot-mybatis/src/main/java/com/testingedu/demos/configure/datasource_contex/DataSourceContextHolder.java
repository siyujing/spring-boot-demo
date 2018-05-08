package com.testingedu.demos.configure.datasource_contex;

import lombok.extern.slf4j.Slf4j;

/**
 * 定义一个ContextHolder, 用于保存当前线程使用的数据源名
 * */
@Slf4j
public class DataSourceContextHolder {

    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "titan-master";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
//    private static final ThreadLocal<DynamicDataSourceGlobal> contextHolder = new ThreadLocal<DynamicDataSourceGlobal>();

    // 设置数据源名
    public static void setDB(String dbType) {
        log.debug("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        log.debug("DataSourceContextHolder [{}]",contextHolder.get());
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
