
package es.urjc.code.daw;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnuncioController {
	
	private List<Anuncio> anuncios = new ArrayList<>(); 

	@PostConstruct
	public void init() {
		anuncios.add(new Anuncio("pepe", "vendo moto", "blablabla"));
		anuncios.add(new Anuncio("maria", "vendo coche", "aldhashfas"));
	}
	
	@GetMapping("/")
	public String tablonAnuncios(Model model) {
		model.addAttribute("anuncios", anuncios);
		return "tablonAnuncios";
	}
	
	@PostMapping("/guardaranuncio")
	public String guardarAnuncio(Model model, Anuncio anuncio) {

		anuncios.add(anuncio);
		model.addAttribute("anuncio", anuncio);

		return "anuncio";
	}
}