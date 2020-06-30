package com.linkeIT.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visitante")
public class Visitante {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idregistro")
    private Long idRegistro;
	@Column(name="dni")
    private String dni;
	@Column(name="nombrecompleto")
    private String nombreCompleto;
	@Column(name="empresa")
    private String empresa;
    
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
    
}
