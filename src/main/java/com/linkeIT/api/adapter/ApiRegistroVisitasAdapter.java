package com.linkeIT.api.adapter;

import com.linkeIT.api.model.ConsultarRegistroVisitaRequest;
import com.linkeIT.api.model.ConsultarRegistroVisitaResponse;
import com.linkeIT.api.model.NuevoRegistroVisitaRequest;
import com.linkeIT.api.model.NuevoRegistroVisitaResponse;
import com.linkeIT.api.model.SalidaRegistroVisitaRequest;
import com.linkeIT.api.model.SalidaRegistroVisitaResponse;

public interface ApiRegistroVisitasAdapter {
	
	/**
	 * Operación que se encargar de gestionar cuando el controlador pide solicita un nuevo registro de visita
	 * @param inputData - la request con los datos del nuevo registro de vistias
	 * @return la respuesta al nuevo registro de visitas
	 */
	public NuevoRegistroVisitaResponse doNuevoRegistroVisitaOperation(NuevoRegistroVisitaRequest inputData);
	
	/**
	 * Operación que se encargar de gestionar cuando el controlador pide solicita registrar una salida para un registro de visitas
	 * @param idRegistroVisita - el identificador unico de la visita
	 * @param inputData - la request con los datos de la salida a registrar
	 * @return la respuesta a la peticion
	 */
	public SalidaRegistroVisitaResponse doSalidaRegistroVisitaOperation(Long idRegistroVisita, SalidaRegistroVisitaRequest inputData);
	
	/**
	 * Operacion que se encarga de gestionar cuando el controlador solicita una consulta del registro de visitas.
	 * @param inputData - la request con los datos que queremos consultar
	 * @return la respuesta a la peticion
	 */
	public ConsultarRegistroVisitaResponse doConsultaRegistroVisitaOperation(ConsultarRegistroVisitaRequest inputData);
	
}
