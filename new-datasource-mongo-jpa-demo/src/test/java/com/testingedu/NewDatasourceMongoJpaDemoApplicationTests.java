package com.testingedu;

import com.testingedu.domain.mysql.BookEntity;
import com.testingedu.domain.mysql.BookRepository;
import com.testingedu.domain.nosql.CourseLabelEntity;
import com.testingedu.domain.nosql.CourseLabelRepository;
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
	BookRepository bookRepository;

	@Autowired
	CourseLabelRepository courseLabelRepository;

	@Test
	public void contextLoads() {
		List<BookEntity> testOne2 = bookRepository.findByName("testOne2");
		System.out.println("test2="+testOne2);

		List<CourseLabelEntity> byCourseNameChinese = courseLabelRepository.findByCourseNameChinese("如何表达“为了”？");
		System.out.println("byCourseNameChinese="+byCourseNameChinese);
	}

}
