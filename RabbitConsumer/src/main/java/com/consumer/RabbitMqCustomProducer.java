package com.consumer;

import com.model.DeviceStats;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqCustomProducer {
	//private static String queueName="68:C6:3A:A5:A3:E6";
	private static String queueName="iot_queue";
	private static final String EXCHANGE_NAME = "amq.topic";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeviceStats deviceStats=null;
		while(true) {
			for(int i=1;i<10;i++) {
				deviceStats=new DeviceStats();
		        deviceStats.setBattery(21+i);
		        deviceStats.setHumidity(31+i);
		        deviceStats.setTemp(41+i);
		        deviceStats.setWifi(81+i);
		        deviceStats.setTime(System.currentTimeMillis());
				sendMessage(deviceStats,EXCHANGE_NAME);
		        //sendMessage(deviceStats,"test-ex");
		        //sendMessage(deviceStats,"test-exchange");
		}

		}

	}
	
	public static void sendMessage(DeviceStats deviceStats, String exchangeName) {

        try{
        	String routingKey = queueName;
               ConnectionFactory factory = new ConnectionFactory();
               factory.setHost("localhost");
               factory.setUsername("irfan");
               factory.setPassword("irfan");
               factory.setPort(5672);
               
               Connection connection = factory.newConnection();
               Channel channel = connection.createChannel();

               channel.queueDeclare(queueName, true, false, false, null);
               
               channel.queueBind(queueName, exchangeName, routingKey);

               channel.basicPublish(exchangeName, routingKey, null,deviceStats.toString().getBytes() );
               //channel.basicPublish(exchangeName, "", null,deviceStats.toString().toString().getBytes() );
               System.out.println("Sent " + routingKey + ":" + deviceStats.toString() + "\n");
               channel.close();
               connection.close();
            }  catch (Exception e) {
                e.printStackTrace();
            }
          
   }

}
