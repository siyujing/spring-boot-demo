package com.testingedu.demos.amqprabbitmq.rabbit_test.rabbit_demo_test;

import cn.hutool.core.util.NetUtil;
import com.rabbitmq.client.*;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class FanoutExchangeDemo {

    public static void checkServer() {
        if (NetUtil.isUsableLocalPort(15672)) {
            JOptionPane.showMessageDialog(null, "RabbitMQ 服务器未启动 ");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
//        main_pro();
        main_usa();
    }

    /**
     * 消息生成者
     */
    public final static String EXCHANGE_NAME = "myFanoutExchangeName2";

    public static void main_pro() throws IOException, TimeoutException {
        checkServer();

        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("localhost");
        factory.setPort(5672);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout", false);//声明可持久化交换器
//        channel.queueDeclare("myQueue1", true, false, false, null);//声明可持久化队列
//        channel.queueBind("myQueue1", EXCHANGE_NAME, "usa.news");//绑定队列到交换器并指定路由键
//
//        channel.queueDeclare("myQueue1", true, false, false, null);//声明可持久化队列
//        channel.queueBind("myQueue1", EXCHANGE_NAME, "usa.weather");//绑定队列到交换器并指定路由键
//
//        channel.queueDeclare("myQueue2", false, false, false, null);//声明非持久化队列
//        channel.queueBind("myQueue2", EXCHANGE_NAME, "europe.news");
//
//        channel.queueDeclare("myQueue2", false, false, false, null);//声明非持久化队列
//        channel.queueBind("myQueue2", EXCHANGE_NAME, "europe.weather");

        // 发送消息
        String[] routing_keys = new String[]{"usa.news", "usa.weather",
                "europe.news", "europe.weather"};
        String[] messages = new String[]{"美国新闻", "美国天气",
                "欧洲新闻", "欧洲天气"};

        for (int i = 0; i < routing_keys.length; i++) {
            String routingKey = routing_keys[i];
            String message = messages[i];
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message
                    .getBytes());
            System.out.printf("发送消息到路由：%s, 内容是: %s%n ", routingKey, message);

        }

        //关闭通道和连接
        channel.close();
        connection.close();
    }


    // 消费者
    public static void main_usa() throws IOException, TimeoutException {
        //为当前消费者取名称
        String name = "consumer-usa";

        //判断服务器是否启动
        checkServer();
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ地址
        factory.setHost("localhost");
        factory.setPort(5672);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //交换机声明（参数为：交换机名称；交换机类型）
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout", false);
        //获取一个临时队列
        String queueName = channel.queueDeclare("myTopicQuene1",false,false,false,null).getQueue();
        //接受 USA 信息
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println(name + " 等待接受消息");
        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("consumer-usa" + " 接收到消息 '" + message + "'");
            }
        };
        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(queueName, true, consumer);
    }
}
