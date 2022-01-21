package es.urjc.code.daw.tablonanuncios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TablonController {

	@Autowired
	private AnuncioRepository anuncioRepository;
	
	public TablonController() {
	}

	@PostConstruct
	public void init() {
		anuncioRepository.save(new Anuncio("Pepe", "Hola caracola", "XXXX"));
		anuncioRepository.save(new Anuncio("Juan", "Hola caracola", "XXXX"));
	}
	
	@GetMapping("/")
	public String tablon(Model model) {

		model.addAttribute("anuncios", anuncioRepository.findAll());

		return "tablon";
	}

	@PostMapping("/anuncio/nuevo")
	public String nuevoAnuncio(Model model, Anuncio anuncio) {

		anuncioRepository.save(anuncio);

		return "anuncio_guardado";

	}

	@GetMapping("/anuncio/{id}")
	public String verAnuncio(Model model, @PathVariable long id) {

		Anuncio anuncio = anuncioRepository.findById(id).get();

		model.addAttribute("anuncio", anuncio);

		return "ver_anuncio";
	}
}