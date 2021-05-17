package br.com.unip.aps.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unip.aps.modelo.ChatMessage;

// Métodos de tratamento de mensagens em nosso controlador. Esses métodos serão responsáveis ​​por receber mensagens de um cliente e depois transmiti-las a outros.
@Controller
@RequestMapping(value = "/chat")
public class ChatController { // Foi configurado o websocket de forma que todas as mensagens provenientes do
								// cliente com o prefixo “/app” sejam roteadas para os métodos de tratamento de
								// mensagens apropriados anotados com @MessageMapping.

	@GetMapping
	public String chat() {
		return "chat";
	}

	
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
    
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
