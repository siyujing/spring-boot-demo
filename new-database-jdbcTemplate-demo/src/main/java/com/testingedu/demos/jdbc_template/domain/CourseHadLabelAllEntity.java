package com.testingedu.demos.jdbc_template.domain;

import com.testingedu.demos.jdbc_template.mongo.CourseLabelEntity;
import com.testingedu.demos.utils.FormatUtils;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course_had_label_all")
@Data
public class CourseHadLabelAllEntity {
    @Id
    @GeneratedValue
    private Long id;

    // 基本属性
    private String courseId;
    private String courseNameChinese;
    private String courseNameEnglish;

    // 内容标注
    private String keysInternational;     // 从标注库同步到recommend,courseNew的数据

    private String keysNationalVocabulary;
    private String keysNationalGrammar;
    private String keysNationalSentence;    //用于保存打了标注的句子,分句结果

    private String keysNationalScene;
    private String keysNationalTopic;
    private String keysNationalPhonic;

    private String keysOralTopic;
    private String keysOralScene;
    private String keysOralGrammar;

    private String oralSections;            //口语练习点
    private String articleFixed;      // 分句文本

    private String devKeysInternational;
    private String devKeysNationalVocabulary;
    private String devKeysNationalGrammar;
    private String devKeysNationalScene;
    private String devKeysNationalTopic;
    private String devKeysNationalPhonic;

    private String devKeysOralTopic;
    private String devKeysOralScene;
    private String devKeysOralGrammar;

    private Long createTime;
    private Long updateTime;

    public void from(CourseLabelEntity re){
        this.setCourseId(re.getCourseId());
        this.setCourseNameChinese(re.getCourseNameChinese());
        this.setCourseNameEnglish(re.getCourseNameEnglish());

        this.setKeysInternational(FormatUtils.toJsonNoException(re.getKeysInternational()));

        this.setKeysNationalVocabulary(FormatUtils.toJsonNoException(re.getKeysNationalVocabulary()));
        this.setKeysNationalGrammar(FormatUtils.toJsonNoException(re.getKeysNationalGrammar()));

        List<CourseLabelEntity.SentenceLabel> sentence = re.getKeysNationalSentence();
        List<String> list = new ArrayList<>();
        sentence.forEach(s-> list.add(s.getTheSentencePattern()));
        this.setKeysNationalSentence(FormatUtils.toJsonNoException(list));

        this.setKeysNationalScene(FormatUtils.toJsonNoException(re.getKeysNationalScene()));
        this.setKeysNationalTopic(FormatUtils.toJsonNoException(re.getKeysNationalTopic()));
        this.setKeysNationalPhonic(FormatUtils.toJsonNoException(re.getKeysNationalPhonic()));

        this.setKeysOralTopic(FormatUtils.toJsonNoException(re.getKeysOralTopic()));
        this.setKeysOralScene(FormatUtils.toJsonNoException(re.getKeysOralScene()));
        this.setKeysOralGrammar(FormatUtils.toJsonNoException(re.getKeysOralGrammar()));

        this.setOralSections(FormatUtils.toJsonNoException(re.getOralSections()));
        this.setArticleFixed(FormatUtils.toJsonNoException(re.getArticleFixed()));

        this.setDevKeysInternational(FormatUtils.toJsonNoException(re.getDevKeysInternational()));
        this.setDevKeysNationalVocabulary(FormatUtils.toJsonNoException(re.getDevKeysNationalVocabulary()));
        this.setDevKeysNationalGrammar(FormatUtils.toJsonNoException(re.getDevKeysNationalGrammar()));
        this.setDevKeysNationalScene(FormatUtils.toJsonNoException(re.getDevKeysNationalScene()));
        this.setDevKeysNationalTopic(FormatUtils.toJsonNoException(re.getDevKeysNationalTopic()));
        this.setDevKeysNationalPhonic(FormatUtils.toJsonNoException(re.getDevKeysNationalPhonic()));

        this.setDevKeysOralTopic(FormatUtils.toJsonNoException(re.getDevKeysOralTopic()));
        this.setDevKeysOralScene(FormatUtils.toJsonNoException(re.getDevKeysOralScene()));
        this.setDevKeysOralGrammar(FormatUtils.toJsonNoException(re.getDevKeysOralGrammar()));

        this.setCreateTime(re.getCreateTime());
        this.setUpdateTime(re.getUpdateTime());
    }

}
