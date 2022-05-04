package com.consumer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.connection.RedisConnection;
import com.rabbitmq.client.*;

public class RabbitConsumer {
	private static final String EXCHANGE_NAME = "amq.topic";
	private static final String ROUTING_KEY = "iot";
	private static final String QUEUE_NAME = "iot_queue";

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub

		String routingKey=ROUTING_KEY;
		
   	 ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("irfan");
        factory.setPassword("irfan");
   	
       Connection connection = factory.newConnection();
       Channel channel = connection.createChannel();

       channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, routingKey);

       System.out.println("Waiting for messages.");

       DeliverCallback deliverCallback = (consumerTag, delivery) -> {
           String message = new String(delivery.getBody(), "UTF-8");
           System.out.println("Message=  " + message + "\n");
           
           String[] messageArray= message.split( "[\\s=,]+" );

           Map<String, String> messageBody = new HashMap<>();
   		for( int i = 0; i < messageArray.length - 1; i++){
   		    String name = messageArray[i];
   		    String value = messageArray[i+1];
   		    String ID;
   		    System.out.println("name==  "+name+"  value=="+value+"\n");

   			if(name.equals("Day"))
   				messageBody.put( name, value );
   			
   			if(name.equals("Mac"))
   				messageBody.put( name, value );
   			    ID=value;

   			if(name.equals("Time"))
   				messageBody.put( "time", value );
   			
   			
   			if(name.equals("Humidity"))
   				messageBody.put( "humidity", value );
   			
   			
   			if(name.equals("Temperature"))
   				messageBody.put( "Temp", value );
   			
   			
   			if(name.equals("Wifi"))
   				messageBody.put( "Wifi", value );
   			
   			
   			if(name.equals("battery"))
   				messageBody.put( "battery", value );

   		    i++;
   		    
   		}

           
   		RedisConnection.redisConnection2().xadd(ROUTING_KEY,messageBody);

       };

       channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
    	   
    	   
       });


       System.out.println("Done");
	}

}
