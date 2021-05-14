package com.salesianostriana.dam.proyectofinal.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Competidor {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private double pesoActual;
	private int categoriaPeso;
	private String sexo;
	private double squat;
	private double benchPress;
	private double deadlift;
	private double total;

	public Competidor(String nombre, String apellidos, LocalDate fechaNacimiento, double pesoActual, int categoriaPeso,
			String sexo, double squat, double benchPress, double deadlift) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.pesoActual = pesoActual;
		this.categoriaPeso = categoriaPeso;
		this.sexo = sexo;
		this.squat = squat;
		this.benchPress = benchPress;
		this.deadlift = deadlift;
	}

}