package com.testingedu.demos.jdbc_template.service.v12;


import com.testingedu.demos.jdbc_template.domain.BookSectionEntity;
import com.testingedu.demos.jdbc_template.domain.BookSectionRepository;
import com.testingedu.demos.utils.ExcelToJsonPoi;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class V12Course {
    @Autowired
    private ExcelToJsonPoi excelToJsonPoi;
    @Autowired
    private BookSectionRepository bookSectionRepository;


    public void saveTop(String path) {
        List<ExcelToJsonPoi.CourseJson> courseJsons = excelToJsonPoi.readExcel(path);

        List<BookSectionEntity> result = new ArrayList<>();
        courseJsons.forEach(courseJson -> {
            BookSectionEntity bookSectionEntity = new BookSectionEntity();

            try {
                // for course_candidate_online
//                bookSectionEntity.setCourseId(Base64.encodeBase64URLSafeString(courseJson.getProjectName().getBytes("utf-8")));
//                bookSectionEntity.setBundle(Long.parseLong(courseJson.getBundle()));
//                bookSectionEntity.setType(courseJson.getType());
//                bookSectionEntity.setProjectName(courseJson.getProjectName());
//                bookSectionEntity.setFlagPaid(courseJson.getKnowledgeType().trim().equals("拔高知识点")?true:false);
//                bookSectionEntity.setDifficulty(getDifficulty(courseJson.getLevel()));
//                bookSectionEntity.setKnowledgeType(courseJson.getKnowledgeType());
//                bookSectionEntity.setLabelType(courseJson.getLabel());
//                bookSectionEntity.setStage(getStage(courseJson.getStage()));

                // for course_candidate_task_core
//                bookSectionEntity.setCourseId(Base64.encodeBase64URLSafeString(courseJson.getProjectName().getBytes("utf-8")));
//                bookSectionEntity.setBundle(Long.parseLong(courseJson.getBundle()));
//                bookSectionEntity.setGrade(getGradeName(courseJson.getGrade()));
//                bookSectionEntity.setGradeIndex(getGradeIndex(courseJson.getGrade()));
//                bookSectionEntity.setType(courseJson.getType());
//                bookSectionEntity.setLabelType(courseJson.getLabel());
//                bookSectionEntity.setKnowledgeType(courseJson.getKnowledgeType());
//                bookSectionEntity.setFlagPaid(courseJson.getKnowledgeType().trim().equals("拔高知识点")?true:false);
//                bookSectionEntity.setDifficulty(getDifficulty(courseJson.getLevel()));
//                bookSectionEntity.setProjectName(courseJson.getProjectName());

                // for course_candidate_task_word
                bookSectionEntity.setCourseId(Base64.encodeBase64URLSafeString(courseJson.getProjectName().trim().getBytes("utf-8")));
                bookSectionEntity.setProjectName(courseJson.getProjectName().trim());
                bookSectionEntity.setGrade(getGradeName(courseJson.getGrade()));
                bookSectionEntity.setGradeIndex(getGradeIndex(courseJson.getGrade()));
                bookSectionEntity.setBundle(Long.parseLong(courseJson.getBundle()));

                result.add(bookSectionEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                log.error("save error,[{}]", courseJson.getProjectName());
            }
        });
        try {
            bookSectionRepository.save(result);
        } catch (Exception e) {
            log.error("projectName=" + courseJsons.get(0).getProjectName(), e);
        }
    }

    public String getGradeName(String gradeName) {
        switch (gradeName) {
            case "第12阶":
                return "留学一";
            case "第13阶":
                return "留学二";
            case "第14阶":
                return "留学三";
            default:
                return gradeName;
        }
    }

    public Long getGradeIndex(String grade) {
        switch (grade) {
            case "幼儿":
                return 0L;
            case "一年级上":
                return 1011L;
            case "一年级下":
                return 1012L;
            case "二年级上":
                return 1021L;

            case "二年级下":
                return 1022L;

            case "三年级上":
                return 1031L;

            case "三年级下":
                return 1032L;

            case "四年级上":
                return 1041L;

            case "四年级下":
                return 1042L;

            case "五年级上":
                return 1051L;

            case "五年级下":
                return 1052L;

            case "六年级上":
                return 1061L;

            case "六年级下":
                return 1062L;

            case "七年级上":
                return 1071L;

            case "七年级下":
                return 1072L;

            case "八年级上":
                return 1081L;

            case "八年级下":
                return 1082L;

            case "九年级上":
                return 1091L;

            case "九年级下":
                return 1092L;

            case "高一上":
                return 1101L;

            case "高一下":
                return 1102L;

            case "高二上":
                return 1111L;

            case "高二下":
                return 1112L;

            case "高三上":
                return 1121L;

            case "高三下":
                return 1122L;

            case "第12阶":
                return 1131L;

            case "第13阶":
                return 1141L;

            case "第14阶":
                return 1151L;

            default:
                return 99999L;

        }
    }

    public String getDifficulty(String level) {
        switch (level) {
            case "Level 1":
                return "LEVEL_1";
            case "Level 2":
                return "LEVEL_2";
            case "Level 3":
                return "LEVEL_3";
            case "Level 4":
                return "LEVEL_4";

            case "Level 5":
                return "LEVEL_5";

            case "Level 6":
                return "LEVEL_6";

            case "Level 7":
                return "LEVEL_7";

            case "Level 8":
                return "LEVEL_8";
            default:
                return level;

        }
    }

    public String getStage(String stage) {
        switch (stage) {
            case "第1阶":
                return "1";
            case "第2阶":
                return "2";
            case "第3阶":
                return "3";
            case "第4阶":
                return "4";
            case "第5阶":
                return "5";
            case "第6阶":
                return "6";
            case "第7阶":
                return "7";
            case "第8阶":
                return "8";
            case "第9阶":
                return "9";
            case "第10阶":
                return "10";
            case "第11阶":
                return "11";
            case "第12阶":
                return "12";
            case "第13阶":
                return "13";
            case "第14阶":
                return "14";
            default:
                return stage;

        }
    }
}
