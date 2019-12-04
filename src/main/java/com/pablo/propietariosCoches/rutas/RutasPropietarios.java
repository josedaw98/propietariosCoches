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
	public String addPropietario(@ModelAttribute PropietarioBean propietario) {
		
		listaPropietarios.addPropietario(propietario);
		
		return "redirect:/propietarios"; 		
		
	}
	
	
	@GetMapping("/editarPropietario/{id}")
	public String editarPropietario(@PathVariable Integer id,
								Model model) {

		PropietarioBean propietario = listaPropietarios.getAutor(id);
		model.addAttribute("propietario",propietario);
		
		return "/Propietarios/editarPropietario"; 	
	}
	
	@PostMapping("/updatePropietario")
	public String updatePropietario(@ModelAttribute PropietarioBean propietario) {
		
		listaPropietarios.updatePropietario(propietario);
		
		return "redirect:/propietarios"; 		
		
	}
	
	@GetMapping("/eliminarPropietario/{id}")
	public String eliminarPropietario(@PathVariable Integer id,
									Model model) {
		
		listaPropietarios.delPropietario(id);
		
		return("redirect:/propietarios");

	}
	

}
