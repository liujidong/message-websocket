package name.ljd.message.ws.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import name.ljd.message.ws.domain.InMessage;
import name.ljd.message.ws.domain.OutResponse;

@Controller
public class AllController {
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/toall")//1 前端发送请求的路径
	@SendTo("/topic/aboutAll")//WebSocketConfig.configureMessageBroker//前端订阅的主题
	public OutResponse say(InMessage message) throws Exception {
		//Thread.sleep(3000);
		//return new TheResponse("Welcome, "+message.getName()+"!");
		return new OutResponse(message);
	}
	//@MessageMapping("/toall")//1
	public void say(InMessage message,@Header("topic") String topic) throws Exception{
		template.convertAndSend("/topic/" + topic, new OutResponse(message));
		
	}
}
