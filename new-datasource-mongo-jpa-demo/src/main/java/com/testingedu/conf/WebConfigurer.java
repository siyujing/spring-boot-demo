package com.testingedu.conf;


import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.testingedu.interceptor.InnerAccessInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Slf4j
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 请求参数 客户端请求参数输入流 和Java 对象之间转换
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converters.add(converter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InnerAccessInterceptor()).addPathPatterns("/inner/**"); //后台
    }
}
