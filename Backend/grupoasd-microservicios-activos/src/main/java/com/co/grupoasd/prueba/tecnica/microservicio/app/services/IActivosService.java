package com.co.grupoasd.prueba.tecnica.microservicio.app.services;

import com.co.grupoasd.prueba.tecnica.microservicio.app.models.entity.Activos;

public interface IActivosService {

	public Iterable<Activos> findAll();
	
	public Iterable<Activos> saveAll(Iterable<Activos> activos);
	
	public Activos findById(Long id);
	
	public void deleteById(Long id);

}
