package com.pablo.propietariosCoches.rutas;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
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
public class RutasPropietarios {
	
	private ListaPropietarios listaPropietarios = ListaPropietarios.getLista();
	private ListaCoches listaCoches = ListaCoches.getLista();
	
	
	@GetMapping("/propietarios")
	public ModelAndView rutaPropietariosInicial() {
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/Propietarios/propietarios");
		
		model.addObject("propietario",new PropietarioBean());
		model.addObject("coche",new CocheBean());
		
		model.addObject("propietarios", listaPropietarios.getDatos());
		model.addObject("coches", listaCoches.getDatos());
		
		return model;
		
	}
	
	
	@PostMapping("/addPropietario")
	public ModelAndView addPropietario(@ModelAttribute PropietarioBean propietario) {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/propietarios");
		
		
		model.addObject("coches",listaCoches);
		
		
		model.addObject("propietario",new PropietarioBean());
		listaPropietarios.addPropietario(propietario);
		
		model.addObject("propietarios", listaPropietarios.getDatos());

		
		return model; 		
		
	}
	
	
	@GetMapping("/editarPropietario/{id}")
	public ModelAndView editarPropietario(@PathVariable Integer id) {

		ModelAndView model = new ModelAndView();
		
		
		model.addObject("coches",listaCoches.getDatos());
		
		PropietarioBean propietario = listaPropietarios.getPropietario(id);

		model.setViewName("Propietarios/editarPropietario");
		model.addObject("propietario",propietario);
		
		return model; 	
	}
	
	@PostMapping("/updatePropietario")
	public ModelAndView updatePropietario(@ModelAttribute PropietarioBean propietario) {
		
		listaPropietarios.updatePropietario(propietario);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/propietarios");
		
		return model; 		
		
	}
	
	@GetMapping("/eliminarPropietario/{id}")
	public ModelAndView eliminarPropietario(@PathVariable Integer id) {
		
		listaPropietarios.delPropietario(id);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/propietarios");
		
		return model; 

	}

}
