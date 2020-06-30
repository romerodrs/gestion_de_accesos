package com.linkeIT.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registroVisitas")
public class RegistroVisitas {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idvisita")
    private Long idVisita;
	@Column(name="dni")
	private String dni;
	@Column(name="fechaentrada")
	private LocalDateTime fechaEntrada;
	@Column(name="fechasalida")
	private LocalDateTime fechaSalida;
	@Column(name="tipovisita")
	private String tipoVisita;
	
	public Long getIdVisita() {
		return idVisita;
	}
	public void setIdVisita(Long idVisita) {
		this.idVisita = idVisita;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
