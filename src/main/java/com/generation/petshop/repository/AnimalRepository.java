package com.generation.petshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.petshop.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
	
	public List<Animal> findAllByRacaContainingIgnoreCase (String raca);	

}
