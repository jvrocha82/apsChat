package br.com.unip.aps.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unip.aps.chat.dto.Userdto;
import br.com.unip.aps.modelo.User;
import br.com.unip.aps.repository.UserRepository;

@Controller
public class RegisterController {

	@Autowired
	private UserRepository repository;
	
	
	
	@RequestMapping(method = RequestMethod.GET, value ="/registro")
	public String registroPage() {
		return "registro";

	}
	@RequestMapping(method = RequestMethod.POST, value ="/formregistro")
	public String registroPage( Userdto userdto) {
		User user = userdto.toUser();
		repository.save(user);
		
		return "registro";
	}

	


}
