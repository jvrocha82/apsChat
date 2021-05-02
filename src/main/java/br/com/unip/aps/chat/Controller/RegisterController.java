package br.com.unip.aps.chat.Controller;

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
	
	@RequestMapping(value ="/registro", method = RequestMethod.GET)
	public String registroPage() {
		return "registro";

	}
	@RequestMapping(value ="/registro", method = RequestMethod.POST)
	public String registroPage( Userdto userdto) {

		User user = userdto.toUser();
		repository.save(user);
		
		return "redirect:/registro";
	}

	


}
