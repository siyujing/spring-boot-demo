package com.testingedu.domain.mysql;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new_book")
@Data
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public BookEntity(){

    }

    public BookEntity(String name){
        this.name = name;
    }
}