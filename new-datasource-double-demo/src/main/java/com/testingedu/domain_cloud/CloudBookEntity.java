package com.testingedu.domain_cloud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new_book")
public class CloudBookEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public CloudBookEntity(){

    }

    public CloudBookEntity(String name){
        this.name = name;
    }
}
