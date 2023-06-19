package edu.curso.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import edu.curso.service.UserService;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityCustomConfig {

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

		authenticationProvider.setUserDetailsService(userService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());

		return authenticationProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http.authorizeHttpRequests(authorize -> {
			try {
                authorize
                        .requestMatchers("/design", "/ordenes").hasRole("USER")
                        .requestMatchers("/", "/**").permitAll()
                        .and()
                        .formLogin(login -> login.loginPage("/login")
                                .defaultSuccessUrl("/design"))
                        .logout(logout -> logout
                                .logoutSuccessUrl("/"))
                        //Necesario para acceder a la console de h2
                        .authorizeHttpRequests(auth -> auth .requestMatchers(toH2Console()).permitAll())
                        .csrf(csrf -> csrf .ignoringRequestMatchers(toH2Console()))
                        .headers(headers -> headers.frameOptions().sameOrigin());
			} catch (Exception e) {
				throw new RuntimeException("Error en filterChain");
			}
		}).build();
	}
}
