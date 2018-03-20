package com.testingedu.demos.jdbc_template.mongo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.util.List;

@Data
@Document(collection = "course_tag_homework_longze")
public class HomeWorkTag {

    private String publication;
    private String grade;
    private String bookSection;

    @Id
    @JsonIgnore
    private String id;

    private String bookSectionId;

    @Transient
    private String bookSectionName;

    private String courseName;

    private String alias;

    private String courseTitle;

    private String cover;

    private Integer price;

    //是否加入智能推荐
    private boolean recommend = false;

    //应用类型
    private String[] applyType = {"student", "teacher"};

    //课程类型（单选）
    private List<String> courseType;

    //考试类型
    private List<String> examType;

    //五道口难度
    @JsonProperty("difficulty")
    private List<String>courseLevel;

    @JsonIgnore
    private List<String>difficulty;

    //适合年龄
    private List<String> fitAge = Lists.newArrayList("幼儿", "小学", "中学", "成人");

    //适合年龄(外教课使用)
    //后来沿用旧的适合年龄
//    private List<String> fitAgeForForeigner = Lists.newArrayList("小学", "中学", "成人");

    private List<String> channel;

    //标签是否完整 0 表示未打过标签，1 表示打了部分标签， 2 表示完成
    private boolean isComplete = false;

    //该课是否置顶
    private boolean stick = false;

    //置顶开始时间
    private Long stickStartTime;

    //置顶结束时间
    private Long stickEndTime;

    //是否有版权许可
    private boolean license = false;

    //是否使用于在线授课
    private boolean onlineTeaching = false;

    //语法强序使用
    private Bundle bundle;

    // level0强序使用
//    private Association association;

    //课程最后修改时间
    private Long lastModified;

    //课程出版时间,用于优先推送使用
    private Long publicDate;

    //以下应逯岩要求
    //开发难度
//    private List<String> devDifficulty;
    //
    private List<String>devCourseLevel;

    //开发难度
    private List<String> devCourseType;

    //开发版权
    private List<String> devLicense = Lists.newArrayList("FALSE");

    private List<String> sentenceLabels;

    //综合能力,国际课程
    private List<String> abilitySystems;

    //语言单项
    private List<String> courseTypeV2;

    // 幼儿园课程主从关系标注
    private String kindergartenType;

    private Boolean demo;


    @Data
    public static class Bundle {

        private String bundleName;

        private String bundleId;

        private Integer bundleOrder;

    }
}
