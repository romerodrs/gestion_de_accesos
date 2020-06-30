package com.linkeIT.api.manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.linkeIT.api.dao.VisitanteDao;
import com.linkeIT.api.model.dto.VisitanteDto;

@Component
public class VisitanteManagerImpl implements VisitanteManager{

	private static final Logger log = LogManager.getLogger(VisitanteManagerImpl.class);
	
	@Autowired
	private VisitanteDao visitanteDao;
	
	@Override
	public VisitanteDto recuperarInfoVisitanteMedianteDNI(String dni) {
		log.debug("RegistroVisitasManager.recuperarInfoVisitanteMedianteDNI");
		return visitanteDao.recuperarInfoVisitanteMedianteDNI(dni);
	}

	@Override
	public VisitanteDto guardarNuevoVisitante(VisitanteDto visitanteDto) {
		log.debug("RegistroVisitasManager.guardarNuevoVisitante");
		return visitanteDao.guardarNuevoVisitante(visitanteDto);
	}

}
