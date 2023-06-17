package edu.curso.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class OrdenPizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//Datos de la entrega
	@NotBlank(message="El campo es requerido")
	private String nombrePersona;
	
	@NotBlank(message="El campo es requerido")
	private String ciudad;
	
	@NotBlank(message="El campo es requerido")
	private String barrio;
	
	@NotBlank(message="El campo es requerido")
	private String direccion;
	
	//Datos de la tarjeta de crédito
	//Nro válido : 4242424242424242
	@CreditCardNumber(message="El nro de tarjeta no es válido")
	private String nroTarjeta;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Fecha inválida, el formato correcto es: MM/YY")
	private String fecVencimiento;
	
	@Digits(integer=3, fraction=0, message="Código CVV inválido")
	private String codigoCVV;
	
	//Prestar atención al mapeo de esta relación y el uso del cascade
	@OneToMany(cascade = CascadeType.ALL)
	private List<Pizza> pizzas = new ArrayList<>();
	
	public void addPizza(Pizza pizzza) {
		pizzas.add(pizzza);
	}
}
