package com.alibaba.druid.spring.boot.autoconfigure.stat;

import com.alibaba.druid.spring.boot.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@ConditionalOnWebApplication
@ConditionalOnProperty(name = "spring.datasource.druid.stat-view-servlet.enabled", havingValue = "true", matchIfMissing = true)
public class DruidStatViewServletConfiguration {
    @Bean
    public ServletRegistrationBean statViewServletRegistrationBean(DruidStatProperties properties) {
        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new StatViewServlet());
        registrationBean.addUrlMappings(config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*");
        if (config.getAllow() != null) {
            registrationBean.addInitParameter("allow", config.getAllow());
        }
        if (config.getDeny() != null) {
            registrationBean.addInitParameter("deny", config.getDeny());
        }
        if (config.getLoginUsername() != null) {
            registrationBean.addInitParameter("loginUsername", config.getLoginUsername());
        }
        if (config.getLoginPassword() != null) {
            registrationBean.addInitParameter("loginPassword", config.getLoginPassword());
        }
        if (config.getResetEnable() != null) {
            registrationBean.addInitParameter("resetEnable", config.getResetEnable());
        }
        return registrationBean;
    }
}
