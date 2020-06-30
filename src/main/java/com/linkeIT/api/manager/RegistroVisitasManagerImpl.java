package com.linkeIT.api.manager;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.linkeIT.api.dao.RegistroVisitasDao;
import com.linkeIT.api.model.dto.RegistroVisitasDto;

@Component
public class RegistroVisitasManagerImpl implements RegistroVisitasManager{
	private static final Logger log = LogManager.getLogger(RegistroVisitasManagerImpl.class);
	@Autowired
	private RegistroVisitasDao registroVisitasDao;
	
	@Override
	public RegistroVisitasDto registrarNuevaVisita(RegistroVisitasDto registroVisitasDto) {
		log.debug("RegistroVisitasManager.registrarNuevaVisita");
		return registroVisitasDao.guardarRegistroVisita(registroVisitasDto);
	}

	@Override
	public RegistroVisitasDto recuperarRegistroVisita(RegistroVisitasDto registroVisitasDto) {
		log.debug("RegistroVisitasManager.recuperarRegistroVisita");
		return registroVisitasDao.recuperarRegistroVisita(registroVisitasDto);
	}

	@Override
	public RegistroVisitasDto guardarRegistroVisitaConFechaSalida(RegistroVisitasDto registroVisitasDto) {
		log.debug("RegistroVisitasManager.guardarRegistroVisitaConFechaSalida");
		return registroVisitasDao.guardarRegistroVisita(registroVisitasDto);
	}
	
	@Override
	public List<RegistroVisitasDto> recuperarRegistroVisitasEnUnPeriodo(RegistroVisitasDto registroVisitasDto) {
		log.debug("RegistroVisitasManager.recuperarRegistroVisitasEnUnPeriodo");
		return registroVisitasDao.recuperarRegistroVisitasEnUnPeriodo(registroVisitasDto);
	}

	@Override
	public void borrarRegistroVisitasCaducadas(LocalDateTime fechaEntrada) {
		log.debug("RegistroVisitasManager.borrarRegistroVisitasCaducadas");
		registroVisitasDao.borrarRegistroVisitaCaducado(fechaEntrada);
	}


}
