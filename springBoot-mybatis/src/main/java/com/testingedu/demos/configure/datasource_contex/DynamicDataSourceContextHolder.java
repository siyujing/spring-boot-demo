//package com.testingedu.demos.configure.datasource_contex;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.Assert;
//
///**
// * 定义一个ContextHolder, 用于保存当前线程使用的数据源名
// */
//@Slf4j
//public class DynamicDataSourceContextHolder {
//
//    /**
//     * 默认数据源
//     */
//    public static final String DEFAULT_DS = "TITANMASTER";
//
//    /**
//     * 管理所有的数据源id;
//     * 主要是为了判断数据源是否存在;
//     */
//    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
//
//    // 设置数据源名
//    public static void setDataSourceType(String dataSourceType) {
//        Assert.notNull(dataSourceType, "+++DynamicDataSourceContextHolder, param DataSourceType cannot be null");
//
//        contextHolder.set(dataSourceType);
//        log.debug("+++DataSource is [{}]", dataSourceType);
//    }
//
//    // 获取数据源名
//    public static String getDataSourceType() {
//        log.debug("+++get datasource [{}]",contextHolder.get());
//        return (contextHolder.get());
//    }
//
//    // 清除数据源名
//    public static void clearDataSourceType() {
//        contextHolder.remove();
//    }
//
//}
