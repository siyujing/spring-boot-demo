package com.testing;

import com.testingedu.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewDoubleDatasourceDemoApplicationTests.class)
public class NewDoubleDatasourceDemoApplicationTests {

	@Autowired
	BookService bookService;

	@Test
	public void bookTest(){
		bookService.saveAndGetOne();
	}

}
