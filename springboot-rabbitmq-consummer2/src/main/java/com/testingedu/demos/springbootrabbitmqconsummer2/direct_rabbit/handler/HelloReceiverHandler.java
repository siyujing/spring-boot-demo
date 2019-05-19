package com.testingedu.demos.springbootrabbitmqconsummer2.direct_rabbit.handler;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiverHandler {

    @RabbitListener(queues="queue")    //监听器监听指定的Queue
    public void processC(String str) {
        System.out.println("Direct receive:"+str);
    }
}
