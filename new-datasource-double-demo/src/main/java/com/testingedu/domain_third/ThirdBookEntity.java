package com.testingedu.domain_third;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new_book")
public class ThirdBookEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public ThirdBookEntity(){

    }

    public ThirdBookEntity(String name){
        this.name = name;
    }
}
