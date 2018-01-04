package com.testingedu;

import com.testingedu.jdbcdemo.domain.jpa.Card;
import com.testingedu.jdbcdemo.domain.jpa.Student;
import com.testingedu.jdbcdemo.service.CardService;
import com.testingedu.jdbcdemo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.common.collect.Lists;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseKeyApplicationTests {

    @Autowired
    StudentService studentService;

    @Autowired
    CardService cardService;

    @Test
    public void contextLoads() {
        Student student= new Student("xiaoming");
        Card card = new Card(888);
        Student student1 = new Student("xiaoming",card);
        studentService.SaveAllStudent(Lists.newArrayList(student1));
    }

    @Test
    public void contextLoads2() {
        Card card = new Card(888);
        cardService.saveCard(Lists.newArrayList(card));
    }

}
