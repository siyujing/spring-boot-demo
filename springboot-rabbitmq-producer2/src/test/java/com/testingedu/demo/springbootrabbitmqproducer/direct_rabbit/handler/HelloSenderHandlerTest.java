package com.testingedu.demo.springbootrabbitmqproducer.direct_rabbit.handler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSenderHandlerTest {

    @Autowired
    private HelloSenderHandler helloSenderHandler;


    @Test
    public void testRabbit() {
        helloSenderHandler.send();
    }
}
