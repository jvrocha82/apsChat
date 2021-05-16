package br.com.unip.ChatWeb.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration // Diz que é uma classe de configuração Spring
@EnableWebSocketMessageBroker // Habilita o Servidor WebSocket ativando o manuseio de mensagens WebSocket, apoiado por um agente de mensagens
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer { // Interface que fornece a implementação para alguns de seus métodos para configurar a conexão do websocket

	// Método que registramos um endpoint de websocket que os clientes usarão para se conectar ao nosso servidor de websocket
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { // A palavra STOMP no nome do método, vêm da implementação STOMP de frameworks Spring. STOMP significa Simple Text Oriented Messaging Protocol. É um protocolo de mensagens que define o formato e as regras para troca de dados
        registry.addEndpoint("/ws").withSockJS(); // Usado para habilitar opções de fallback para navegadores que não suportam websocket
    }

    // Configuração de um agente de mensagens que será usado para rotear mensagens de um cliente para outro. Permite que um intermediário de mensagem rabbitmq transporte as mensagens de volta para o cliente em destinos prefixados com “/topic”
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); // Todas as mensagens com o prefixo “/app” serão roteadas para métodos anotados com @MessageMapping na classe do controlador.
        registry.enableStompBrokerRelay("/topic"); // Roteado para o agente de mensagens. O agente de mensagens transmite mensagens para todos os clientes conectados que estão inscritos em um determinado tópico.

    }
}
