package com.testingedu.demos.springbootrabbitmqconsummer2.direct_rabbit.conf;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConf {
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }
}
