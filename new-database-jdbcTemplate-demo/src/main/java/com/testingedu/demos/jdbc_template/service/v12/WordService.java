package com.testingedu.demos.jdbc_template.service.v12;

import com.testingedu.demos.jdbc_template.handler.cloud.BookHadKnowledgeHandler;
import com.testingedu.demos.utils.FormatUtils;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {
    @Autowired
    private BookHadKnowledgeHandler bookHadKnowledgeHandler;


    public List<String> getCourse() throws IOException {
        File courses = new File("/Users/boxfish/IdeaProjects/spring-boot-demo/new-database-jdbcTemplate-demo/src/main/resources/course.json");

        String bookEditString = "{ \"courses\":" + FileUtils.readFileToString(courses) + "}";
        CourseList courseList = FormatUtils.fromJson(bookEditString, CourseList.class);

        List<String> result = new ArrayList<>();
        courseList.getCourses().forEach(courseLine -> {
            String[] course = courseLine.split("siyujing");
            List<BookHadKnowledgeHandler.CourseInfoResponse> byName = bookHadKnowledgeHandler.findByName(course[1]);
            if (CollectionUtils.isEmpty(byName)) {
                result.add(courseLine);

            } else if (byName.size() > 1) {
                List<String> strings = new ArrayList<>();
                byName.forEach(i -> {
                    if (i.getProjectName().matches(course[0]) && i.getProjectName().matches(course[1])) {
                        result.add(strings.toString());
                    } else {
                        result.add(courseLine);
                    }
                });

            } else if (byName.size() == 1) {
                result.add(byName.get(0).getProjectName());
            }
        });

        System.out.println("result="+result);
        return result;
    }

    @Data
    public static class CourseList {
        List<String> courses;
    }
}
