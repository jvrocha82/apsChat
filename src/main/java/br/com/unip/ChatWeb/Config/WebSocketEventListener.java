package br.com.unip.ChatWeb.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import br.com.unip.aps.modelo.ChatMessage;

// Classe ouvinte WebSocker - Esta classe ouve eventos como um novo usuário entrando no chat ou um usuário saindo do chat
@Component
public class WebSocketEventListener {
	 private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

	    @Autowired
	    private SimpMessageSendingOperations messagingTemplate;

	    @EventListener
	    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
	        logger.info("Received a new web socket connection");
	    }

	    @EventListener
	    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
	        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

	        String username = (String) headerAccessor.getSessionAttributes().get("username");
	        if(username != null) {
	            logger.info("User Disconnected : " + username);

	            ChatMessage chatMessage = new ChatMessage();
	            chatMessage.setType(ChatMessage.MessageType.LEAVE);
	            chatMessage.setSender(username);

	            messagingTemplate.convertAndSend("/topic/public", chatMessage);
	        }
	    }
	}
