package com.testingedu.otm_fk.service;

import com.testingedu.otm_fk.entity.Classroom;
import com.testingedu.otm_fk.entity.Student;
import com.testingedu.otm_fk.entity.jpa.ClassroomRepository;
import com.testingedu.otm_fk.entity.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by boxfish on 17/1/9.
 */
@Service
//        (value = "otm_fk_Service")
public class Otm_fkService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassroomRepository classroomRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }
    public void saveClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }
}
