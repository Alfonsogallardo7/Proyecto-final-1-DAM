package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
import com.salesianostriana.dam.proyectofinal.modelo.Competidor;
import com.salesianostriana.dam.proyectofinal.servicios.CompeticionServicio;
import com.salesianostriana.dam.proyectofinal.servicios.CompetidorServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CompetidorController {
	
	private final CompetidorServicio servicio;
	private final CompeticionServicio competicionServicio;
	
	@GetMapping("/competidores")
	public String todosLosCompetidores (Model model) {
		model.addAttribute("competidores", servicio.findAll());
		return "tabla";
	}
	
	@GetMapping("/competidor/nuevo")
	public String showForm (Model model) {
		model.addAttribute("competiciones", competicionServicio.findAll());
		model.addAttribute("competidor", new Competidor());
		
		return "formulario";
	}
	
	@PostMapping("/competidor/submit")
	public String processForm(@ModelAttribute("competidor") Competidor nuevo) {
		
		servicio.save(nuevo);
		
		return "redirect:/competidores";
	}
	
	@GetMapping("/competidor/editar/{id}")
	public String editarCompetidor(@PathVariable("id") Long id, Model model) {

		Competidor competidor = servicio.findById(id).orElse(null);
			model.addAttribute("competidor", competidor);
			model.addAttribute("competiciones", competicionServicio.findAll());
			return "formulario";

	}
	
	
	@GetMapping("/competidor/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Competidor competidor = servicio.findById(id).orElse(null);
			servicio.delete(competidor);
		

		return "redirect:/competidores";

	}
	
	

}
