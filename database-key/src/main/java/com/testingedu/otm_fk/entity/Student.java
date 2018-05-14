package com.testingedu.otm_fk.entity;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;
    private  String sname;

    public Integer getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Student(String sname) {
        this.sname = sname;
    }

    public Student() {
    }
}
