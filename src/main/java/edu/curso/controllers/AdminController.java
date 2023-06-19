package edu.curso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.curso.service.OrdenAdminService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private OrdenAdminService adminService;

	public AdminController(OrdenAdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	/**
	 * Borra todas las ordenes ingresadas al sistema
	 * @return String para redirigir a la página de admin
	 */
	@PostMapping("/borrarOrdenes")
	public String borrarOrdenes() {
		adminService.eliminarOrdenes();
		
		log.info("Redirigiendo a la página de admin");
		
		return "redirect:/admin";
	}

}
