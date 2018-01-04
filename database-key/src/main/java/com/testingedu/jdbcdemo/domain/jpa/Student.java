package com.testingedu.jdbcdemo.domain.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String sname;

    @OneToOne(cascade = CascadeType.ALL)//强级联关系
    @JoinColumn(name = "cid")
    private Card cid;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setCid(Card cid) {
        this.cid = cid;
    }

    public Integer getId() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public Card getCid() {
        return cid;
    }

    public Student(String sname, Card cid) {
        this.sname = sname;
        this.cid = cid;
    }

    public Student(String sname) {
        this.sname = sname;
    }

    public Student() {
    }
}
