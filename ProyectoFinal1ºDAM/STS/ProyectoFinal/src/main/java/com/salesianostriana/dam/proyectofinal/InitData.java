package com.salesianostriana.dam.proyectofinal;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectofinal.modelo.Competicion;
import com.salesianostriana.dam.proyectofinal.modelo.Competidor;
import com.salesianostriana.dam.proyectofinal.servicios.CompeticionServicio;
import com.salesianostriana.dam.proyectofinal.servicios.CompetidorServicio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {

	private final CompetidorServicio competidorServicio;
	private final CompeticionServicio competicionServicio;

	@PostConstruct
	public void init() {

		List<Competicion> competiciones = List.of(
				new Competicion("Campeonato de España", "Berserker Madrid",
				"Av, El limón, s/n", 29130, "Málaga", LocalDate.of(2021, 6, 4), "Campeonato Nacional"),
				new Competicion("Campeonato del NorOeste", "Club Fuerza Norte León", "C/ La Granja 9", 24007, "León", LocalDate.of(2021, 5, 8), "Campeonato Regional"),
				new Competicion("Campeonato nacional de Madrid, Castilla la Mancha y Extremadura", "Club Crom Madrid", "C/ Miramotes 4", 28730, "Buitrago del Lozoya (Madrid)", LocalDate.of(2021, 3, 20), "Campeonato Regional")
				);
		
		competiciones.forEach(competicionServicio::save);
		
		List<Competidor> competidores = List.of(
				new Competidor("Alberto", "Herrainz", LocalDate.of(2000, 6, 12), 66.8, 67,competicionServicio.findById(1L).get(),"Masculino", 250, 120, 270),
				new Competidor("Alfonso", "Gallardo", LocalDate.of(2001, 06, 30), 70.3, 73, competicionServicio.findById(2L).get(), "Masculino", 135, 105, 170));
				
		competidores.forEach(competidorServicio::save);

	}

}
