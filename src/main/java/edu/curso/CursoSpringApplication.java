package edu.curso;

import org.springframework.boot.CommandLineRunner;
import edu.curso.domain.security.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.curso.domain.Ingrediente;
import edu.curso.domain.TipoIngrediente;
import edu.curso.models.IngredienteRepository;
import edu.curso.models.security.UserRepository;

@SpringBootApplication
public class CursoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}
	
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	/**
	 * Metodo responsable de dejar disponible en el contexto de spring la un bean de CommandLineRunner.
	 * CommandLineRunner nos permite ejecutar lógica en el startup de la aplicación 
	 * @param repo Repository de Ingredientes para persistir los ingredientes
	 * @param userRepo Repositorio de usuarios para poder agregar los usuarios iniciales
	 * @return
	 */
	@Bean
	CommandLineRunner dataLoader(IngredienteRepository repo, UserRepository userRepo) {
		return (args -> {
			
			//MASAS
			repo.save(new Ingrediente("MC", "Masa común", TipoIngrediente.MASA));
			repo.save(new Ingrediente("MM", "Masa madre", TipoIngrediente.MASA));
			repo.save(new Ingrediente("MIT", "Masa italiana", TipoIngrediente.MASA));
			
			//QUESOS
			repo.save(new Ingrediente("QM", "Queso muzzarella", TipoIngrediente.QUESO));
			repo.save(new Ingrediente("QD", "Queso dambo", TipoIngrediente.QUESO));
			repo.save(new Ingrediente("QP", "Queso persistente", TipoIngrediente.QUESO));
			repo.save(new Ingrediente("QC", "Queso commandLineRunner", TipoIngrediente.QUESO));
			
			//Instancio el encoder para dar de alta los usuarios
			PasswordEncoder encoder = encoder();
			
			userRepo.save(new Usuario("juan", encoder.encode("juan123"), "Juan Larrayoz", "Montevideo", "Buceo", "18 de Julio 1234"));
			userRepo.save(new Usuario("jose", encoder.encode("jose123"), "Jose Perez", "Canelones", "Salinas", "Principal esquina ibirapita"));
		});
	}
}
