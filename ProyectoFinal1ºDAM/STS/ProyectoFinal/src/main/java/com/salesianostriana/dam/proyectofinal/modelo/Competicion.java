package com.salesianostriana.dam.proyectofinal.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Competicion {
	
	@Id
	@GeneratedValue	
	private long id;
	
	private String nombreCompeticion;
	private String nombreClubPromotor;
	private String direccion;
	private int codigoPostal;
	private String provincia;
	private LocalDate fechaCompeticion;
	private String categoriaCompeticion;
	

}
