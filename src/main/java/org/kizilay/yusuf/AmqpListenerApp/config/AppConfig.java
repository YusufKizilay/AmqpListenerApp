package org.kizilay.yusuf.AmqpListenerApp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	public static final String PREVIOUS_QUEUE_NAME = "RED_QUEUE";
	public static final String QUEUE_NAME = "BLACK_QUEUE";
	public static final String EXCHANGE_NAME = "BLACK_EXCHANGE";
	public static final String ROUTING_KEY = "BLACK";

	@Autowired
	ConnectionProperties properties;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

		connectionFactory.setHost(properties.getHost());
		connectionFactory.setAddresses(properties.getHost());
		connectionFactory.setUsername(properties.getUsername());
		connectionFactory.setPassword(properties.getUsername());

		return new CachingConnectionFactory();
	}

	@Bean
	public Queue queue() {
		return QueueBuilder.durable(QUEUE_NAME).build();
	}

	@Bean
	public Exchange exchange() {
		return ExchangeBuilder.directExchange(EXCHANGE_NAME).build();
	}

	@Bean
	public Binding redBinding(Queue queue, Exchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		return new RabbitTemplate(connectionFactory);
	}

	public String getQueueName() {
		return QUEUE_NAME;
	}

	public String getExchangeName() {
		return EXCHANGE_NAME;
	}

	public String getRoutingKey() {
		return ROUTING_KEY;
	}
}
