package com.linkeIT.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linkeIT.api.adapter.ApiRegistroVisitasAdapter;
import com.linkeIT.api.model.ConsultarRegistroVisitaRequest;
import com.linkeIT.api.model.ConsultarRegistroVisitaResponse;
import com.linkeIT.api.model.NuevoRegistroVisitaRequest;
import com.linkeIT.api.model.NuevoRegistroVisitaResponse;
import com.linkeIT.api.model.SalidaRegistroVisitaRequest;
import com.linkeIT.api.model.SalidaRegistroVisitaResponse;

@Controller
public class ApiRestControllerImpl implements ApiRestController{

	private static final Logger log = LoggerFactory.getLogger(ApiRestControllerImpl.class);

	@Autowired
	private ApiRegistroVisitasAdapter apiRegistroVisitasAdapter;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public ApiRestControllerImpl(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.request = request;
	}

	private String getAcceptHeader() {
		String result = null;
		if (request != null) {
			result = request.getHeader("Accept");
		}
		return result;
	}

	private boolean isCorrectAcceptHeader() {
		return !StringUtils.isEmpty(getAcceptHeader()) && getAcceptHeader().toLowerCase().contains("application/json");
	}

	@Override
	public ResponseEntity<NuevoRegistroVisitaResponse> registrarEntradaVisita(
			@Valid NuevoRegistroVisitaRequest inputData) {
		log.debug("-- INICIO apiRestControllerImpl.registrarEntradaVisita");
		if(objectMapper != null && getAcceptHeader() != null) {
			if (isCorrectAcceptHeader()) {
				try {
					NuevoRegistroVisitaResponse response = apiRegistroVisitasAdapter.doNuevoRegistroVisitaOperation(inputData);
					return ResponseEntity.ok(response);
				} catch (Exception e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn("ObjectMapper or HttpServletRequest not configured in default RegistrarNuevaApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<SalidaRegistroVisitaResponse> registrarSalidaVisita(Long idRegistroVisita,
			@Valid SalidaRegistroVisitaRequest inputData) {
		log.debug("-- INICIO apiRestControllerImpl.registrarSalidaVisita");
		if(objectMapper != null && getAcceptHeader() != null) {
			if (isCorrectAcceptHeader()) {
				try {
					SalidaRegistroVisitaResponse response = apiRegistroVisitasAdapter.doSalidaRegistroVisitaOperation(idRegistroVisita, inputData);
					return ResponseEntity.ok(response);
				} catch (Exception e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn("ObjectMapper or HttpServletRequest not configured in default RegistrarSalidaApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<ConsultarRegistroVisitaResponse> consultarRegistrosVisitasRango(
			@Valid ConsultarRegistroVisitaRequest inputData) {
		log.debug("-- INICIO apiRestControllerImpl.consultarRegistrosVisitasRango");
		if(objectMapper != null && getAcceptHeader() != null) {
			if (isCorrectAcceptHeader()) {
				try {
					ConsultarRegistroVisitaResponse response = apiRegistroVisitasAdapter.doConsultaRegistroVisitaOperation(inputData);
					return ResponseEntity.ok(response);
				} catch (Exception e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn("ObjectMapper or HttpServletRequest not configured in default ConsultarRangoFechasApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}


}
