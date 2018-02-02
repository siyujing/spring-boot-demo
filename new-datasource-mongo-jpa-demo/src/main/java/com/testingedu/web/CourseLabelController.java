package com.testingedu.web;

import com.testingedu.handler.CourseLabelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseLabelController {

    @Autowired
    private CourseLabelHandler courseLabelHandler;


    @RequestMapping(value = "/label/one/get", method = RequestMethod.GET)
    public Object findOneByCourseNameChinese() {
        try {
            return courseLabelHandler.findOneByCourseNameChinese("huahua");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e);
        }
    }
}
