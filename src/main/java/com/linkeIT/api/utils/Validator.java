package com.linkeIT.api.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class Validator {
	/**
	 * Valida que una fecha es superior a otra
	 * @param fechaInicial - la fecha inicial de un periodo.
	 * @param fechaFinal - la fecha final de un periodo.
	 * @return indica si el periodo es correcto.
	 */
	public Boolean validarPeriodo(LocalDateTime fechaInicial, LocalDateTime fechaFinal)  {
		Boolean result = Boolean.TRUE;
		if (fechaFinal != null && fechaInicial != null && (fechaFinal.isBefore(fechaInicial) || fechaFinal.equals(fechaInicial))) {
			result = Boolean.FALSE;
		}
		return result;
	}
}
