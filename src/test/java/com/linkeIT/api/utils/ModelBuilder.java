package com.linkeIT.api.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.linkeIT.api.model.ConsultarRegistroVisitaRequest;
import com.linkeIT.api.model.NuevoRegistroVisitaRequest;
import com.linkeIT.api.model.SalidaRegistroVisitaRequest;
import com.linkeIT.api.model.TipoVisita;
import com.linkeIT.api.model.dto.RegistroVisitasDto;
import com.linkeIT.api.model.dto.VisitanteDto;

@RunWith(MockitoJUnitRunner.class)
public class ModelBuilder {

	public RegistroVisitasDto buildRegistroVisitasDto() {
		RegistroVisitasDto registroVisitasDto = new RegistroVisitasDto();
		registroVisitasDto.setIdVisita(1L);
		registroVisitasDto.setVisitante(buildVisitanteDto());
		registroVisitasDto.setFechaEntrada(LocalDateTime.now());
		registroVisitasDto.setFechaSalida(LocalDateTime.now());
		registroVisitasDto.setTipoVisita(TipoVisita.OTROS.toString());
		return registroVisitasDto;
	}
	
	public com.linkeIT.api.entity.RegistroVisitas buildRegistroVisitasEntity() {
		com.linkeIT.api.entity.RegistroVisitas entity = new com.linkeIT.api.entity.RegistroVisitas();
		entity.setDni("00000000T");
		entity.setFechaEntrada(LocalDateTime.now());
		entity.setFechaSalida(LocalDateTime.now());
		entity.setIdVisita(1L);
		entity.setTipoVisita(TipoVisita.OTROS.toString());
		return entity;
	}
	

	public com.linkeIT.api.model.RegistroVisitas buildRegistroVisitasModel() {
		com.linkeIT.api.model.RegistroVisitas model = new com.linkeIT.api.model.RegistroVisitas();
		model.setDni("00000000T");
		model.setEmpresa("LinkeIt");
		model.setFechaFinal(OffsetDateTime.now());
		model.setFechaInicial(OffsetDateTime.now());
		model.setNombreCompleto("usuario para test");
		model.setTipoVisita(TipoVisita.OTROS);
		return model;
	}
	
	public VisitanteDto buildVisitanteDto() {
		VisitanteDto visitanteDto = new VisitanteDto();
		visitanteDto.setDni("00000000T");
		visitanteDto.setEmpresa("LinkeIT");
		visitanteDto.setIdRegistro(0L);
		visitanteDto.setNombreCompleto("usuario para test");
		return visitanteDto;
	}

	public List<RegistroVisitasDto> buildRegistroVisitasListDto() {
		List<RegistroVisitasDto> registroVisitasList = new ArrayList<>();
		registroVisitasList.add(buildRegistroVisitasDto());
		registroVisitasList.add(buildRegistroVisitasDto());
		registroVisitasList.add(buildRegistroVisitasDto());
		return registroVisitasList;
	}



	public List<com.linkeIT.api.entity.RegistroVisitas> buildRegistroVisitasEntityList() {
		List<com.linkeIT.api.entity.RegistroVisitas> entityList = new ArrayList<com.linkeIT.api.entity.RegistroVisitas>();
		entityList.add(buildRegistroVisitasEntity());
		entityList.add(buildRegistroVisitasEntity());
		entityList.add(buildRegistroVisitasEntity());
		return entityList;
	}

	public com.linkeIT.api.entity.Visitante buildVisitanteEntity() {
		com.linkeIT.api.entity.Visitante entity = new com.linkeIT.api.entity.Visitante();
		entity.setDni("00000000T");
		entity.setEmpresa("LinkeIt");
		entity.setNombreCompleto("usuario para test");
		return entity;
	}
	
	public com.linkeIT.api.model.Visitante buildVisitanteModel() {
		com.linkeIT.api.model.Visitante model = new com.linkeIT.api.model.Visitante();
		model.setDni("00000000T");
		model.setEmpresa("LinkeIt");
		model.setNombreCompleto("usuario para test");
		return model;
	}
	
	public NuevoRegistroVisitaRequest buildNuevoRegistroVisitasRequest() {
		NuevoRegistroVisitaRequest nuevoRegistroVisitaRequest = new NuevoRegistroVisitaRequest();
		nuevoRegistroVisitaRequest.setFechaEntrada(OffsetDateTime.now());
		nuevoRegistroVisitaRequest.setTipoVisita(TipoVisita.OTROS);
		nuevoRegistroVisitaRequest.setvisitante(buildVisitanteModel());
		return nuevoRegistroVisitaRequest;
	}
	
	public SalidaRegistroVisitaRequest buildSalidaRegistroVisitaRequest() {
		SalidaRegistroVisitaRequest salidaRegistroVisitaRequest = new SalidaRegistroVisitaRequest();
		salidaRegistroVisitaRequest.setDni("00000000T");
		salidaRegistroVisitaRequest.setfechaSalida(OffsetDateTime.now());
		return salidaRegistroVisitaRequest;
	}
	
	public ConsultarRegistroVisitaRequest buildConsultarRegistroVisitaRequest() {
		ConsultarRegistroVisitaRequest consultarRegistroVisitaRequest = new ConsultarRegistroVisitaRequest();
		consultarRegistroVisitaRequest.setFechaFinalRango(OffsetDateTime.now());
		consultarRegistroVisitaRequest.setFechaInicialRango(OffsetDateTime.now().plusHours(1));
		return consultarRegistroVisitaRequest; 
	}

}
