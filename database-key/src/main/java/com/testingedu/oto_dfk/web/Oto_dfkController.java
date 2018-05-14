package com.testingedu.oto_dfk.web;

import com.testingedu.oto_dfk.entity.Card;
import com.testingedu.oto_dfk.entity.Student;
import com.testingedu.oto_dfk.service.Oto_dfkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Oto_dfkController {
    @Autowired
    Oto_dfkService oto_dfkService;

    @RequestMapping(value = "/oto_dfk/savestudent", method = RequestMethod.POST)
    public void saveStudent(Student student) {
        Card card = new Card();
        card.setCid(123333333);

        Student s1 = new Student();
        s1.setSname("lucy");
        s1.setCid(card);
        oto_dfkService.saveStudent(s1);
    }

    @RequestMapping(value = "/oto_dfk/savecard", method = RequestMethod.POST)
    public void saveCard(Card card) {
        Student s1 = new Student();
        s1.setSname("mame");

        Card c = new Card();
        c.setCid(1233322222);
        c.setSid(s1);
        oto_dfkService.saveCard(c);
    }
    @RequestMapping(value = "/oto_dfk/findall",method = RequestMethod.POST)
    public List<Student> find(){

      return  oto_dfkService.findByName("mame");
    }
}