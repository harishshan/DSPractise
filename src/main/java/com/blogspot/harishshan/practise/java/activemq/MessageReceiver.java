package com.blogspot.harishshan.practise.java.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

//Start the activemq on the your machine and try running MessageSender and this program
public class MessageReceiver {
	
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String subject = "test";
	
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(subject);
		MessageConsumer consumer = session.createConsumer(destination);
		Message message = consumer.receive();
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			System.out.println("Received message '" + textMessage.getText() + "'");
		}
		connection.close();
	}
}