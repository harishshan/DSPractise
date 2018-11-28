package com.blogspot.harishshan.practise.java.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

//Start the activemq on the your machine and try running this program and MessageReceiver
public class MessageSender {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String subject = "test";
	
	public static void main(String[] args) throws JMSException {		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(subject);	
		MessageProducer producer = session.createProducer(destination);
		TextMessage message = session.createTextMessage("TEST MESSAGE");
		producer.send(message);
		connection.close();
		System.out.println("Message Sent to ActiveMQ successfully");
	}
}