package br.com.unip.aps.chat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.unip.aps.chat.dto.Userdto;
import br.com.unip.aps.service.Autenticacao;

@Controller
public class LoginController {
	
	@Autowired
	private Autenticacao auth;
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String login (Userdto userdto){
		auth.UsuarioExiste(userdto);
		
		if(auth.UsuarioExiste(userdto) == true) {

		return "redirect:/chat";
	}
		else {
			return "redirect:/registro";
		}
	}
	
}
