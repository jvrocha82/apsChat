package br.com.unip.aps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unip.aps.modelo.ChatMessage;


@Repository
public interface MessageRepository extends JpaRepository<ChatMessage, Long>{

}