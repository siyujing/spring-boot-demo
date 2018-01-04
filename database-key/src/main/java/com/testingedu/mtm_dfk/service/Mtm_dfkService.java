package com.testingedu.mtm_dfk.service;

import com.testingedu.mtm_dfk.entity.Student;
import com.testingedu.mtm_dfk.entity.Teacher;
import com.testingedu.mtm_dfk.entity.jpa.StudentRepository;
import com.testingedu.mtm_dfk.entity.jpa.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by boxfish on 17/1/9.
 */
@Service
//        (value = "otm_fk_Service")
public class Mtm_dfkService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
