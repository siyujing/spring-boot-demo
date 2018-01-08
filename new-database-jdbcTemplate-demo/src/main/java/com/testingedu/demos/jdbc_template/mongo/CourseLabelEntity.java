package com.testingedu.demos.jdbc_template.mongo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

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

    // 内容标注
    private List<LabelObject> keysInternational = new ArrayList<>();     // 从标注库同步到recommend,courseNew的数据

    private List<LabelObject> keysNationalVocabulary = new ArrayList<>();
    private List<LabelObject> keysNationalGrammar = new ArrayList<>();
    private List<SentenceLabel> keysNationalSentence = new ArrayList<>();    //用于保存打了标注的句子,分句结果

    private List<LabelObject> keysNationalScene = new ArrayList<>();
    private List<LabelObject> keysNationalTopic = new ArrayList<>();
    private List<LabelObject> keysNationalPhonic = new ArrayList<>();

    private List<LabelObject> keysOralTopic = new ArrayList<>();
    private List<LabelObject> keysOralScene = new ArrayList<>();
    private List<LabelObject> keysOralGrammar = new ArrayList<>();

    List<String> oralSections = new ArrayList<>();            //口语练习点
    List<String> articleFixed = new ArrayList<>();      // 分句文本

    List<String> devKeysInternational = new ArrayList<>();
    List<String> devKeysNationalVocabulary = new ArrayList<>();
    List<String> devKeysNationalGrammar = new ArrayList<>();
    List<String> devKeysNationalScene = new ArrayList<>();
    List<String> devKeysNationalTopic = new ArrayList<>();
    List<String> devKeysNationalPhonic = new ArrayList<>();
//    List<String> devKeysNationalSentences = new ArrayList<>();   // 新增

    List<String> devKeysOralTopic = new ArrayList<>();
    List<String> devKeysOralScene = new ArrayList<>();
    List<String> devKeysOralGrammar = new ArrayList<>();

    Long createTime;
    Long updateTime = System.currentTimeMillis();

    @Data
    public static class LabelObject {
        private String level_1_label;
        private Long level_1_id;

        private String level_2_label;
        private Long level_2_id;

        private String level_3_label;
        private Long level_3_id;
    }

    @Data
    public static class SentenceLabel {
        String sentence;
        String theSentencePattern;
        Long pattern_id;
    }
}
