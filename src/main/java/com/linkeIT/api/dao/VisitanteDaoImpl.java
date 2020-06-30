package com.linkeIT.api.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.linkeIT.api.entity.Visitante;
import com.linkeIT.api.model.dto.VisitanteDto;
import com.linkeIT.api.repository.VisitanteRepository;
import com.linkeIT.api.utils.DtoModelEntityConversor;

@Component
public class VisitanteDaoImpl implements VisitanteDao{
	private static final Logger log = LogManager.getLogger(VisitanteDaoImpl.class);
	
	@Autowired
	private VisitanteRepository visitanteRepository;
	
	@Autowired
	private DtoModelEntityConversor dtoModelConvertor;
	
	@Override
	public VisitanteDto recuperarInfoVisitanteMedianteDNI(String dni) {
		log.debug("inicio recuperarInfoVisitanteMedianteDNI");
		Visitante visitanteRespuesta = visitanteRepository.recuperaDatosVisitanteRegistradoMedianteDNI(dni);
		VisitanteDto visitanteDto = null;
		if(visitanteRespuesta != null) {
			visitanteDto = dtoModelConvertor.visitanteEntityAVisitanteDto(visitanteRespuesta);
		}
		log.debug("fin recuperarInfoVisitanteMedianteDNI");
		return visitanteDto;
	}

	@Override
	public VisitanteDto guardarNuevoVisitante(VisitanteDto visitanteDto) {
		log.debug("inicio guardarNuevoVisitante");
		VisitanteDto result = null;
		Visitante visitante = dtoModelConvertor.visitanteDtoAVisitanteEntity(visitanteDto);
		Visitante visitanteRespueta = visitanteRepository.save(visitante);
		if(visitanteRespueta != null) {
			result = dtoModelConvertor.visitanteEntityAVisitanteDto(visitanteRespueta);
		}
		log.debug("fin guardarNuevoVisitante");
		return result;
	}


}
