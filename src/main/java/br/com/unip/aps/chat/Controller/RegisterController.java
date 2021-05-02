package br.com.unip.aps.chat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String registroPage() {
		return "registro";
	}
	

}
