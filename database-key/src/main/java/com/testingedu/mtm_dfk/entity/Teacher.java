package com.testingedu.mtm_dfk.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
@Cacheable
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tname;
    @ManyToMany(mappedBy = "teacherList_fk")
    private List<Student> studentList_id;

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setStudentList_id(List<Student> studentList_id) {
        this.studentList_id = studentList_id;
    }

    public Teacher(String tname, List<Student> studentList_id) {
        this.tname = tname;
        this.studentList_id = studentList_id;
    }

    public Teacher() {
    }
}

