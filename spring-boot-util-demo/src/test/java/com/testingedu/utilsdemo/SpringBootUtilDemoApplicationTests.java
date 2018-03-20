package com.testingedu.utilsdemo;

import com.testingedu.utilsdemo.App.conf.BepropertiesDemo2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUtilDemoApplicationTests {
    @Autowired
    BepropertiesDemo2 beProperties;

    @Test
    public void contextLoads() {
        beProperties.showDemo2();
    }

}
