package com.linkeIT.api.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linkeIT.api.model.ConsultarRegistroVisitaRequest;
import com.linkeIT.api.model.ConsultarRegistroVisitaResponse;
import com.linkeIT.api.model.NuevoRegistroVisitaRequest;
import com.linkeIT.api.model.NuevoRegistroVisitaResponse;
import com.linkeIT.api.model.SalidaRegistroVisitaRequest;
import com.linkeIT.api.model.SalidaRegistroVisitaResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "gestion-accessos", description = "conjunto de operaciones para la gestion de accesos a una empresa")
public interface ApiRestController {
	
    @ApiOperation(value = "registra una nueva visita", nickname = "registrarEntradaVisita", notes = "", response = NuevoRegistroVisitaResponse.class, tags={ "gestion-accessos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Informacion de la nueva visita creada", response = NuevoRegistroVisitaResponse.class),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Authorization information is missing or invalid"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Server Error") })
    @RequestMapping(value = "/api/visitas/registrar-nueva/",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<NuevoRegistroVisitaResponse> registrarEntradaVisita(@ApiParam(value = "Input data parameters" ,required=true )  @Valid @RequestBody NuevoRegistroVisitaRequest inputData);
	
    @ApiOperation(value = "registra la salida de una visita", nickname = "registrarSalidaVisita", notes = "", response = SalidaRegistroVisitaResponse.class, tags={ "gestion-accessos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Informacion de la nueva visita creada", response = SalidaRegistroVisitaResponse.class),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Authorization information is missing or invalid"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Server Error") })
    @RequestMapping(value = "/api/visitas/registrar-salida/{idRegistroVisita}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<SalidaRegistroVisitaResponse> registrarSalidaVisita(@ApiParam(value = "id del registro de visita para validar salida",required=true) @PathVariable("idRegistroVisita") Long idRegistroVisita,@ApiParam(value = "" ,required=true )  @Valid @RequestBody SalidaRegistroVisitaRequest inputData);
	
    
    @ApiOperation(value = "consulta las visitas en un rango de fechas", nickname = "consultarRegistrosVisitasRango", notes = "", response = ConsultarRegistroVisitaResponse.class, tags={ "gestion-accessos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lista de regitros para el periodo requerido", response = ConsultarRegistroVisitaResponse.class),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "Authorization information is missing or invalid"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Server Error") })
    @RequestMapping(value = "/api/visitas/consultar-rango-fechas",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<ConsultarRegistroVisitaResponse> consultarRegistrosVisitasRango(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ConsultarRegistroVisitaRequest inputData);
}
