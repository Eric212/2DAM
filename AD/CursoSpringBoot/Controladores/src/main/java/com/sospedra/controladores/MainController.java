package com.sospedra.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String welcome(@RequestParam (name="name", required=false, defaultValue="Eric") String name,Model model) {
		model.addAttribute("mensaje","SpringBoot es una puta mierda");
		model.addAttribute("nombre",name);
		return "index";
	}
	
	@GetMapping("/prueba")
	public String prueba(Model model) {
		model.addAttribute("prueba","SpringBoot no es tan mierda");
		return "prueba";
	}
	
}
