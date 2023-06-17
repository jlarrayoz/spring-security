package edu.curso.models;


import org.springframework.data.repository.CrudRepository;


import edu.curso.domain.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, String>{

}
