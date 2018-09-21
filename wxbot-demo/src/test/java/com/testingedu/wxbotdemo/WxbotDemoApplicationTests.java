package com.testingedu.wxbotdemo;

import com.testingedu.wxbotdemo.domain.WxBot;
import com.testingedu.wxbotdemo.service.WxBotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxbotDemoApplicationTests {

    @Autowired
    private WxBotService wxBotService;

    @Test
    public void contextLoads() {
        wxBotService.start(new WxBot());
    }

}
