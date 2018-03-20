package com.testingedu.oto_fk.web;

import com.testingedu.oto_fk.entity.Card;
import com.testingedu.oto_fk.entity.Student;
import com.testingedu.oto_fk.service.Oto_fkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oto_fkController {
    @Autowired
    Oto_fkService oto_fkService;

    @RequestMapping(value = "/oto_fk/savestudent", method = RequestMethod.POST)
    public void saveStudent(Student student) {
        Card card = new Card();
        card.setCid(123333333);

        Student s1 = new Student();
        s1.setSname("lucy");
        s1.setCid(card);
        oto_fkService.saveStudent(s1);
    }
    @RequestMapping(value = "/oto_fk/updatestudent", method = RequestMethod.POST)
    public int updateByStudentId(){
        return oto_fkService.updateByStudentId("小明",2);
    }

    @RequestMapping(value = "/oto_fk/deletestudent", method = RequestMethod.POST)
    public int deleteByStudentId(){
        return oto_fkService.deleteBySname("小明");
    }
}