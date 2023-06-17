package edu.curso.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;

@Data
@AllArgsConstructor 
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
public class Ingrediente {
	
	@Id
	private String id;
	
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	private TipoIngrediente tipo;

}
