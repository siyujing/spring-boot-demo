package com.testingedu.oto_dfk.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String sname;

    @OneToOne(cascade = CascadeType.ALL)//强级联关系
    @JoinColumn(name = "card_fk",unique = true)
//    @JoinTable(name = "sd",JoinColumns = {@JoinColumn(name = "cid")} )
    private Card cid;

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setCid(Card cid) {
        this.cid = cid;
    }

    public String getSname() {
        return sname;
    }

    public Card getCid() {
        return cid;
    }

    public Student() {
    }
}
