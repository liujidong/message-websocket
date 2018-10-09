package name.ljd.message.ws.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import name.ljd.message.ws.domain.InMessage;
import name.ljd.message.ws.domain.OutResponse;

@Controller
public class WsController {
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/toall")//1
	@SendTo("/all/getResponse")//WebSocketConfig.configureMessageBroker
	public OutResponse say(InMessage message) throws Exception {
		//Thread.sleep(3000);
		//return new TheResponse("Welcome, "+message.getName()+"!");
		return new OutResponse(message);
	}
	//@MessageMapping("/toall")//1
	public void say(InMessage message,@Header("topic") String topic) throws Exception{
		template.convertAndSend("/topic/" + topic, new OutResponse(message));
		
	}
	@Autowired
	private SimpMessagingTemplate messagingTemplate;//1

	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg) { //2
		if (principal.getName().equals("x")) {//x->y
			messagingTemplate.convertAndSendToUser("y",
					"/queue/notifications", principal.getName() + "-send:"
							+ msg);
		} else if(principal.getName().equals("y")){//y->x
			messagingTemplate.convertAndSendToUser("x",
					"/queue/notifications", principal.getName() + "-send:"
							+ msg);
		}
	}	
}
