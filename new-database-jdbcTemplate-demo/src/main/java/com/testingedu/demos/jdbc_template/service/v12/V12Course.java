package com.testingedu.demos.jdbc_template.service.v12;


import com.testingedu.demos.jdbc_template.domain.BookSectionEntity;
import com.testingedu.demos.jdbc_template.domain.BookSectionRepository;
import com.testingedu.demos.jdbc_template.handler.local.V12Handler;
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
    private V12Handler v12Handler;
    @Autowired
    private BookSectionRepository bookSectionRepository;


    public void saveTop(String path) {
        List<ExcelToJsonPoi.CourseJson> courseJsons = excelToJsonPoi.readExcel(path);

        List<BookSectionEntity> result = new ArrayList<>();
        courseJsons.forEach(courseJson -> {
            BookSectionEntity bookSectionEntity = new BookSectionEntity();

            try {
                bookSectionEntity.setCourseId(Base64.encodeBase64URLSafeString(courseJson.getProjectName().getBytes("utf-8")));
                bookSectionEntity.setGrade(courseJson.getGrade());
                bookSectionEntity.setBundle(Long.parseLong(courseJson.getBundle()));

                bookSectionEntity.setGradeIndex(getGradeIndex(courseJson.getGrade()));
                bookSectionEntity.setType(courseJson.getKnowledgeType());
                bookSectionEntity.setProjectName(courseJson.getProjectName());
                bookSectionEntity.setFlagPaid(courseJson.getKnowledgeType().trim().equals("拔高知识点")?true:false);
                bookSectionEntity.setDifficulty(courseJson.getLevel());
                result.add(bookSectionEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                log.error("save error,[{}]", courseJson.getProjectName());
            }
        });
        try {
//            v12Handler.saveTop(result);
            bookSectionRepository.save(result);
        } catch (Exception e) {
            log.error("projectName=" + courseJsons.get(0).getProjectName(), e);
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

            case "出国1阶":
                return 2011L;

            case "出国2阶":
                return 2021L;

            case "出国3阶":
                return 2031L;

            case "出国4阶":
                return 2041L;

            case "出国5阶":
                return 2051L;

            case "出国6阶":
                return 2061L;
            default:
                return 99999L;

        }
    }
}
