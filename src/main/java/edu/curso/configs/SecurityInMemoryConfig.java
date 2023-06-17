/*
 * Ejemplo de In Memory User Store
 * Para que funcione debe estar comentado el contenido de UserService (Si no se comenta spring encuentra 2 bean para injectar una instancia de UserDetailsService)
 * 
package edu.curso.configs;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.List;
import java.util.ArrayList;

@Configuration
public class SecurityInMemoryConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
	  List<UserDetails> usersList = new ArrayList<UserDetails>();
	  
	  //Agrego 2 usuarios a mano
	  usersList.add(new User("usuario1", encoder.encode("pass1"), Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
	  usersList.add(new User("usuario2", encoder.encode("pass2"),Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")))); 
	  
	  return new InMemoryUserDetailsManager(usersList);
	}	
}
*/

