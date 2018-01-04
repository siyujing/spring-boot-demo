package com.testingedu.otm_dfk.entity;

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
    private Integer id;
    private String cname;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn(name = "list")
    List<Student> list;

    public void setCid(Integer cid) {
        this.id = cid;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {
        return id;
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
