package com.testingedu.utilsdemo;

import com.testingedu.utilsdemo.App.conf.BeProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUtilDemoApplicationTests {
    @Autowired
    BeProperties beProperties;

    @Test
    public void contextLoads() {
        beProperties.show();
    }

}
