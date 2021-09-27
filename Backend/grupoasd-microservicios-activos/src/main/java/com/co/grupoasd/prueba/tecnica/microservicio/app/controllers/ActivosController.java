package com.co.grupoasd.prueba.tecnica.microservicio.app.controllers;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.grupoasd.prueba.tecnica.microservicio.app.models.entity.Activos;
import com.co.grupoasd.prueba.tecnica.microservicio.app.services.IActivosService;

@RestController
public class ActivosController {

	@Autowired
	private IActivosService service;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		
		Optional<Activos> op = Optional.of(service.findById(id));
		
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(op.get());
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Iterable<Activos> activos){
		
		activos = ((List<Activos>) activos).stream().map(res -> {
			
			res.setId(res.getId());
			return res;
			
		}).collect(Collectors.toList());
		
		Iterable<Activos> respuestaDb = service.saveAll(activos);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestaDb);
	}
	
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}	
	
}
