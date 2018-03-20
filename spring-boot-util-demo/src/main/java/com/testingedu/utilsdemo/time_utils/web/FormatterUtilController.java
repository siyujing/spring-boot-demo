package com.testingedu.utilsdemo.time_utils.web;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatterUtilController {

    @RequestMapping(value = "/time")
    public Object getTime(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") DateTime startTime){
        try {
            System.out.println(startTime);
            return ResponseEntity.ok().body(startTime);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest();
        }
    }
}
