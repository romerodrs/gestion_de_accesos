package com.linkeIT.api.cron;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.linkeIT.api.manager.RegistroVisitasManager;

@Component
public class BorrarRegistroVisitasAntiguosCron {
	private static final Logger logger = LogManager.getLogger(BorrarRegistroVisitasAntiguosCron.class);
	
	@Value("${registrovitas.caducidad.years}")
	private int tiempoCaducidadRegistroVisitas;
	
	@Autowired
	private RegistroVisitasManager registroVisitasManager;
	
	/**
	 * Cron que se encarga de borrar los registros de visitas con una fecha inicial a la indicada en registrovitas.caducidad.years
	 */
	@Scheduled(cron = "${cron.borrarVisitas}")
	public void borrarRegistroVisitasCaducadas() {
		logger.debug("--- INICIANDO CRON BORRADO DE VISITAS CADUCADAS ---");
		LocalDateTime fechaEntrada = LocalDateTime.now(ZoneOffset.UTC);
		registroVisitasManager.borrarRegistroVisitasCaducadas(fechaEntrada.minusYears(tiempoCaducidadRegistroVisitas));
		logger.debug("--- FINALIZADO CRON BORRADO DE VISITAS CADUCADAS ---");
	}
}
