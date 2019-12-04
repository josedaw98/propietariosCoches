package com.pablo.propietariosCoches.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RutasPropietarios {

	@GetMapping("/propietarios")
	public ModelAndView rutaPropietariosInicial() {
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/Propietarios/propietarios");
		
		return model;
		
	}
}
