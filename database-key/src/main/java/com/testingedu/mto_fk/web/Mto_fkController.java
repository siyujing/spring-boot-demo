//package com.testingedu.mto_fk.web;
//
//import com.testingedu.mto_fk.entity.Classroom;
//import com.testingedu.mto_fk.entity.Student;
//import com.testingedu.mto_fk.service.Mto_fkService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by boxfish on 17/1/9.
// */
//@RestController
//public class Mto_fkController {
//    @Autowired
//    Mto_fkService otm_fkService;
//
//    @RequestMapping(value = "/mto_fk/savestudent",method = RequestMethod.POST)
//    public void saveStudent(Student student){
//        otm_fkService.saveStudent(student);
//    }
//    @RequestMapping(value = "/saveclassroom",method = RequestMethod.POST)
//    public void saveClassroom(Classroom classroom){
////        Classroom classroom1 = new Classroom();
////        classroom1.setCid(100);
//
//        Classroom c1=new Classroom();
//        c1.setCname("2班");
//
//        Student s1=new Student();
//        s1.setSname("hh");
//        s1.setCid(c1);
//
//        Student s2=new Student();
//        s2.setSname("rr");
//        s2.setCid(c1);
//
//
//        System.out.println("存储");
//        otm_fkService.saveStudent(s1);
//        otm_fkService.saveStudent(s2);
//    }
//
//}
