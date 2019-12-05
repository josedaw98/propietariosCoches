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
	public ModelAndView addCoche(@ModelAttribute CocheBean coche) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("Coches/coches");
		
		model.addObject("coche",new CocheBean());
		listaCoches.addCoche(coche);
		
		model.addObject("coches", listaCoches.getDatos());

		
		return model; 		
		
	}
	
	
	@GetMapping("/editarCoche/{id}")
	public ModelAndView editarCoche(@PathVariable Integer id) {

		CocheBean coche = listaCoches.getCoche(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("Coches/editarCoche");
		model.addObject("coche",coche);
		
		return model; 	
	}
	
	@PostMapping("/updateCoche")
	public ModelAndView updateCoche(@ModelAttribute CocheBean coche) {
		
		listaCoches.updateCoche(coche);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/coches");
			
		return model; 		
		
	}
	
	@GetMapping("/eliminarCoche/{id}")
	public ModelAndView eliminarCoche(@PathVariable Integer id) {
		
		listaCoches.delCoche(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/coches");
		
		return model; 

	}
}
