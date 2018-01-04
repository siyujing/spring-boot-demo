package com.testingedu.mto_fk.entity;

import javax.persistence.*;

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

    public void setCid(Integer cid) {
        this.id = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {
        return id;
    }

    public String getCname() {
        return cname;
    }

    public Classroom() {
    }

    public Classroom(String cname) {
        this.cname = cname;
    }
}
