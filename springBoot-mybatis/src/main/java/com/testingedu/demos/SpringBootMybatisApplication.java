package com.testingedu.demos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
//注册动态多数据源
//@Import({DynamicDataSourceRegister.class})
@Slf4j
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
            SpringApplication.run(SpringBootMybatisApplication.class, args);
    }
}
