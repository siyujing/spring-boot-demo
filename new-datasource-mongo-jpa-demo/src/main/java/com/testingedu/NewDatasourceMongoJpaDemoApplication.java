package com.testingedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NewDatasourceMongoJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewDatasourceMongoJpaDemoApplication.class, args);
    }
}
