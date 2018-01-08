package com.testingedu.domain.nosql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "course_label_longze")
public class CourseLabelEntity {
    @Id
    @JsonIgnore
    private String id;

    // 基本属性
    private String courseId;
    private String courseNameChinese;
    private String courseNameEnglish;
}
