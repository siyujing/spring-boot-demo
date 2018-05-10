//package com.testingedu.demos.configure.datasource_aop;
//
//import com.testingedu.demos.configure.datasource_contex.DynamicDataSourceContextHolder;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
//
//@Aspect
//@Slf4j
//@Component
//public class DynamicDataSourceAspect {
//
//    @Before("@annotation(Ds)")
//    public void beforeSwitchDS(JoinPoint point) {
//        log.info("+++DynamicDataSourceAspect before,[{}]", point);
//        //获得当前访问的class
//        Class<?> className = point.getTarget().getClass();
//
//        //获得访问的方法名
//        String methodName = point.getSignature().getName();
//        //得到方法的参数的类型
//        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
//        String dataSource = DynamicDataSourceContextHolder.DEFAULT_DS;
//        try {
//            // 得到访问的方法对象
//            Method method = className.getMethod(methodName, argClass);
//
//            // 判断是否存在@DS注解
//            if (method.isAnnotationPresent(Ds.class)) {
//                Ds annotation = method.getAnnotation(Ds.class);
//                // 取出注解中的数据源名
//                dataSource = annotation.value();
//            }
//
//        } catch (Exception e) {
//            log.error("+++DynamicDataSourceAspect, beforeSwitchDs error", e);
//        }
//
//        // 切换数据源
//        DynamicDataSourceContextHolder.setDataSourceType(dataSource);
//    }
//
//    @After("@annotation(Ds)")
//    public void afterSwitchDS(JoinPoint point) {
//        log.debug("+++DynamicDataSourceAspect after,[{}]", point);
//        DynamicDataSourceContextHolder.clearDataSourceType();
//
//    }
//}
