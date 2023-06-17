package edu.curso.models.security;

import org.springframework.data.repository.CrudRepository;

import edu.curso.domain.security.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long>{
	
	Usuario findByUsername(String username);

}
