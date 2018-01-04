package com.testingedu.jdbcdemo.domain.jpa;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "card")
@Data
public class Card implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer cid;

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Card(Integer cid) {
        this.cid = cid;
    }

    public Card() {
    }
}