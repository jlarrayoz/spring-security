package edu.curso.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.curso.domain.security.Usuario;
import edu.curso.models.security.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private UserRepository repo;
	

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Usuario user = repo.findByUsername(username);
		 if (user != null) {
			 return user;
		 }
		 else {
			 throw new UsernameNotFoundException("El usuario:" + username + " no existe");
		 }
	}
}
