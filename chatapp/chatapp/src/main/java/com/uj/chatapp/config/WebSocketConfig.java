package com.uj.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * CreatedBy Upendra
 */

/*
 * The @EnableWebSocketMessageBroker is used to enable our WebSocket server. We
 * implement WebSocketMessageBrokerConfigurer interface and provide
 * implementation for some of its methods to configure the websocket connection.
 * 
 * In the first method, we register a websocket endpoint that the clients will
 * use to connect to our websocket server.
 * 
 * Notice the use of withSockJS() with the endpoint configuration. SockJS is
 * used to enable fallback options for browsers that don’t support websocket.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");

		// Use this for enabling a Full featured broker like RabbitMQ
		registry.enableStompBrokerRelay("/topic").setRelayHost("52.177.126.47").setRelayPort(15672).setClientLogin("ujadmin")
				.setClientPasscode("Hindustan@1995");
	}

}
