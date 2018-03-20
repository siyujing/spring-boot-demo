package com.testingedu.mtm_dfk.web;

import com.testingedu.mtm_dfk.entity.Student;
import com.testingedu.mtm_dfk.entity.Teacher;
import com.testingedu.mtm_dfk.service.Mtm_dfkService;
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
public class Mtm_dfkController {
    @Autowired
    Mtm_dfkService mtm_dfkService;

    @RequestMapping(value = "/mtm_dfk/savestudent",method = RequestMethod.POST)
    public void saveStudent(Student student){
        Teacher t1=new Teacher();
        t1.setTname("数学老师");

        Teacher t2=new Teacher();
        t1.setTname("语文老师");
        List<Teacher> teacherList=new ArrayList<Teacher>();

        teacherList.add(t1);
        teacherList.add(t2);

        Student s1=new Student();
        s1.setTeacherList_fk(teacherList);
        s1.setSname("hh");
        mtm_dfkService.saveStudent(s1);
    }
    @RequestMapping(value = "/saveteacher",method = RequestMethod.POST)
    public void saveTeacher(Teacher classroom){
//        Classroom classroom1 = new Classroom();
//        classroom1.setCid(100);

        Student s1=new Student();
        s1.setSname("小米");

        List<Student> studentList=new ArrayList<Student>();

        studentList.add(s1);

        Teacher teacher=new Teacher();
        teacher.setTname("英语");
        teacher.setStudentList_id(studentList);


        System.out.println("存储");
        mtm_dfkService.saveTeacher(teacher);
    }

}
