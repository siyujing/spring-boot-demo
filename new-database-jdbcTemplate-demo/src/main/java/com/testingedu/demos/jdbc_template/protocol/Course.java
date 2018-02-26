package com.testingedu.demos.jdbc_template.protocol;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.util.List;

@Slf4j
public class Course {

    private String courseId;

    private String courseName;      // 课程名称，中文
    private String englishName;     // 课程名称，英文

    private String projectName;

    private String preference;      // 偏好设置

    private String publication;     // 教材版本（适用于教材同步）
    private String grade;           // 适用年级（适用于教材同步）
    private String bookUnit;        // 课程单元（适用于教材同步）

    private Type type;              // 课程类型（适用于智能推荐）
    private Type typeV2;            // 课程类型（第二版）

    private Difficulty difficulty;  // 课程难度（适用于智能推荐）

    private String cover;           // 课程封面
    private Integer price;          // 课程价格

    private DateTime publicDate;    // 开发时间
    private DateTime lastModified;  // 修改时间

    private String bundleId;        // 排序组号
    private Integer bundleOrder;    // 排序编号

    private Origin origin;          // 补充标示：课程来源（智能推荐、复习课程、智能作业）
    private String description;     // 补充标示：课程描述
    private Boolean finished;       // 补充标示：是否完成
    private Mark mark;              // 补充标示：课程得分

    private KindergartenType kindergartenType;      // 课程标注：幼儿园课程类型标注

    private List<KnowledgeSystem> knowledgeSystems; // 课程标注：知识体系标注
    private List<String> abilitySystems;            // 课程标注：能力体系标注
    private List<String> sentenceLabels;            // 课程标注：课程标注句型

    private List<String> nationalKnowledge;         // 课程标注：知识点，教材大纲
    private List<String> internationalKnowledge;    // 课程标注：知识点，国际课程


    public boolean beValid() {
        if (courseId == null || courseName == null || type == null || typeV2 == null || difficulty == null || price == null || cover == null) {
            return false;
        } else {
            return true;
        }
    }

    public void refreshPropertiesByCourse(Course course) {
        this.courseName = course.courseName;
        this.englishName = course.englishName;

        this.publication = course.publication;
        this.grade = course.grade;
        this.bookUnit = course.bookUnit;

        this.type = course.type;
        this.typeV2 = course.typeV2;

        this.difficulty = course.difficulty;

        this.cover = course.cover;
        this.price = course.price;

        this.kindergartenType = course.kindergartenType;

        this.knowledgeSystems = course.knowledgeSystems;
        this.abilitySystems = course.abilitySystems;
        this.sentenceLabels = course.sentenceLabels;

        this.nationalKnowledge = course.nationalKnowledge;
        this.internationalKnowledge = course.internationalKnowledge;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (null == other) return false;
        if (!(other instanceof Course)) return false;

        Course otherCourse = (Course) other;
        return this.courseId.equals(otherCourse.courseId);
    }

    @Override
    public int hashCode() {
        return courseId.hashCode();
    }

    public static Course buildByCourseId(String courseId) {
        Course course = new Course();
        course.courseId = courseId;
        return course;
    }

    public static Course buildByCourseIdAndCourseName(String courseId, String courseName) {
        Course course = new Course();
        course.courseId = courseId;
        course.courseName = courseName;
        return course;
    }

    public static Course buildByCourseIdAndCourseNameAndProjectName(String courseId, String courseName, String projectName) {
        Course course = new Course();
        course.courseId = courseId;
        course.courseName = courseName;
        course.projectName = projectName;
        return course;
    }

    public enum Type {
        FUNCTION, CONVERSATION, READING, WORD, TALK, GRAMMAR, PHONICS, SONG,
        QUIZ, WORDS, MUSIC, LISTENING, TEXTBOOK_WORDS, TEXTBOOK_READING, TEXTBOOK_LISTENING, TEXTBOOK_QUIZ,
        全面提高, 阅读, 听读, 发音, 词汇, 句型, 对话, 语言基础, 听力测验, 文字测验, 课文朗读, 听力, 写作, 短对话, 测验,

        /* 万能默认值 */
        TEXTBOOK,

        /* 幼儿园课程类型 */
        STORY, OBJECT, RHYTHM, ACTION, SITUATION,

        /* V2 课程类型 */
        APPRECIATION, WORDS_EXPRESSIONS, SPEAKING_TEST, GRAMMAR_SENTENCES, PHONICS_PRONUNCIATION,
        EXAMINATION, SONGS, KNOWLEDGE, PROBLEM_SOLVING, COMMUNICATION, LISTENING_READING, WRITING,
        SENTENCES;


        public static Type parse(String type) {
            return Type.valueOf(type.toUpperCase());
        }

        private static List<String> RULE_READING = Lists.newArrayList("全面提高", "阅读", "词汇");
        private static List<String> RULE_CONVERSATION = Lists.newArrayList("对话", "句型", "课文朗读");
        private static List<String> RULE_FUNCTION = Lists.newArrayList("表达");

        public static Type convert(String courseType) {
            if (RULE_READING.contains(courseType)) return Type.READING;
            if (RULE_CONVERSATION.contains(courseType)) return Type.CONVERSATION;
            if (RULE_FUNCTION.contains(courseType)) return Type.FUNCTION;

            try {
                return parse(courseType);
            } catch (Exception e) {
                log.error("Component course, convert course type error.");
                return TEXTBOOK;
            }
        }
    }

    public enum ExamType {
        MIDDLE("初中考试"),
        HIGH("高中考试"),
        OTHERS("其它");

        private static List<String> ruleA = Lists.newArrayList("一年级", "二年级", "三年级", "四年级", "五年级", "六年级", "初一", "初二", "初三", "七年级", "八年级", "九年级");
        private static List<String> ruleB = Lists.newArrayList("高一", "高二", "高三");
        private static List<String> ruleC = Lists.newArrayList("学前", "大学", "毕业啦", "不告诉你");

        private String description;

        ExamType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public static ExamType parse(String grade) {
            if (ruleA.contains(grade)) return ExamType.MIDDLE;
            if (ruleB.contains(grade)) return ExamType.HIGH;
            if (ruleC.contains(grade)) return ExamType.OTHERS;

            log.error("Component course, parse exam type error.");
            throw new IllegalArgumentException();
        }
    }

    public enum Difficulty {
        LEVEL_A("A", "LEVEL A"),
        LEVEL_B("B", "LEVEL B"),
        LEVEL_C("C", "LEVEL C"),

        LEVEL_1("1", "Level 1"),
        LEVEL_2("2", "Level 2"),
        LEVEL_3("3", "Level 3"),
        LEVEL_4("4", "Level 4"),
        LEVEL_5("5", "Level 5"),
        LEVEL_6("6", "Level 6"),
        LEVEL_7("7", "Level 7"),
        LEVEL_8("8", "Level 8");

        private String index;
        private String description;

        Difficulty(String index, String description) {
            this.index = index;
            this.description = description;
        }

        public String getIndex() {
            return index;
        }

        public String getDescription() {
            return description;
        }

        public static Difficulty parse(String index) {
            return Difficulty.valueOf("LEVEL_" + index);
        }

    }

    public enum FitGroup {
        CHILD("幼儿"),
        PRIMARY("小学"),
        MIDDLE("中学"),
        ADULT("成人");

        private static List<String> ruleA = Lists.newArrayList("学前", "幼儿");
        private static List<String> ruleB = Lists.newArrayList("一年级", "二年级", "三年级", "四年级", "五年级", "六年级");
        private static List<String> ruleC = Lists.newArrayList("初一", "初二", "初三", "七年级", "八年级", "九年级", "高一", "高二", "高三");
        private static List<String> ruleD = Lists.newArrayList("大学", "毕业啦", "不告诉你");

        private String description;

        FitGroup(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public static FitGroup parse(String grade) {
            if (ruleA.contains(grade)) return FitGroup.CHILD;
            if (ruleB.contains(grade)) return FitGroup.PRIMARY;
            if (ruleC.contains(grade)) return FitGroup.MIDDLE;
            if (ruleD.contains(grade)) return FitGroup.ADULT;

            log.error("Component course, parse fit group error, return default value.", grade);
            return FitGroup.ADULT;
        }
    }

    public enum Origin {
        RECOMMEND,  // 推荐
        REVISE,     // 复习
        HOMEWORK,   // 作业
        BOOK,       // 教材
        DEMO        // 体验
    }

    public enum KindergartenType {
        CORE, AUXILIARY
    }

    public enum Mark {
        A_PLUS, A, B, C, D
    }

    @Data
    public static class KnowledgeSystem {
        private String knowledgeSystemOne;
        private String knowledgeSystemTwo;
        private String knowledgeSystemThree;
    }
}
