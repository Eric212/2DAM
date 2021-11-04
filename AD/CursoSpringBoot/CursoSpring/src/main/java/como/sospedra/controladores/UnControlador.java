package como.sospedra.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnControlador {
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
}
