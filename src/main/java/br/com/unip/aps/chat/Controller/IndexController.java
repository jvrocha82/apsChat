package br.com.unip.aps.chat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@GetMapping
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}