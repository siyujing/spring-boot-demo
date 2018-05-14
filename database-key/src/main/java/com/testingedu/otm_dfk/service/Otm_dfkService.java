package com.testingedu.otm_dfk.service;

import com.testingedu.otm_dfk.entity.Classroom;
import com.testingedu.otm_dfk.entity.Student;
import com.testingedu.otm_dfk.entity.jpa.ClassroomRepository;
import com.testingedu.otm_dfk.entity.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//        (value = "otm_fk_Service")
public class Otm_dfkService {
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
