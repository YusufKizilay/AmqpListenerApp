package org.kizilay.yusuf.AmqpListenerApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConnectionProperties {

	@Value("${RABBIT_HOST}")
	private String host;

	@Value("${RABBIT_PORT}")
	private int port;

	@Value("${RABBIT_USERNAME}")
	private String username;

	@Value("${RABBIT_PASSWORD}")
	private String password;

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
