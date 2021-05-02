package br.com.unip.aps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unip.aps.modelo.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	Optional <User> findByNome(String nome);

	Optional<User> findByEmail(String email);

	
}
