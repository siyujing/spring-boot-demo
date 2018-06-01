package com.testingedu.springbootmybatisplus.web;

import com.testingedu.springbootmybatisplus.service.IDemoInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DemoInfoController {
    @Autowired
    private IDemoInfoService demoInfoService;


    @RequestMapping(value = "/demo_info/all", method = RequestMethod.GET)
    public Object getDemoInfoBySql() {
        try {
            return demoInfoService.selectListBySql();
        } catch (Exception e) {
            log.error("get user error", e);
            return ResponseEntity.badRequest().body("error");
        }
    }

    @RequestMapping(value = "/demo_info/delete", method = RequestMethod.POST)
    public Object deleteAll() {
        try {
            return demoInfoService.deleteAll();
        } catch (Exception e) {
            log.error("delete error", e);
            return ResponseEntity.badRequest().body("error");
        }
    }
}
