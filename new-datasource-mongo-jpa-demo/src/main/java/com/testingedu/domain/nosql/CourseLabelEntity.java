package com.testingedu.domain.nosql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Document(collection = "course_label_syj")
@CompoundIndexes({
        @CompoundIndex(name = "label_index_courseId", def = "{'courseId': 1}", unique = true),
        @CompoundIndex(name = "label_index_courseId_courseNameChinese", def = "{'courseId': 1,'courseNameEnglish': 1}")
})
public class CourseLabelEntity {
    @Id
    @JsonIgnore
    private String id;

    // 基本属性
    private String courseId;
    private String courseNameChinese;
    private String courseNameEnglish;

    private List<String> devKeysInternational;

    private String operaName;

    private DateTime createTime;
    private DateTime updateTime;
}
