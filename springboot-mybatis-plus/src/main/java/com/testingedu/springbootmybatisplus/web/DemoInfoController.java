package com.testingedu.springbootmybatisplus.web;

import com.testingedu.springbootmybatisplus.service.IDemoInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value = "/demo_info/page/{num}/{size}", method = RequestMethod.GET)
    public Object selectPage(@PathVariable(name = "num") Integer pageNum, @PathVariable(name = "size") Integer size ) {
        try {
            return demoInfoService.selectDemoInfoPage(pageNum,size);
        } catch (Exception e) {
            log.error("delete error", e);
            return ResponseEntity.badRequest().body("error");
        }
    }
}
