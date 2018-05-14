package com.testingedu.oto_fk.entity;


import javax.persistence.*;


@Entity
@Table(name = "card")
public class Card {
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
