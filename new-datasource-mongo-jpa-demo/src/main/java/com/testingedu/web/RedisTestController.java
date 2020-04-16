package com.testingedu.web;

import com.testingedu.service.RedisTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RedisTestController {

    @Autowired
    private RedisTestService redisTestService;


    @RequestMapping(value = "/redisRequest")
    public Object getTestInnerInterceptor() {
        try {
            redisTestService.findUser(22);
            return ResponseEntity.ok().body("ok");

        } catch (Exception e) {
            log.error("Redis test controller, redis request error.", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
