package com.testingedu;

import com.testingedu.domain.mysql.BookEntity;
import com.testingedu.domain.mysql.BookRepository;
import com.testingedu.domain.nosql.CourseLabelEntity;
import com.testingedu.domain.nosql.CourseLabelRepository;
import com.testingedu.handler.CourseLabelHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewDatasourceMongoJpaDemoApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CourseLabelRepository courseLabelRepository;
    @Autowired
    private CourseLabelHandler courseLabelHandler;

    @Test
    public void contextLoads() {
        List<BookEntity> testOne2 = bookRepository.findByName("testOne2");
        System.out.println("test2=" + testOne2);

        List<CourseLabelEntity> byCourseNameChinese = courseLabelRepository.findByCourseNameChinese("如何表达“为了”？");
        System.out.println("byCourseNameChinese=" + byCourseNameChinese);
    }


    @Test
    public void findOneByCourseNameChinese() {
        try {
            courseLabelHandler.findByCourseNameChinese("妹妹");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveOneLabel() {
        try {
            CourseLabelEntity result = new CourseLabelEntity();
            result.setCourseId("ddd");
            result.setCourseNameChinese("弟弟");
            result.setCourseNameEnglish("didi");
            courseLabelRepository.save(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
