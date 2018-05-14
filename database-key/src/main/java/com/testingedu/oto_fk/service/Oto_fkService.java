package com.testingedu.oto_fk.service;

import com.testingedu.oto_fk.entity.Card;
import com.testingedu.oto_fk.entity.Student;
import com.testingedu.oto_fk.entity.jpa.CardJpaRepository;
import com.testingedu.oto_fk.entity.jpa.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//        (value = "otm_fk_Service")
public class Oto_fkService {
    @Autowired
    StudentJpaRepository studentJpaRepository;
    @Autowired
    CardJpaRepository cardRepository;

    public void saveStudent(Student student){
        studentJpaRepository.save(student);
    }
    public void saveCard(Card card) {
        cardRepository.save(card);
    }
    public int updateByStudentId(String sname,Integer id){
        return studentJpaRepository.updateByStudentId(sname,id);
    }
    public int deleteBySname(String name){
       return studentJpaRepository.deleteBySname(name);
    }
}
