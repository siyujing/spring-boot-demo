package com.testingedu.demos;

import com.testingedu.demos.jdbc_template.service.BookNationalService;
import com.testingedu.demos.jdbc_template.service.BookService;
import com.testingedu.demos.jdbc_template.service.CourseNewToBookNationalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {
    @Autowired
    BookService bookService;

    @Test
    public void getBook(){
        bookService.getBookSectionLabel();
    }

    @Test
    public void getBookSectionByLevelAndType(){
        bookService.getBookSectionByLevelAndType();
    }

    // 同步 mongo 所有的标注到 mysql
    @Test
    public void getAllLabelToCourseHadLabel(){
        bookService.getAllLabelToCourseHadLabel();
    }

    @Test
    public void getLabelToCourseHadLabelByBookName() throws IOException {
        bookService.getAllLabelToCourseHadLabelByBook();
    }

    @Autowired
    CourseNewToBookNationalService courseNewToBookNationalService;

    @Test
    public void saveCourseNewToBookNational() {
        courseNewToBookNationalService.saveCourseNewToBookNational();
    }


    @Autowired
    BookNationalService bookNationalService;

    @Test
    public void saveBookSectionKnowledgeToBookNational() throws IOException {
        bookNationalService.saveBookSectionKnowledgeToBookNational();
    }
}
