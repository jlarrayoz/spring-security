package edu.curso.service;

import org.springframework.stereotype.Service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrdenAdminService {
	
	@PersistenceContext
    private EntityManager entityManager;

	public void eliminarOrdenes() {
		int cantidad = entityManager.createQuery("Delete from OrdenPizza o").executeUpdate();
		
		log.info("Se borraron {} registros", cantidad);
	}
	
}
