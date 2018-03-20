package com.testingedu.otm_dfk.web;

import com.testingedu.otm_dfk.entity.Classroom;
import com.testingedu.otm_dfk.entity.Student;
import com.testingedu.otm_dfk.service.Otm_dfkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boxfish on 17/1/9.
 */
@RestController
public class Otm_dfkController {
    @Autowired
    Otm_dfkService otm_fkService;

    @RequestMapping(value = "/savestudent",method = RequestMethod.POST)
    public void saveStudent(Student student){

        Classroom c1=new Classroom();
        c1.setCname("aa");
        Student s1=new Student();
        s1.setSname("hh");
        s1.setCid(c1);
        Student s2=new Student();
        s2.setSname("rr");
        s2.setCid(c1);

        System.out.println("student存储");

        otm_fkService.saveStudent(s1);
        otm_fkService.saveStudent(s2);
    }
    @RequestMapping(value = "/saveclassroom",method = RequestMethod.POST)
    public void saveClassroom(Classroom classroom){
//        Classroom classroom1 = new Classroom();
//        classroom1.setCid(100);

        Student s1=new Student();
        s1.setSname("hh2");
        Student s2=new Student();
        s2.setSname("rr2");
        List<Student> slist=new ArrayList<Student>();
        slist.add(s1);
        slist.add(s2);
        Classroom c1=new Classroom();
        c1.setCname("aa2");
        System.out.println("classroom存储");
        c1.setList(slist);
        otm_fkService.saveClassroom(c1);
    }

}
