package com.testingedu.demos.jdbc_template.domain;

import com.testingedu.demos.jdbc_template.protocol.Course;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "homework_candidate_courses",
        indexes = {
                @Index(name = "index_publication_grade_courseId", columnList = "publication,grade,course_id", unique = true)
        }
)
public class HomeworkCandidateCoursesEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String publication;         // 教材版本
    private String grade;               // 适用年级

    @Column(name = "book_section")
    private String bookSection;         // 单元

    @Column(name = "bundle_order")
    private Long bundleOrder;           // 序号

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "course_name")
    private String courseName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "course_type", columnDefinition = "varchar(255) default 'TEXTBOOK'")
    private Course.Type courseType;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "course_type_v2", columnDefinition = "varchar(255) default 'TEXTBOOK'")
    private Course.Type courseTypeV2;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "course_difficulty")
    private Course.Difficulty courseDifficulty;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "create_time")
    private DateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "update_time")
    private DateTime updateTime;


    public Course toCourse() {
        Course course = new Course();
        course.setCourseId(courseId);

        course.setPublication(publication);
        course.setGrade(grade);
        course.setBookUnit(bookSection);

        course.setCourseName(courseName);
        course.setType(courseType);
        course.setTypeV2(courseTypeV2);
        course.setDifficulty(courseDifficulty);
        return course;
    }

    public void fromCourse(Course course) {
        this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.courseType = course.getType();
        this.courseTypeV2 = course.getTypeV2();
        this.courseDifficulty = course.getDifficulty();
    }
}
