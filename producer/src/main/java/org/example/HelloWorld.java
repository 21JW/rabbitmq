package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;




public class HelloWorld {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        //factory.setVirtualHost("/itcast");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();
        channel.queueDeclare("hello_world",true,false,false,null);
        String body="hello rabbitmq";
        channel.basicPublish("","hello_world",null,body.getBytes());
        channel.close();
        connection.close();
    }
}
