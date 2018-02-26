package com.testingedu.demos.jdbc_template.domain;

import com.testingedu.demos.jdbc_template.mongo.CourseNew;
import com.testingedu.demos.jdbc_template.protocol.Course;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "book_national",
        indexes = {
                @Index(name = "index_publication_grade_bookSection_courseId", columnList = "publication,grade,book_section,course_id", unique = true)
        }
)
public class KeysNationalEntity {

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



    public void fromCourseNew(CourseNew course) {
        this.courseId = course.getBookSectionId();
        this.courseName = course.getCourseName();
        this.courseType = Course.Type.convert(course.getCourseType().get(0));
        this.courseTypeV2 = Course.Type.convert(course.getCourseTypeV2().get(0));
        this.courseDifficulty = Course.Difficulty.parse(course.getCourseLevel().get(0));
//        this.bundleOrder = Long.parseLong(course.getBundle().getBundleOrder().toString());
        this.bookSection = course.getBookSection();
//        this.publication = course.getPublication();
//        this.grade = course.getGrade();
    }

    public void fromBookSectionKnowledge(){

    }
}
