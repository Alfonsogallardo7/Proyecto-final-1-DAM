package com.salesianostriana.dam.proyectofinal.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	
	public Competicion(String nombreCompeticion, String nombreClubPromotor, String direccion, int codigoPostal,
			String provincia, LocalDate fechaCompeticion, String categoriaCompeticion) {
		super();
		this.nombreCompeticion = nombreCompeticion;
		this.nombreClubPromotor = nombreClubPromotor;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.fechaCompeticion = fechaCompeticion;
		this.categoriaCompeticion = categoriaCompeticion;
	}
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "competicion", fetch = FetchType.EAGER)
	private List<Competidor> competidores = new ArrayList<>();
	
	/********************************************/
	/* MÉTODOS AUXILIARES					    */
	/********************************************/
	
	public void addCompetidor(Competidor c) {
		this.competidores.add(c);
		c.setCompeticion(this);
	}
	
	public void removeCompetidor(Competidor c) {
		this.competidores.remove(c);
		c.setCompeticion(null);
	}
	

}
