package com.linkeIT.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.linkeIT.api.entity.Visitante;
/*
 * Clase-Repositorio que se encarga de gestionar los datos de la tabla Visitante
 */
@Repository
public interface VisitanteRepository  extends JpaRepository<Visitante, Long>{

	/**
	 * Recupera de la tabla visitante los datos de un visitante anteriormente registrado
	 * @param dni - dni del visitante
	 * @return el visitante (entity)
	 */
	@Query("select v from Visitante v where v.dni=:dni")
	public Visitante recuperaDatosVisitanteRegistradoMedianteDNI(@Param("dni") String dni);
	
}

