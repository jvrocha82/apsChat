package br.com.unip.aps.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unip.aps.chat.dto.Userdto;
import br.com.unip.aps.modelo.User;
import br.com.unip.aps.repository.UserRepository;

@Controller
@RequestMapping(value ="/registro")
public class RegisterController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public String registroPage() {
		return "registro";

	}
	@PostMapping
	public String registroPage( Userdto userdto) {
		User user = userdto.toUser();
		repository.save(user);
		
		return "registro";
	}

	


}
