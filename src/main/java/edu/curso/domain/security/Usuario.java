package edu.curso.domain.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//NOTA: Esta clase No se puede llamar User, user es una palabra reservada para H2 y va a dar error con el DDL de la tabla
@Entity
@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true) 
@RequiredArgsConstructor
public class Usuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private final String username;	
	private final String password;
	private final String nombrePersona;
	private final String ciudad;
	private final String barrio;
	private final String direccion;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		return username;
	}

	//Devolvemos true ya que en este caso la cuenta no expira
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	return true;
	}

	@Override
	public boolean isEnabled() {
	return true;
	}

}
