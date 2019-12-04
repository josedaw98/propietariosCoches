package com.pablo.propietariosCoches.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RutasBasicas {

	
	@GetMapping("/")
	public ModelAndView rutaIndexInicial() {
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/Basicas/index");
		
		return model;
		
	}
}