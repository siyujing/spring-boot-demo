package com.testingedu.demos.amqprabbitmq.rabbit_test.rabbit_demo_test;

import cn.hutool.core.util.NetUtil;
import com.rabbitmq.client.*;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class AppProduceAndConsumerDirectDemo {
    public static void checkServer() {
        if (NetUtil.isUsableLocalPort(15672)) {
            JOptionPane.showMessageDialog(null, "RabbitMQ 服务器未启动 ");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        main_pro();
//        main_usa();
    }

    /**
     * 消息生成者
     */
    public final static String EXCHANGE_NAME = "myExchangeName1";

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
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);//声明可持久化交换器
        channel.queueDeclare("myQueue1", true, false, false, null);//声明可持久化队列
        channel.queueBind("myQueue1", EXCHANGE_NAME, "usa.news");//绑定队列到交换器并指定路由键

        channel.queueDeclare("myQueue1", true, false, false, null);//声明可持久化队列
        channel.queueBind("myQueue1", EXCHANGE_NAME, "usa.weather");//绑定队列到交换器并指定路由键

        channel.queueDeclare("myQueue2", false, false, false, null);//声明非持久化队列
        channel.queueBind("myQueue2", EXCHANGE_NAME, "europe.news");

        channel.queueDeclare("myQueue2", false, false, false, null);//声明非持久化队列
        channel.queueBind("myQueue2", EXCHANGE_NAME, "europe.weather");

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
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
        //获取一个临时队列
        String queueName = channel.queueDeclare("myQueue1", true, false, false, null).getQueue();
        //接受 USA 信息
        channel.queueBind("myQueue1", EXCHANGE_NAME, "usa.news");
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


//    public static Connection GetRabbitConnection() {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setUsername(Config.UserName);
//        factory.setPassword(Config.Password);
//        factory.setVirtualHost(Config.VHost);
//        factory.setHost(Config.Host);
//        factory.setPort(Config.Port);
//        Connection conn = null;
//        try {
//            conn = factory.newConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    public static Connection GetRabbitConnection2() {
//        ConnectionFactory factory = new ConnectionFactory();
//        // 连接格式：amqp://userName:password@hostName:portNumber/virtualHost
//        String uri = String.format("amqp://%s:%s@%s:%d%s", Config.UserName, Config.Password, Config.Host, Config.Port,
//                Config.VHost);
//        Connection conn = null;
//        try {
//            factory.setUri(uri);
//            factory.setVirtualHost(Config.VHost);
//            conn = factory.newConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    /**
//     * 推送消息
//     */
//    public static void main2(String[] args) throws IOException, TimeoutException {
//        // 创建一个连接
//        Connection conn = GetRabbitConnection();
//        if (conn != null) {
//            try {
//                // 创建通道
//                Channel channel = conn.createChannel();
//                // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
//                channel.queueDeclare(Config.QueueName, false, false, false, null);
//                String content = String.format("当前时间：%s", new Date().getTime());
//                // 发送内容【参数说明：参数一：交换机名称；参数二：队列名称，参数三：消息的其他属性-routing headers，此属性为MessageProperties.PERSISTENT_TEXT_PLAIN用于设置纯文本消息存储到硬盘；参数四：消息主体】
//                channel.basicPublish("", Config.QueueName, null, content.getBytes("UTF-8"));
//                System.out.println("已发送消息：" + content);
//                // 关闭连接
//                channel.close();
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 消费消息
//     */
//    public static void Consumer() throws IOException, TimeoutException {
//        // 创建一个连接
//        Connection conn = GetRabbitConnection();
//        if (conn != null) {
//            try {
//                // 创建通道
//                final Channel channel = conn.createChannel();
//                // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
//                channel.queueDeclare(Config.QueueName, false, false, false, null);
//
//                // 创建订阅器，并接受消息
//                channel.basicConsume(Config.QueueName, false, "", new DefaultConsumer(channel) {
//                    @Override
//                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
//                                               byte[] body) throws IOException {
//                        String routingKey = envelope.getRoutingKey(); // 队列名称
//                        String contentType = properties.getContentType(); // 内容类型
//                        String content = new String(body, "utf-8"); // 消息正文
//                        System.out.println("消息正文：" + content);
//                        channel.basicAck(envelope.getDeliveryTag(), false); // 手动确认消息【参数说明：参数一：该消息的index；参数二：是否批量应答，true批量确认小于index的消息】
//                    }
//                });
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}