package com.co.grupoasd.prueba.tecnica.microservicio.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.co.grupoasd.prueba.tecnica.microservicio.app.models.entity.Activos;
import com.co.grupoasd.prueba.tecnica.microservicio.app.models.repository.IActivosRepository;

public class ActiviosServiceImpl implements IActivosService {

	@Autowired
	private IActivosRepository repositorio;
	
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Activos> findAll() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Activos findById(Long id) {

		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		repositorio.deleteById(id);
		
	}


	@Override
	@Transactional(readOnly = true)
	public Iterable<Activos> saveAll(Iterable<Activos> activos) {

		return repositorio.saveAll(activos);
	}


}
