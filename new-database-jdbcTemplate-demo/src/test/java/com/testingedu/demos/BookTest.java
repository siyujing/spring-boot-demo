package com.testingedu.demos;

import com.testingedu.demos.jdbc_template.service.BookNationalService;
import com.testingedu.demos.jdbc_template.service.BookService;
import com.testingedu.demos.jdbc_template.service.CourseNewToBookNationalService;
import com.testingedu.demos.jdbc_template.service.v12.V12Course;
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
    public void getBook() {
        bookService.getBookSectionLabel();
    }

    @Test
    public void getBookSectionByLevelAndType() {
        bookService.getBookSectionByLevelAndType();
    }

    // 同步 mongo 所有的标注到 mysql
    @Test
    public void getAllLabelToCourseHadLabel() {
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

    @Test
    public void saveHomeworkToBookNational() {
        courseNewToBookNationalService.saveHomeworkLongZeToBookNational();
    }

    @Test
    public void saveHomeworkToBookNationalByPub() {
        courseNewToBookNationalService.saveHomeworkLongZeToBookNationalByPub();
    }

    @Autowired
    BookNationalService bookNationalService;

    @Test
    public void saveBookSectionKnowledgeToBookNational() throws IOException {
        bookNationalService.saveBookSectionKnowledgeToBookNational();
    }


//    @Autowired
//    private WordService wordService;

//    @Test
//    public void wordTest() throws IOException {
//        wordService.getCourse();
//    }

    @Autowired
    private V12Course v12Course;
//    初中各年级核心及一对一课程列表0628.xlsx
//    小学各年级核心及一对一课程列表0628.xlsx
//    高中各年级核心及一对一课程列表0628.xlsx
    @Test
    public void SaveTop() throws IOException {
//        v12Course.saveTop("/Users/boxfish/Downloads/Re_第13阶课程列表/小学各年级核心及一对一课程列表0628.xlsx");
//        v12Course.saveTop("/Users/boxfish/Downloads/Re_第13阶课程列表/初中各年级核心及一对一课程列表0628.xlsx");
//        v12Course.saveTop("/Users/boxfish/Downloads/Re_第13阶课程列表/高中各年级核心及一对一课程列表0628.xlsx");

//        v12Course.saveTop("/Users/boxfish/Downloads/高中各年级核心及一对一课程列表0711.xlsx");
//        v12Course.saveTop("/Users/boxfish/Downloads/国际课程12、13、14阶课程列表0711.xlsx");

        v12Course.saveTop("/Users/boxfish/Downloads/初中各年级核心及一对一课程列表0809.xlsx");
        v12Course.saveTop("/Users/boxfish/Downloads/高中各年级核心及一对一课程列表0809.xlsx");

        v12Course.saveTop("/Users/boxfish/Downloads/国际课程12、13、14阶课程列表0809.xlsx");
    }
}
