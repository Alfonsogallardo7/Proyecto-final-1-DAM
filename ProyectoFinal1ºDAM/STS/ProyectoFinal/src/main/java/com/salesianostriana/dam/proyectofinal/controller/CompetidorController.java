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
/**
 * 
 * En este paquete se realizaran todos los procedimientos y se indicaran las url a usar
 * @author Alfonso Gallardo
 *
 */
@Controller
@RequiredArgsConstructor
public class CompetidorController {
	
	private final CompetidorServicio servicio;
	private final CompeticionServicio competicionServicio;
	
	
	/**
	 * Este método solo sirve para que te devuelva al index
	 * @return index.html
	 */
	@GetMapping("/")
	public String todosLosCompeonatos () {
		
		return "index";
	}
	
	/**
	 * 
	 * Lista a todos los competidores
	 * @param model
	 * @return tabla.html
	 */
	
	@GetMapping("/competidores")
	public String todosLosCompetidores (Model model) {
		model.addAttribute("competidores", servicio.findAll());
		return "tabla";
	}
	
	/**
	 * 
	 * Crea un nuevo competidor
	 * 
	 * @param model
	 * @return formulario.html
	 */
	
	@GetMapping("/competidor/nuevo")
	public String showForm (Model model) {
		model.addAttribute("competiciones", competicionServicio.findAll());
		model.addAttribute("competidor", new Competidor());
		
		return "formulario";
	}
	
	/**
	 * Guarda el competidor creado, y lo manda de nuevo a la lista
	 * @param nuevo
	 * @return redirecciona a /competidores
	 */
	
	@PostMapping("/competidor/submit")
	public String processForm(@ModelAttribute("competidor") Competidor nuevo) {
		
		servicio.save(nuevo);
		
		return "redirect:/competidores";
	}
	
	/**
	 * Edita el competidor elegido
	 * @param id
	 * @param model
	 * @return formulario.html
	 */
	
	/*
	 * Aquí no me termina bien de funcionar, ya que cuando edita me crea un competidor nuevo, estube añadiendo lo del post
	 * que me dio Ángel y se me queda igual.
	 * Y lo he contrastado con varios compañeros y lo tengo todo igual, así que no se que me puede fallar
	 */
	
	@GetMapping("/competidor/editar/{id}")
	public String editarCompetidor(@PathVariable("id") Long id, Model model) {

		Competidor competidor = servicio.findById(id).orElse(null);
			model.addAttribute("competidor", competidor);
			model.addAttribute("competiciones", competicionServicio.findAll());
			return "formulario";

	}
	
	/**
	 * Borra al competidor seleccionado
	 * @param id
	 * @param model
	 * @return redirecciona a /competidores
	 */
	
	
	@GetMapping("/competidor/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Competidor competidor = servicio.findById(id).orElse(null);
			servicio.delete(competidor);
		

		return "redirect:/competidores";

	}
	
	

}
