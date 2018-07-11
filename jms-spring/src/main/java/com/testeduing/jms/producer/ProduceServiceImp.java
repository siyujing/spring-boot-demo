package com.testeduing.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class ProduceServiceImp implements ProduceService {

    @Autowired
    JmsTemplate jmsTemplate;
    @Resource(name = "queueDestination")
    Destination destination;


    public void sendMessage(String message) {
//        jmsTemplate.send(destination, new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return null;
//            }
//        });
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
