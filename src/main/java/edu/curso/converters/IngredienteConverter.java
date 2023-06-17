package edu.curso.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.curso.domain.Ingrediente;
import edu.curso.models.IngredienteRepository;


@Component
public class IngredienteConverter implements Converter<String, Ingrediente> {

	private IngredienteRepository ingredienteRepo;
	
	
	public IngredienteConverter(IngredienteRepository ingredienteRepo) {
		super();
		this.ingredienteRepo = ingredienteRepo;
	}


	@Override
	public Ingrediente convert(String id) {
		return ingredienteRepo.findById(id).orElseThrow();
	}
}
