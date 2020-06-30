package com.linkeIT.api.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.linkeIT.api.entity.RegistroVisitas;
import com.linkeIT.api.model.dto.RegistroVisitasDto;
import com.linkeIT.api.repository.RegistroVisitasRepository;
import com.linkeIT.api.utils.DtoModelEntityConversor;

@Component
public class RegistroVisitasDaoImpl implements RegistroVisitasDao{
	private static final Logger log = LogManager.getLogger(RegistroVisitasDaoImpl.class);
	@Autowired
	private RegistroVisitasRepository registroVisitasRepository;

	@Autowired
	private DtoModelEntityConversor dtoModelEntityConveror;

	@Override
	public void borrarRegistroVisitaCaducado(LocalDateTime fechaEntrada) {
		registroVisitasRepository.borrarFechasEntradaSuperior2y(fechaEntrada);
	}

	@Override
	public RegistroVisitasDto guardarRegistroVisita(RegistroVisitasDto registroVisitasDto) {
		log.debug("inicio guardarRegistroVisita");
		RegistroVisitasDto result = null;
		if( registroVisitasDto != null) {
			RegistroVisitas registroVisitas = dtoModelEntityConveror.registroVisitasDtoRegistroVisitasEntity(registroVisitasDto);
			RegistroVisitas registroVisitasEntityResult = registroVisitasRepository.save(registroVisitas);
			result = dtoModelEntityConveror.registroVisitasEntityRegistroVisitasDto(registroVisitasEntityResult);
		}
		log.debug("fin guardarRegistroVisita");
		return result;
	}

	@Override
	public RegistroVisitasDto recuperarRegistroVisita(RegistroVisitasDto registroVisitasDto) {
		log.debug("inicio recuperarRegistroVisita");
		RegistroVisitasDto result = null;
		if(registroVisitasDto != null) {
			RegistroVisitas registroVisitasEntityResult = registroVisitasRepository.findByIdandDni(registroVisitasDto.getIdVisita(), registroVisitasDto.getVisitante().getDni());
			if(registroVisitasEntityResult != null) {
				result = dtoModelEntityConveror.registroVisitasEntityRegistroVisitasDto(registroVisitasEntityResult);
			}
		}
		log.debug("fin recuperarRegistroVisita");
		return result;
	}

	@Override
	public List<RegistroVisitasDto> recuperarRegistroVisitasEnUnPeriodo(RegistroVisitasDto registroVisitasDto) {
		log.debug("inicio recuperarRegistroVisitasEnUnPeriodo");
		List<RegistroVisitasDto> result = null;
		if(registroVisitasDto != null) {
			List<RegistroVisitas> registroVisitasEntityResultList = registroVisitasRepository.findByFechaEntradaBetweenPeriod(registroVisitasDto.getFechaEntrada(), registroVisitasDto.getFechaSalida());
			if(registroVisitasEntityResultList != null){
				result = new ArrayList<RegistroVisitasDto>();
				for(RegistroVisitas rv : registroVisitasEntityResultList) {
					RegistroVisitasDto rvDto = dtoModelEntityConveror.registroVisitasEntityRegistroVisitasDto(rv);
					result.add(rvDto);
				}
			}
		}
		log.debug("fin recuperarRegistroVisitasEnUnPeriodo");
		return result;
	}

}
