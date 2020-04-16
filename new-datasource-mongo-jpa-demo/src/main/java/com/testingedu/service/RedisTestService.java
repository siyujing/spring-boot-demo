package com.testingedu.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Slf4j
@Service
public class RedisTestService {

    @Cacheable(cacheNames = "thisredis", key = "'users_'+#id")
    public User findUser(Integer id) {
        User user = new User();
        user.setUsername("hlhdidi");
        user.setPassword("123");
        user.setUid(id.longValue());
        System.out.println("log4j2坏啦?");
        log.info("输入user,用户名:{},密码:{}", user.getUsername(), user.getPassword());
        return user;
    }

    @CacheEvict(value = "thisredis", key = "'users_'+#id", condition = "#id!=1")
    public void delUser(Integer id) {
        // 删除user
        System.out.println("user删除");
    }

    @Data
    public static class User implements Serializable {
        String username;
        String password;
        Long uid;
    }
}
