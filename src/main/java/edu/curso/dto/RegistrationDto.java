package edu.curso.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import edu.curso.domain.security.Usuario;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationDto {
	
	@NotBlank
	private String username;
	@NotBlank
	@Size(min = 3, max = 10, message = "El password debe estar entre {min} y {max} caracteres")
	private String password;
	@NotBlank
	private String confirmPassword;
	@NotBlank
	private String nombrePersona;
	@NotBlank
	private String ciudad;
	@NotBlank
	private String barrio;
	@NotBlank
	private String direccion;
	
	/**
	 * AssertTrue: Constraint que se dispara cuando el método devuelve faslse.
	 * En este caso se utiliza para verificar que password y confirm password sean iguales
	 * @return true si pass y confirm pass son iguales, false en caso contrario
	 */
	@AssertTrue(message = "Password debe ser igual a confirmación")
	public boolean isValidarPassword() {
		if (password == null || password.isBlank() || confirmPassword == null || confirmPassword.isBlank()) {
			return true;
		}
		else {
			return password.equals(confirmPassword);
		}
	}
	
	/**
	 * Crea una entity usuario a partir del DTO
	 * @param encoder Se utiliza para encriptar la password
	 * @return Usuario creado a partir del DTO
	 */
	public Usuario toUsuario(PasswordEncoder encoder) {
		return new Usuario(username, encoder.encode(password), nombrePersona, ciudad, barrio, direccion);
	}	
}
