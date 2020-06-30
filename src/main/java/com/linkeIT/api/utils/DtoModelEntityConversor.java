package com.linkeIT.api.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.linkeIT.api.model.ConsultarRegistroVisitaRequest;
import com.linkeIT.api.model.NuevoRegistroVisitaRequest;
import com.linkeIT.api.model.SalidaRegistroVisitaRequest;
import com.linkeIT.api.model.TipoVisita;
import com.linkeIT.api.model.Visitante;
import com.linkeIT.api.model.dto.RegistroVisitasDto;
import com.linkeIT.api.model.dto.VisitanteDto;

@Service
public class DtoModelEntityConversor {
	/**
	 * Operacion que convierte un NuevoRegistroVisitaRequest a RegistroVisitasDto 
	 * @param nuevoRegistroVisitaRequest la peticion
	 * @return el objeto transformado
	 */
	public RegistroVisitasDto nuevoRegistroVisitaRequestToRegistroVisitasDto(NuevoRegistroVisitaRequest nuevoRegistroVisitaRequest) {
		RegistroVisitasDto registroVisitasDto = new RegistroVisitasDto();
		
		VisitanteDto visitanteDto = visitanteModelAVisitaDto( nuevoRegistroVisitaRequest.getvisitante() );
		LocalDateTime fechaEntrada = offsetDateTimeToLocalDateTime(nuevoRegistroVisitaRequest.getFechaEntrada());
		String tipoVisita = nuevoRegistroVisitaRequest.getTipoVisita().toString();
		
		registroVisitasDto.setVisitante(visitanteDto);
		registroVisitasDto.setFechaEntrada(fechaEntrada);
		registroVisitasDto.setTipoVisita(tipoVisita);
		
		return registroVisitasDto;
	}
	
	/**
	 * Operacion que convierte un RegistroVisitasDto a RegistroVisitas(Entidad)
	 * @param registroVisitasDto la peticion
	 * @return el objeto transformado
	 */	
	public com.linkeIT.api.entity.RegistroVisitas registroVisitasDtoRegistroVisitasEntity(RegistroVisitasDto registroVisitasDto) {
		com.linkeIT.api.entity.RegistroVisitas registroVisitas = new com.linkeIT.api.entity.RegistroVisitas();
		registroVisitas.setIdVisita(registroVisitasDto.getIdVisita());
		registroVisitas.setDni(registroVisitasDto.getVisitante().getDni());
		registroVisitas.setFechaEntrada(registroVisitasDto.getFechaEntrada());
		registroVisitas.setFechaSalida(registroVisitasDto.getFechaSalida());
		registroVisitas.setTipoVisita(registroVisitasDto.getTipoVisita());
		return registroVisitas;
	}
	
	/**
	 * Operacion que convierte un RegistroVisitasDto a RegistroVisitas(Entidad)
	 * @param registroVisitasDto la peticion
	 * @return el objeto transformado
	 */	
	public com.linkeIT.api.model.RegistroVisitas registroVisitasDtoRegistroVisitasModel(RegistroVisitasDto registroVisitasDto) {
		com.linkeIT.api.model.RegistroVisitas registroVisitas = new com.linkeIT.api.model.RegistroVisitas();
		registroVisitas.setDni(registroVisitasDto.getVisitante().getDni());
		registroVisitas.setFechaInicial(localDateTimeToOffsetDateTime(registroVisitasDto.getFechaEntrada()));
		registroVisitas.setFechaFinal(localDateTimeToOffsetDateTime(registroVisitasDto.getFechaSalida()));
		registroVisitas.setTipoVisita(TipoVisita.fromValue(registroVisitasDto.getTipoVisita()));
		return registroVisitas;
	}
	
	/**
	 * Operacion que convierte un RegistroVisitas(Entidad) a RegistroVisitasDto 
	 * @param registroVisitas la peticion
	 * @return el objeto transformado
	 */	
	public RegistroVisitasDto registroVisitasEntityRegistroVisitasDto(com.linkeIT.api.entity.RegistroVisitas registroVisitas) {
		RegistroVisitasDto registroVisitasDto = new RegistroVisitasDto();
		registroVisitasDto.setIdVisita(registroVisitas.getIdVisita());
		VisitanteDto visitanteDto = new VisitanteDto();
		visitanteDto.setDni(registroVisitas.getDni());
		registroVisitasDto.setVisitante(visitanteDto);
		registroVisitasDto.setFechaEntrada(registroVisitas.getFechaEntrada());
		registroVisitasDto.setFechaSalida(registroVisitas.getFechaSalida());
		registroVisitasDto.setTipoVisita(registroVisitas.getTipoVisita());
		return registroVisitasDto;
	}
	
	/**
	 * Operacion que transforma un SalidaRegistroVisitaRequest + id en un Registro de visitaDto
	 * @param idRegistroVisita - id del reg.visita
	 * @param inputData - datos de entrada
	 * @return el registro de visitas
	 */
	public RegistroVisitasDto salidaRegistroVisitaRequestToRegistroVisitasDto(Long idRegistroVisita,	SalidaRegistroVisitaRequest inputData) {
		RegistroVisitasDto registroVisitasDto = new RegistroVisitasDto();
		registroVisitasDto.setIdVisita(idRegistroVisita);
		registroVisitasDto.setFechaSalida(offsetDateTimeToLocalDateTime(inputData.getfechaSalida()));
		VisitanteDto visitanteDto= new VisitanteDto();
		visitanteDto.setDni(inputData.getDni());
		registroVisitasDto.setVisitante(visitanteDto);
		return registroVisitasDto;
	}
	
	
	
	/**
	 * Operacion que recupera las fechas de ConsultarRegistroVisitaRequest y las introduce en un Registro de visitas para consultar un rango de fechas
	 * @param inputData - datos de entrada
	 * @return el registro de visitas
	 */
	public RegistroVisitasDto generarRegistroDeVisitasParaConsultarRangoMedianteConsultarRegistroVisitaRequest(ConsultarRegistroVisitaRequest inputData) {
		RegistroVisitasDto registroVisitasDto = new RegistroVisitasDto();
		registroVisitasDto.setFechaEntrada(offsetDateTimeToLocalDateTime(inputData.getFechaInicialRango()));
		registroVisitasDto.setFechaSalida(offsetDateTimeToLocalDateTime(inputData.getFechaFinalRango()));
		return registroVisitasDto;
	}
	
	/**
	 * Operacion que convierte un Visitante(Model) a VisitanteDto
	 * @param visitante la peticion
	 * @return el objeto transformado
	 */
	public VisitanteDto visitanteModelAVisitaDto(Visitante visitante) {
		VisitanteDto visitanteDto = new VisitanteDto();
		visitanteDto.setDni(visitante.getDni());
		visitanteDto.setNombreCompleto(visitante.getNombreCompleto());
		visitanteDto.setEmpresa(visitante.getEmpresa());
		return visitanteDto;
	}
	/**
	 * Operacion que convierte un Visitante(Entidad) a VisitanteDto
	 * @param visitante la peticion
	 * @return el objeto transformado
	 */	
	public VisitanteDto visitanteEntityAVisitanteDto(com.linkeIT.api.entity.Visitante visitante) {
		VisitanteDto visitanteDto = new VisitanteDto();
		visitanteDto.setDni(visitante.getDni());
		visitanteDto.setNombreCompleto(visitante.getNombreCompleto());
		visitanteDto.setEmpresa(visitante.getEmpresa());
		return visitanteDto;
	}
	/**
	 * Operacion que convierte un VisitanteDto a Visitante(Entidad)
	 * @param visitanteDto la peticion
	 * @return el objeto transformado
	 */	
	public com.linkeIT.api.entity.Visitante visitanteDtoAVisitanteEntity(VisitanteDto visitanteDto) {
		com.linkeIT.api.entity.Visitante visitante = new com.linkeIT.api.entity.Visitante();
		visitante.setDni(visitanteDto.getDni());
		visitante.setNombreCompleto(visitanteDto.getNombreCompleto());
		visitante.setEmpresa(visitanteDto.getEmpresa());
		return visitante;
	}
	

	
// OPERACIONES DE FECHA
	/**
	 * Convierte un OffsetDateTime en LocalDateTime.
	 * @param offsetDateTime - el OffsetDateTime a convertir
	 * @return el LocalDateTime
	 */
	public LocalDateTime offsetDateTimeToLocalDateTime(OffsetDateTime offsetDateTime) {
		LocalDateTime result = null;
		if (offsetDateTime != null) {
			result = LocalDateTime.ofInstant(offsetDateTime.toInstant(), ZoneOffset.UTC);
		}
		return result;
	}
	
	/**
	 * Convierte un LocalDateTime en OffsetDateTime.
	 * @param date - el LocalDateTime a convertir
	 * @return el OffsetDateTime
	 */
	public OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime date) {
		OffsetDateTime result = null;
		if (date != null) {
			result = date.atOffset(ZoneOffset.UTC);
		}
		return result;
	}


}
