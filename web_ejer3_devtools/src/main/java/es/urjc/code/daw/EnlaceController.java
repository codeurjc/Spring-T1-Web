package es.urjc.code.daw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EnlaceController {

	@GetMapping("/student/{id}/subjects/{subject_id}")
	public String enlace(
			Model model, 
			@PathVariable String id, 
			@PathVariable String subject_id) {

		model.addAttribute("num", num);

		return "enlace";
	}
}