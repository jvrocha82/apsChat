package br.com.unip.aps.chat.dto;

import br.com.unip.aps.modelo.ChatMessage;
import br.com.unip.aps.modelo.ChatMessage.MessageType;

public class MessageDto {

	private MessageType type;
	private String content;
	private String autor;
	

	public MessageType getType() {
		return type;
	}
	
	

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return autor;
	}

	public void setSender(String sender) {
		this.autor = sender;
	}

	public ChatMessage toChatMessage() {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setType(type);
		chatMessage.setContent(content);
		chatMessage.setSender(autor);
		
		return chatMessage;
	}

}