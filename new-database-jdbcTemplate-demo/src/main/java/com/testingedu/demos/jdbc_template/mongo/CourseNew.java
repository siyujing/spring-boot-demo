package com.testingedu.demos.jdbc_template.mongo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Slf4j
@Data
@Document(collection = "course_new")
public class CourseNew {

    private String bookSectionId;
    private String courseName;                              // 课程名称，中文
    private String alias;                                   // 课程名称，英文
    private String cover;                                   // 课程封面
    private Integer price;                                  // 课程价格


    private String publication;
    private String grade;
    private String bookSection;

    //语法强序使用
    private Bundle bundle;

    private Long publicDate;                                // 发布日期
    private Long lastModified;                              // 修改日期

    private List<String> courseType;                        // 课程类型，内部
    private List<String> courseTypeV2;                      // 课程类型，显示
    private List<String> courseLevel;                       // 课程难度


    private List<String> abilitySystems;                    // 课程标注 能力体系
    private List<String> sentenceLabels;                    // 课程标注 句型

    private List<String> nationalKnowledge;                 // 知识点，教材大纲
    private List<String> internationalKnowledge;            // 知识点，国际课程


    @Data
    public static class Bundle {

        private String bundleName;

        private String bundleId;

        private Integer bundleOrder;

    }
}
