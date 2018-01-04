package com.testingedu.mtm_dfk.entity;

import javax.persistence.*;
import java.util.List;

//学生主控
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String sname;
    @ManyToMany()
    @JoinColumn(name = "teacherList_id",unique = true)
    List<Teacher> teacherList_fk;

    public String getSname() {
        return sname;
    }

    public List<Teacher> getTeacherList_fk() {
        return teacherList_fk;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setTeacherList_fk(List<Teacher> teacherList_fk) {
        this.teacherList_fk = teacherList_fk;
    }

    public Student() {
    }

    public Student(List<Teacher> teacherList_fk, String sname) {
        this.teacherList_fk = teacherList_fk;
        this.sname = sname;
    }
}
