package edu.curso.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=5, max=20, message="El largo mínimo debe ser {min} y el máximo {max}")
	private String nombre;
	
	@NotNull
	@Size(min=2, message="La pizza debe tener al menos 2 ingredientes")
	//Prestar atención a esta anotación, estamos definiendo una relación many to manys
	@ManyToMany
	private List<Ingrediente> ingredientes;
	
	
	public void addIngrediente(Ingrediente ingrediente) {
		ingredientes.add(ingrediente);
	}
}
