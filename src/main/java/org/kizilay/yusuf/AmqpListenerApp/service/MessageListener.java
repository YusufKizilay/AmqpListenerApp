package org.kizilay.yusuf.AmqpListenerApp.service;

import org.kizilay.yusuf.AmqpListenerApp.config.AppConfig;
import org.kizilay.yusuf.AmqpListenerApp.entity.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

	private static final String QUEUE_NAME = AppConfig.PREVIOUS_QUEUE_NAME;

	@Autowired
	private MessageSender messageSender;

	@RabbitListener(queues = QUEUE_NAME)
	public void receiveMessage(String text) {
		System.out.println("Received message: " + text);
		sendMessage(text);
	}

	private void sendMessage(String text) {
		messageSender.sendMessage(text);
	}

}
