package com.linkeIT.api.adapter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.linkeIT.api.manager.RegistroVisitasManager;
import com.linkeIT.api.manager.VisitanteManager;
import com.linkeIT.api.model.ConsultarRegistroVisitaRequest;
import com.linkeIT.api.model.ConsultarRegistroVisitaResponse;
import com.linkeIT.api.model.Error;
import com.linkeIT.api.model.ListaRegistroVisitas;
import com.linkeIT.api.model.NuevoRegistroVisitaRequest;
import com.linkeIT.api.model.NuevoRegistroVisitaResponse;
import com.linkeIT.api.model.RegistroVisitas;
import com.linkeIT.api.model.Result;
import com.linkeIT.api.model.SalidaRegistroVisitaRequest;
import com.linkeIT.api.model.SalidaRegistroVisitaResponse;
import com.linkeIT.api.model.dto.RegistroVisitasDto;
import com.linkeIT.api.model.dto.VisitanteDto;
import com.linkeIT.api.utils.DtoModelEntityConversor;
import com.linkeIT.api.utils.Validator;

@Component
public class ApiRegistroVisitasAdapterImpl implements ApiRegistroVisitasAdapter{

	private static final Logger log = LogManager.getLogger(ApiRegistroVisitasAdapterImpl.class);
	
	@Autowired
	private DtoModelEntityConversor dtoModelConversor;
	
	@Autowired
	private VisitanteManager visitanteManager;
	
	@Autowired
	private RegistroVisitasManager registroVisitasManager;
	
	@Autowired
	private Validator validator;
	
	@Override
	public NuevoRegistroVisitaResponse doNuevoRegistroVisitaOperation(NuevoRegistroVisitaRequest inputData) {
		log.debug("INICIO doNuevoRegistroVisitaOperation");
		log.debug("REQUEST " + inputData.toString());
		NuevoRegistroVisitaResponse response = new NuevoRegistroVisitaResponse();
		List<Error> errors = new ArrayList<>();
		RegistroVisitasDto registroVisitasDto = dtoModelConversor.nuevoRegistroVisitaRequestToRegistroVisitasDto(inputData);
		VisitanteDto visitanteDto = registroVisitasDto.getVisitante();
		if (visitanteDto.getEmpresa() == null || visitanteDto.getNombreCompleto() == null ) {
			log.debug("Buscando info completa del visitante");
			VisitanteDto visitanteDtoDB = visitanteManager.recuperarInfoVisitanteMedianteDNI(visitanteDto.getDni());
			if (visitanteDtoDB == null) {
				log.debug("El usuario introducido no existe en la BD, introducir los datos que faltan");
				Error error = new Error();
				error.setDescription("El usuario introducido no existe en la BD, introducir los datos que faltan");
				errors.add(error);
			} else {
				log.debug("Usuario encontrado en BD, introduciendo datos en el registro de visita");
				registroVisitasDto.setVisitante(visitanteDtoDB);
			}
		}else {
			log.debug("Guardando nueva visita");
			visitanteManager.guardarNuevoVisitante(visitanteDto);
		}
		if (errors != null && !errors.isEmpty()) {
			response.setErrors(errors);
			response.setResult(Result.ERROR);
		} else {
			log.debug("Registrando nueva visita");
			RegistroVisitasDto result = registroVisitasManager.registrarNuevaVisita(registroVisitasDto);
			log.debug("Fin del registro de una nueva visita");
			response.setIdRegistroVisita(String.valueOf(result.getIdVisita()));
			response.setResult(Result.OK);
		}
		log.debug("RESPONSE RESULT " + response.getResult());
		log.debug("FIN doNuevoRegistroVisitaOperation");
		return response;
	}

	@Override
	public SalidaRegistroVisitaResponse doSalidaRegistroVisitaOperation(Long idRegistroVisita, SalidaRegistroVisitaRequest inputData) {
		log.debug("INICIO doSalidaRegistroVisitaOperation");
		log.debug("idRegistroVisita " + idRegistroVisita);
		log.debug("REQUEST " + inputData.toString());
		SalidaRegistroVisitaResponse response = new SalidaRegistroVisitaResponse();
		List<Error> errors = new ArrayList<>();
		RegistroVisitasDto registroVisitasDto = dtoModelConversor.salidaRegistroVisitaRequestToRegistroVisitasDto(idRegistroVisita, inputData);
		RegistroVisitasDto registroVisitasDtoBD = registroVisitasManager.recuperarRegistroVisita(registroVisitasDto);
		if(registroVisitasDtoBD == null) {
			log.debug("El registro de visitas solicitado para realizar salida no existe en la BD.");
			Error error = new Error();
			error.setDescription("El registro de visitas solicitado para realizar salida no existe en la BD.");
			errors.add(error);	
		}else {
			log.debug("Iniciando registro de la fecha de salida.");
			registroVisitasDtoBD.setFechaSalida(registroVisitasDto.getFechaSalida());
			registroVisitasManager.guardarRegistroVisitaConFechaSalida(registroVisitasDtoBD);
			log.debug("Finalizado registro de la fecha de salida.");
		}
		if (errors != null && !errors.isEmpty()) {
			response.setErrors(errors);
			response.setResult(Result.ERROR);
		} else {
			response.setResult(Result.OK);
		}
		log.debug("RESPONSE RESULT " + response.getResult());
		log.debug("FIN doSalidaRegistroVisitaOperation");
		return response;
	}

	@Override
	public ConsultarRegistroVisitaResponse doConsultaRegistroVisitaOperation(ConsultarRegistroVisitaRequest inputData) {
		log.debug("INICIO doConsultaRegistroVisitaOperation");
		log.debug("REQUEST " + inputData.toString());
		ConsultarRegistroVisitaResponse response = new ConsultarRegistroVisitaResponse();
		ListaRegistroVisitas listaRegistroVisitas = new ListaRegistroVisitas();
		RegistroVisitasDto registroVisitasDto = dtoModelConversor.generarRegistroDeVisitasParaConsultarRangoMedianteConsultarRegistroVisitaRequest(inputData);
		if(validator.validarPeriodo(registroVisitasDto.getFechaEntrada(), registroVisitasDto.getFechaSalida())) {
			log.debug("Periodo a consultar correcto, iniciando recuperacion de registros de visitas.");
			List<RegistroVisitasDto> registroVisitasDtoList = registroVisitasManager.recuperarRegistroVisitasEnUnPeriodo(registroVisitasDto);
			List<RegistroVisitas> registroVisitasModelList = new ArrayList<>();
			if(registroVisitasDtoList != null) {
				for(RegistroVisitasDto rvDto : registroVisitasDtoList) {
					RegistroVisitas registroVisitas = dtoModelConversor.registroVisitasDtoRegistroVisitasModel(rvDto);
					VisitanteDto visitanteDto = visitanteManager.recuperarInfoVisitanteMedianteDNI(rvDto.getVisitante().getDni());
					registroVisitas.setEmpresa(visitanteDto.getEmpresa());
					registroVisitas.setNombreCompleto(visitanteDto.getNombreCompleto());
					registroVisitasModelList.add(registroVisitas);
				}
			}
			listaRegistroVisitas.setListaRegistroVisitas(registroVisitasModelList);
			response.setListaRegistroVisitas(listaRegistroVisitas);
			log.debug("Periodo a consultar correcto, finalizada recuperacion de registros de visitas.");
			response.setResult(Result.OK);
		}else {
			log.debug("Las fechas del periodo indicado no son correctas.");
			List<Error> errors = new ArrayList<>();
			Error error = new Error();
			error.setDescription("Las fechas del periodo indicado no son correctas.");
			errors.add(error);	
			response.setErrors(errors);
			response.setResult(Result.ERROR);
		}
		log.debug("RESPONSE RESULT " + response.getResult());
		log.debug("FIN doConsultaRegistroVisitaOperation");
		return response;
	}

}
