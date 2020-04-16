package com.testingedu.demos.jdbc_template.domain;

import com.testingedu.demos.jdbc_template.mongo.CourseLabelEntity;
import com.testingedu.demos.utils.FormatUtils;
import com.testingedu.demos.utils.LabelObjectUtil;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

//coursename,projectname,keys_national_sentence,inter_communication,inter_critical_thinking,inter_knowledge,inter_problem_solving,
// keys_national_grammar,keys_national_phonic,keys_national_scene,keys_national_topic,keys_national_vocabulary

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
    private String projectName;

    // 内容标注
    @Column(columnDefinition = "TEXT")
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

    @Column(columnDefinition = "TEXT")
    private String oralSections;            //口语练习点
    @Column(columnDefinition = "TEXT")
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

    // 国际知识点标注格式处理
    private String internalCommunication;
    private String internalCriticalThinking;
    private String internalKnowledge;
    private String internalProblemSolving;


    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createTime;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateTime;

    public void from(CourseLabelEntity re) {
        this.setCourseId(re.getCourseId());
        this.setCourseNameChinese(re.getCourseNameChinese());
        this.setCourseNameEnglish(re.getCourseNameEnglish());
        this.setProjectName(re.getProjectName());

        this.setKeysInternational(FormatUtils.toJsonNoException(re.getKeysInternational()));

        this.setKeysNationalVocabulary(LabelObjectUtil.labelObjectToString(re.getKeysNationalVocabulary()));
        this.setKeysNationalGrammar(LabelObjectUtil.labelObjectToString(re.getKeysNationalGrammar()));

        List<CourseLabelEntity.SentenceLabel> sentence = re.getKeysNationalSentence();
        this.setKeysNationalSentence(LabelObjectUtil.sentenceLabelToString(sentence));

        this.setKeysNationalScene(LabelObjectUtil.labelObjectToString(re.getKeysNationalScene()));
        this.setKeysNationalTopic(LabelObjectUtil.labelObjectToString(re.getKeysNationalTopic()));
        this.setKeysNationalPhonic(LabelObjectUtil.labelObjectToString(re.getKeysNationalPhonic()));

        this.setKeysOralTopic(LabelObjectUtil.labelObjectToString(re.getKeysOralTopic()));
        this.setKeysOralScene(LabelObjectUtil.labelObjectToString(re.getKeysOralScene()));
        this.setKeysOralGrammar(LabelObjectUtil.labelObjectToString(re.getKeysOralGrammar()));

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

        this.setInternalCommunication(LabelObjectUtil.keysInternalToString(re.getKeysInternational(), "communication"));
        this.setInternalCriticalThinking(LabelObjectUtil.keysInternalToString(re.getKeysInternational(), "critical thinking"));
        this.setInternalKnowledge(LabelObjectUtil.keysInternalToString(re.getKeysInternational(), "knowledge"));
        this.setInternalProblemSolving(LabelObjectUtil.keysInternalToString(re.getKeysInternational(), "problem solving"));


        this.setCreateTime(new DateTime(re.getCreateTime()));
        this.setUpdateTime(new DateTime(re.getUpdateTime()));
    }

}
