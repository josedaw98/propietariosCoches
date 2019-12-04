package com.pablo.propietariosCoches.rutas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pablo.propietariosCoches.beans.CocheBean;
import com.pablo.propietariosCoches.beans.PropietarioBean;
import com.pablo.propietariosCoches.listas.ListaCoches;
import com.pablo.propietariosCoches.listas.ListaPropietarios;

@Controller
public class RutasCoches {
	
	private ListaPropietarios listaPropietarios = ListaPropietarios.getLista();
	private ListaCoches listaCoches = ListaCoches.getLista();
	
	@GetMapping("/coches")
	public ModelAndView rutaCochesInicial() {
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/Coches/coches");
		
		model.addObject("propietario",new PropietarioBean());
		model.addObject("coche",new CocheBean());
		
		model.addObject("propietarios", listaPropietarios.getDatos());
		model.addObject("coches", listaCoches.getDatos());
		
		return model;
		
	}
	
	
	@PostMapping("/addCoche")
	public String addCoche(@ModelAttribute CocheBean coche) {
		
		listaCoches.addCoche(coche);
		
		return "redirect:/coches"; 		
		
	}
	
	
	@GetMapping("/editarCoche/{id}")
	public String editarCoche(@PathVariable Integer id,
								Model model) {

		CocheBean coche = listaCoches.getCoche(id);
		model.addAttribute("coche",coche);
		
		return "/Coches/editarCoche"; 	
	}
	
	@PostMapping("/updateCoche")
	public String updateCoche(@ModelAttribute CocheBean coche) {
		
		listaCoches.updateCoche(coche);

		return "redirect:/coches"; 		
	}
	
	@GetMapping("/eliminarCoche/{id}")
	public String eliminarCoche(@PathVariable Integer id,
									Model model) {
		
		listaCoches.delCoche(id);
		
		return("redirect:/coches");

	}
}
