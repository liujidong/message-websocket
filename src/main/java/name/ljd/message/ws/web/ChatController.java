package name.ljd.message.ws.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	
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
