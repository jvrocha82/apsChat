package br.com.unip.aps.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unip.aps.modelo.ChatMessage;

// Métodos de tratamento de mensagens em nosso controlador. Esses métodos serão responsáveis ​​por receber mensagens de um cliente e depois transmiti-las a outros.
@Controller

public class ChatController { // Foi configurado o websocket de forma que todas as mensagens provenientes do
								// cliente com o prefixo “/app” sejam roteadas para os métodos de tratamento de
								// mensagens apropriados anotados com @MessageMapping.

	@RequestMapping(value = "chat",method = RequestMethod.GET)
	public String chat() {
		return "chat";
	}
	
	
	// Uma mensagem com destino /app/chat.sendMessage será roteada para o método
	// sendMessage ()
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

	// Uma mensagem com destino /app/chat.addUser será roteada para o método addUser
	// ()
	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
}
