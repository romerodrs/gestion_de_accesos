package com.linkeIT.api.dao;

import com.linkeIT.api.model.dto.VisitanteDto;

public interface VisitanteDao {

	/**
	 * Operacion para recuperar la informacion del visitante de BD mediante el dni
	 * @param dni - el Dni del visitante
	 * @return la informacion del visitante
	 */
	public VisitanteDto recuperarInfoVisitanteMedianteDNI(String dni);

	/**
	 * Operacion para guardar la informacion de un nuevo visitante en BD
	 * @param visitanteDto - el visitante
	 * @return la informacion del visitante
	 */
	public VisitanteDto guardarNuevoVisitante(VisitanteDto visitanteDto);
	
}
