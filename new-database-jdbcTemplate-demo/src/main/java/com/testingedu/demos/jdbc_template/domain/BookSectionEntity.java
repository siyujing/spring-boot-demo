package com.testingedu.demos.jdbc_template.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "course_candidate_task_core")
public class BookSectionEntity {
    //    course_candidate_online
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Column(name = "course_id")
//    private String courseId;
//    private String type;
//    private String stage;       // 阶段
//    private Long bundle;
//    @Column(name = "project_name")
//    private String projectName;
//    @Column(name = "flag_paid")
//    private Boolean flagPaid;
//    private String difficulty;
//    @Column(name = "label_type")
//    private String labelType;   // 书架位置
//    @Column(name = "knowledge_type")
//    private String knowledgeType;


    //    course_candidate_task_core
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course_id")
    private String courseId;
    private Long bundle;
    private String grade;       // 适用年级
    @Column(name = "grade_index")
    private Long gradeIndex;
    private String type;
    @Column(name = "label_type")
    private String labelType;   //
    @Column(name = "knowledge_type")
    private String knowledgeType;
    @Column(name = "flag_paid")
    private Boolean flagPaid;
    private String difficulty;
    @Column(name = "project_name")
    private String projectName;

    //  course_candidate_task_word
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Column(name = "course_id")
//    private String courseId;
//    @Column(name = "project_name")
//    private String projectName;
//    private String grade;       // 适用年级
//    @Column(name = "grade_index")
//    private Long gradeIndex;
//    private Long bundle;

}
