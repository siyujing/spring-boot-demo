//package com.testingedu.demos.configure.datasource_aop;
//
//import com.testingedu.demos.configure.datasource_contex.DataSourceContextHolder;
//import lombok.extern.slf4j.Slf4j;
//import org.mp4parser.aspectj.lang.JoinPoint;
//import org.mp4parser.aspectj.lang.annotation.After;
//import org.mp4parser.aspectj.lang.annotation.Aspect;
//import org.mp4parser.aspectj.lang.annotation.Before;
//import org.mp4parser.aspectj.lang.reflect.MethodSignature;
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
//        log.debug("DynamicDataSourceAspect before,[{}]",point);
//        //获得当前访问的class
//        Class<?> className = point.getTarget().getClass();
//
//        //获得访问的方法名
//        String methodName = point.getSignature().getName();
//        //得到方法的参数的类型
//        Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
//        String dataSource = DataSourceContextHolder.DEFAULT_DS;
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
//            e.printStackTrace();
//        }
//
//        // 切换数据源
//        DataSourceContextHolder.setDB(dataSource);
//
//    }
//
//    @After("@annotation(Ds)")
//    public void afterSwitchDS(JoinPoint point) {
//        log.debug("DynamicDataSourceAspect after,[{}]",point);
//        DataSourceContextHolder.clearDB();
//
//    }
//}
