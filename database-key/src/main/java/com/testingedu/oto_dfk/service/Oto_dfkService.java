package com.testingedu.oto_dfk.service;

import com.testingedu.oto_dfk.entity.Card;
import com.testingedu.oto_dfk.entity.Student;
import com.testingedu.oto_dfk.entity.jpa.CardRepository;
import com.testingedu.oto_dfk.entity.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by boxfish on 17/1/9.
 */
@Service
//        (value = "otm_fk_Service")
public class Oto_dfkService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CardRepository cardRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);
    }
    public void saveCard(Card card) {
        cardRepository.save(card);
    }
    public List<Student> findByName(String sname){
        return studentRepository.findByName(sname);
    }
}
