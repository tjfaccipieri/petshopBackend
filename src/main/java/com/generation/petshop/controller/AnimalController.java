package com.generation.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.petshop.model.Animal;
import com.generation.petshop.repository.AnimalRepository;

@RestController
@RequestMapping("/animais")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepository;
	
	@GetMapping
	public ResponseEntity<List<Animal>> GetAll(){
		return ResponseEntity.ok(animalRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> GetById(@PathVariable long id){
		return animalRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());				
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Animal>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(animalRepository.findAllByRacaContainingIgnoreCase(nome));				
	}
	
	@PostMapping
	public ResponseEntity<Animal> Post(@RequestBody Animal produto){
		return ResponseEntity.ok(animalRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Animal> Put(@RequestBody Animal produto){
		return ResponseEntity.ok(animalRepository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id) {
		animalRepository.deleteById(id);
	}
}
