package edu.curso.models;

import org.springframework.data.repository.CrudRepository;

import edu.curso.domain.OrdenPizza;

public interface OrdenPizzaRepository extends CrudRepository<OrdenPizza, Long>{
	
}
