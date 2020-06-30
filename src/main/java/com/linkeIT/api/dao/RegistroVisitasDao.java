package com.linkeIT.api.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.linkeIT.api.model.dto.RegistroVisitasDto;

public interface RegistroVisitasDao {
	/**
	 * Operacion que borra registros de visitas de la base de datos con una fecha de entrada superior a la indicada
	 * @param fechaEntrada - la fecha de entrada a partir de la que se tienen que borrar los registros
	 */
	public void borrarRegistroVisitaCaducado(LocalDateTime fechaEntrada);
	
	/**
	 * Operacion que registra una nueva visita en base de datos
	 * @param registroVisitasDto - la visita a registrar
	 * @return la visita registrada
	 */
	public RegistroVisitasDto guardarRegistroVisita(RegistroVisitasDto registroVisitasDto);
	
	
	/**
	 * Operacion que recupera una visita
	 * @param registroVisitasDto - los datos a recuperar
	 * @return el registro de visita
	 */
	public RegistroVisitasDto recuperarRegistroVisita(RegistroVisitasDto registroVisitasDto);
	
	/**
	 * Operacion que recupera una lista de registros de visitas en un periodo de tiempo
	 * @param registroVisitasDto - los datos a recuperar
	 * @return los registros de visitas
	 */
	public List<RegistroVisitasDto> recuperarRegistroVisitasEnUnPeriodo(RegistroVisitasDto registroVisitasDto);
}
