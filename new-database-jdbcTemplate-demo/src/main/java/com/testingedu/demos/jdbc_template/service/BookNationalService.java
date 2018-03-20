package com.testingedu.demos.jdbc_template.service;

import com.testingedu.demos.jdbc_template.domain.KeysNationalEntity;
import com.testingedu.demos.jdbc_template.domain.KeysNationalRepository;
import com.testingedu.demos.jdbc_template.handler.local.BookSectionKnowledgeHandler;
import com.testingedu.demos.jdbc_template.mongo.CourseNew;
import com.testingedu.demos.jdbc_template.mongo.CourseNewMongoRepository;
import com.testingedu.demos.utils.FormatUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookNationalService {

    @Autowired
    BookSectionKnowledgeHandler bookSectionKnowledgeHandler;

    @Autowired
    CourseNewMongoRepository courseNewMongoRepository;

    @Autowired
    KeysNationalRepository keysNationalRepository;

    private final Map<String, String> bookEditMap = new HashMap<>();

    public void checkBookEdit() throws IOException {
//
        File fileBookEdit = new File("/Users/boxfish/IdeaProjects/boxfish-single/content-platform/service_wudaokou/src/main/resources/book_edition.json");
        String bookEditString = "{ \"courseMappers\":" + FileUtils.readFileToString(fileBookEdit) + "}";
        BookEdit bookEdit = FormatUtils.fromJson(bookEditString, BookEdit.class);
        for (BookEdit.CourseMapper courseMapper : bookEdit.getCourseMappers()) {
            bookEditMap.put(courseMapper.getText(), courseMapper.getValue());
        }
    }


    @Data
    static class BookEdit {
        List<CourseMapper> courseMappers;

        @Data
        static class CourseMapper {
            String text;
            String value;
        }
    }

    public void saveBookSectionKnowledgeToBookNational() throws IOException {

        checkBookEdit();

        List<BookSectionKnowledgeHandler.BookSectionKnowledgeResponse> responses = bookSectionKnowledgeHandler.findAll();

        Map<String, List<BookSectionKnowledgeHandler.BookSectionKnowledgeResponse>> bookSectionKnowledgeResponseMap = responses.stream().collect(Collectors.groupingBy(BookSectionKnowledgeHandler.BookSectionKnowledgeResponse::getLesson));


        List<String> bookSectionKnowledgeIds = responses.stream().map(BookSectionKnowledgeHandler.BookSectionKnowledgeResponse::getLesson).collect(Collectors.toList());

        List<CourseNew> courseNews = courseNewMongoRepository.findByBookSectionIdIn(bookSectionKnowledgeIds);

        List<KeysNationalEntity> result = new ArrayList<>();

        courseNews.forEach(courseNew -> {
            try {
                KeysNationalEntity entity = new KeysNationalEntity();

                entity.fromCourseNew(courseNew);

                String version = bookSectionKnowledgeResponseMap.get(courseNew.getBookSectionId()).get(0).getVersion();
                entity.setPublication(bookEditMap.get(version).split("-")[0]);
                entity.setGrade(bookEditMap.get(version).split("-")[1]);

                Long bundleOrder = bookSectionKnowledgeResponseMap.get(courseNew.getBookSectionId()).get(0).getId();
                entity.setBundleOrder(bundleOrder);
                DateTime now = DateTime.now();
                entity.setCreateTime(now);
                entity.setUpdateTime(now);

                keysNationalRepository.save(entity);
                log.info("save success [{}]", courseNew.getBookSectionId());

            } catch (Exception e) {
                log.error("save fail [{}]", courseNew.getBookSectionId(),e);
            }
        });

        List<String> courseNewIds = courseNews.stream().map(CourseNew::getBookSectionId).collect(Collectors.toList());

        bookSectionKnowledgeIds.removeAll(courseNewIds);
        System.out.println("没有的查到的课程:"+bookSectionKnowledgeIds);
    }
}
