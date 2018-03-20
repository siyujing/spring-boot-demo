package com.testingedu.mto_fk.entity;

import javax.persistence.*;

/**
 * Created by boxfish on 17/1/9.
 */
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String sname;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
//    ,referencedColumnName = "CID"
    Classroom cid;

    public Integer getSid() {
        return id;
    }

    public String getSname() {
        return sname;
    }

    public Classroom getCid() {
        return cid;
    }

    public void setCid(Classroom cid) {
        this.cid = cid;
    }

    public void setSid(Integer sid) {
        this.id = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Student(String sname) {
        this.sname = sname;
    }

    public Student(Classroom cid, String sname) {
        this.cid = cid;
        this.sname = sname;
    }

    public Student() {
    }
}
