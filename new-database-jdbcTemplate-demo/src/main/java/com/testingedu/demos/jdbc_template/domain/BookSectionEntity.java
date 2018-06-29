package com.testingedu.demos.jdbc_template.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "course_candidate_task_word")
public class BookSectionEntity {
    //    course_candidate_recommend_top
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_id")
    private String courseId;

    private String type;        // 核心课程 | 拔高课程
    private String grade;       // 适用年级

    @Column(name = "grade_index")
    private Long gradeIndex;
    private Long bundle;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "flag_paid")
    private Boolean flagPaid;
    private String difficulty;


//    course_candidate_task_core
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String courseId;
//
//    private Long gradeIndex;
//    private Long bundle;
//
//    private Boolean flagPaid;

//    course_candidate_task_word
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String courseId;
//
//    private Long gradeIndex;
//    private Long bundle;
}
