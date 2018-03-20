package com.testing;

import com.testingedu.NewDoubleDatasourceDemoApplication;
import com.testingedu.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewDoubleDatasourceDemoApplication.class)
public class BookTest {

    @Autowired
    BookService bookService;

    @Test
    public void bookTest(){
        bookService.saveAndGetOne();
    }
}
