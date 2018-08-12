package com.testingedu.objectprogrammingfivedesignprinciples;

import com.testingedu.objectprogrammingfivedesignprinciples.代理模式.ClientProxyService;
import com.testingedu.objectprogrammingfivedesignprinciples.原型模式.基本原型模式.ClientPrototype;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectProgrammingFiveDesignPrinciplesApplicationTests {


    // 原型模式
    @Autowired
    private ClientPrototype client;

    @Test
    public void concreteResume() {
        client.getConcreteResume();
    }


    // 代理模式
    @Autowired
    private ClientProxyService clientProxyService;

    @Test
    public void clientProxy() {
        clientProxyService.testRequest();
    }
}
