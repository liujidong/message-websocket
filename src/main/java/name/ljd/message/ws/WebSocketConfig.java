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
		registry.addEndpoint("/endpointAll").withSockJS();//3 前端构造SockJS参数用
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {//4
		registry.enableSimpleBroker("/all");//5 订阅主题的基本路径
		//super.configureMessageBroker(registry);
	}

}
