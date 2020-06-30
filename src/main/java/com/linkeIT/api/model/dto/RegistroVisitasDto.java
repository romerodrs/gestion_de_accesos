package com.linkeIT.api.model.dto;

import java.time.LocalDateTime;

public class RegistroVisitasDto {

    private Long idVisita;
	private VisitanteDto visitante;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private String tipoVisita;
	
	public Long getIdVisita() {
		return idVisita;
	}
	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}
	public VisitanteDto getVisitante() {
		return visitante;
	}
	public void setVisitante(VisitanteDto visitante) {
		this.visitante = visitante;
	}
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getTipoVisita() {
		return tipoVisita;
	}
	public void setTipoVisita(String tipoVisita) {
		this.tipoVisita = tipoVisita;
	}
	
}
