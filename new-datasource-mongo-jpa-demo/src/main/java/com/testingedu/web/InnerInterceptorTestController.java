package com.testingedu.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class InnerInterceptorTestController {

    @RequestMapping(value = "/inner")
    public Object getTestInnerInterceptor(){
        return ResponseEntity.ok().body("ok");
    }
}
