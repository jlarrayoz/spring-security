package edu.curso.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.dto.RegistrationDto;
import edu.curso.models.security.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/registrarse")
public class RegistrationController {
	
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;
	
	public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	/**
	 * Retorna el nombre del template asociado al controller
	 * @param model Inyecta el modelo para poner datos en el
	 * @return String con la página a navegar
	 */
	@GetMapping
	public String mostrarFormulario(Model model) {
		RegistrationDto formDto = new RegistrationDto();
	    model.addAttribute("formDto", formDto);
		return "registration";
	}
	
	/**
	 * Procesar el formulario de registro de usuarios
	 * @param formDto dto con los datos de la pantalla
	 * @return Si todo sale ok, redirecciona al login, en caso contrario se queda en la página actual
	 */
	@PostMapping
	public String processRegistration(@Valid @ModelAttribute("formDto") RegistrationDto formDto, Errors errores) {
		
		if (errores.hasErrors()) {
			log.error("Se encontraror errores al validar: {}", errores.getAllErrors());
			return "registration";
		}
		
		log.info("Guardadno usuario: {}", formDto.getUsername());
		userRepo.save(formDto.toUsuario(passwordEncoder));
		
		return "redirect:/login";
	}
}
