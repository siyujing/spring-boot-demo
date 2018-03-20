package com.testingedu.domain_local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new_book")
public class LocalBookEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public LocalBookEntity(){

    }

    public LocalBookEntity(String name){
        this.name = name;
    }
}
