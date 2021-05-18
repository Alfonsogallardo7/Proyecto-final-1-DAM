package com.salesianostriana.dam.proyectofinal.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.modelo.Competicion;
import com.salesianostriana.dam.proyectofinal.repository.CompeticionRepository;
import com.salesianostriana.dam.proyectofinal.servicios.base.BaseServices;

@Service
public class CompeticionServicio 
extends BaseServices<Competicion, Long, CompeticionRepository> {

}
