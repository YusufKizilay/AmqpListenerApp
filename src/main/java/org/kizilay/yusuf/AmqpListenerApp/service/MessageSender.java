package org.kizilay.yusuf.AmqpListenerApp.service;

import org.kizilay.yusuf.AmqpListenerApp.config.AppConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private AppConfig appConfig;

	public void sendMessage(String text) {
		rabbitTemplate.convertAndSend(appConfig.getQueueName(), text);
	}

}
