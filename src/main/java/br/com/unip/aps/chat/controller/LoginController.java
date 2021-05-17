package br.com.unip.aps.chat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.unip.aps.chat.dto.Userdto;
import br.com.unip.aps.service.Autenticacao;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private Autenticacao auth;
	
	@GetMapping
	public String loginPage() {
		return "login";
	}
	
	@PostMapping
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
