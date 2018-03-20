package com.testingedu.otm_fk.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by boxfish on 17/1/9.
 */
@Entity
@Table(name = "classroom")
@Cacheable
public class Classroom {
    @Id
    @GeneratedValue
    private Integer cid;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    List<Student> list;
    private String cname;

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public List<Student> getList() {
        return list;
    }

    public String getCname() {
        return cname;
    }

    public Classroom() {
    }

    public Classroom(String cname) {
        this.cname = cname;
    }

    public Classroom(List<Student> list, String cname) {
        this.list = list;
        this.cname = cname;
    }

    public Classroom(List<Student> list) {
        this.list = list;
    }
}
