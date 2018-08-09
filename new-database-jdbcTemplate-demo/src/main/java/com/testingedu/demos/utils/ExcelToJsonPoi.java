package com.testingedu.demos.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ExcelToJsonPoi {

    public List<CourseJson> readExcel(String filePath) {

        XSSFWorkbook book;
        XSSFSheet sheet;
        XSSFRow row;

        List<CourseJson> jsons = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(new File(filePath));

            book = new XSSFWorkbook(is);

            sheet = book.getSheetAt(0);


            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                try {
                    row = sheet.getRow(i);

                    if (row != null) {
                        CourseJson json = new CourseJson();
                        //对于纯数字内容要做这一操作
                        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);

                        // course_candidate_online
//                        json.setBundle(row.getCell(0).getStringCellValue());
//                        json.setStage(row.getCell(1).getStringCellValue());
//                        json.setType(row.getCell(2).getStringCellValue());
//                        json.setLabel(row.getCell(3).getStringCellValue());
//                        json.setKnowledgeType(row.getCell(4).getStringCellValue());
//                        json.setLevel(row.getCell(5).getStringCellValue());
//                        json.setProjectName(row.getCell(6).getStringCellValue().trim());

                        // course_candidate_task_core
//                        json.setBundle(row.getCell(0).getStringCellValue());
//                        json.setGrade(row.getCell(1).getStringCellValue());
//                        json.setLevel(row.getCell(2).getStringCellValue());
//                        json.setType(row.getCell(3).getStringCellValue());
//                        json.setLabel(row.getCell(4).getStringCellValue());
//                        json.setKnowledgeType(row.getCell(5).getStringCellValue());
//                        json.setProjectName(row.getCell(6).getStringCellValue());


                        // course_candidate_task_word
                        json.setBundle(row.getCell(0).getStringCellValue());
                        json.setGrade(row.getCell(1).getStringCellValue());
                        json.setProjectName(row.getCell(2).getStringCellValue());

                        jsons.add(json);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(sheet.getSheetName() + "----" + i);
                }
            }

            System.out.println(jsons.toString());
            book.close();
        } catch (FileNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return jsons;
    }


    @Data
    public static class CourseJson {
        private String id;
        private String type;
        private String label;
        private String knowledgeType;
        private String level;
        private String bundle;
        private String projectName;
        private String stage;
        private String grade;
    }
}
