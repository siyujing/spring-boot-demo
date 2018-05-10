package com.testingedu.demos.web;

import com.github.pagehelper.PageInfo;
import com.testingedu.demos.page.BaseEntity;
import com.testingedu.demos.service_demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public void getName1(){
        userService.getName1();
    }
    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public void getName2(){
        userService.getName2();
    }
    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public void getName3(){
        userService.getName1();
        userService.getName2();
    }
    @RequestMapping(value = "/test4",method = RequestMethod.GET)
    public void getName4(){
        userService.getName3Trans();
    }

    @RequestMapping(value = "/test4",method = RequestMethod.POST)
    public Object getName5(@RequestBody BaseEntity.Range range){
        PageInfo page = userService.selectAll(range);
        return page;
    }
}
