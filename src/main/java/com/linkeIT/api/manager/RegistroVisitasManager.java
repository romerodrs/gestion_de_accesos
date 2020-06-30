package com.linkeIT.api.manager;

import java.time.LocalDateTime;
import java.util.List;

import com.linkeIT.api.model.dto.RegistroVisitasDto;

public interface RegistroVisitasManager {
	
	/**
	 * Operacion que permite registrar una nueva visita
	 * @param registroVisitasDto - los datos a guardar
	 * @return el registro de visitas guardado
	 */
	public RegistroVisitasDto registrarNuevaVisita(RegistroVisitasDto registroVisitasDto);

	/**
	 * Operacion que recupera una visita
	 * @param registroVisitasDto - los datos a recuperar
	 * @return el registro de visita
	 */
	public RegistroVisitasDto recuperarRegistroVisita(RegistroVisitasDto registroVisitasDto);

	/**
	 * Operacion que guarda/actualiza la fecha de salida en un registro de visita
	 * @param registroVisitasDto - los datos a recuperar
	 * @return el registro de visita
	 */
	public RegistroVisitasDto guardarRegistroVisitaConFechaSalida(RegistroVisitasDto registroVisitasDto);
	
	/**
	 * Operacion que recupera una lista de registros de visitas en un periodo de tiempo
	 * @param registroVisitasDto - los datos a recuperar
	 * @return los registros de visitas
	 */
	public List<RegistroVisitasDto> recuperarRegistroVisitasEnUnPeriodo(RegistroVisitasDto registroVisitasDto);
	
	/**
	 * Operacion que borra registros de visitas de la base de datos con una fecha de entrada superior a la indicada
	 * @param fechaEntrada - la fecha de entrada a partir de la que se tienen que borrar los registros
	 */
	public void borrarRegistroVisitasCaducadas(LocalDateTime fechaEntrada);

}
