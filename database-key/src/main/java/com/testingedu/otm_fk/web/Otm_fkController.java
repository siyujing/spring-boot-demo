package com.testingedu.otm_fk.web;

import com.testingedu.otm_fk.entity.Classroom;
import com.testingedu.otm_fk.entity.Student;
import com.testingedu.otm_fk.service.Otm_fkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Otm_fkController {
    @Autowired
    Otm_fkService otm_fkService;

    @RequestMapping(value = "/savestudent",method = RequestMethod.POST)
    public void saveStudent(Student student){
        otm_fkService.saveStudent(student);
    }
    @RequestMapping(value = "/saveclassroom",method = RequestMethod.POST)
    public void saveClassroom(Classroom classroom){
//        Classroom classroom1 = new Classroom();
//        classroom1.setCid(100);

        Student s1=new Student();
        s1.setSname("hh");
        Student s2=new Student();
        s2.setSname("rr");
        List<Student> slist=new ArrayList<Student>();
        slist.add(s1);
        slist.add(s2);
        Classroom c1=new Classroom();
        c1.setCname("aa");
        System.out.println("存储");
        c1.setList(slist);
        otm_fkService.saveClassroom(c1);
    }

}
