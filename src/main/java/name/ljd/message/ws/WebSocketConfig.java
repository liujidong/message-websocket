package name.ljd.message.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
@Configuration
@EnableWebSocketMessageBroker//1
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {//2
		registry.addEndpoint("/endpointAll").withSockJS();//3
	      registry.addEndpoint("/endpointChat").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {//4
		registry.enableSimpleBroker("/all");//5
		//super.configureMessageBroker(registry);
		registry.enableSimpleBroker("/queue","/topic");
	}

}
