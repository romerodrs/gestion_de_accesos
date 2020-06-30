package com.linkeIT.api.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RegistroVisitas
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-14T14:21:41.163+02:00")

public class RegistroVisitas   {
  @JsonProperty("dni")
  private String dni = null;

  @JsonProperty("nombreCompleto")
  private String nombreCompleto = null;

  @JsonProperty("empresa")
  private String empresa = null;

  @JsonProperty("fechaInicial")
  private OffsetDateTime fechaInicial = null;

  @JsonProperty("fechaFinal")
  private OffsetDateTime fechaFinal = null;

  @JsonProperty("tipoVisita")
  private TipoVisita tipoVisita = null;

  public RegistroVisitas dni(String dni) {
    this.dni = dni;
    return this;
  }

  /**
   * Get dni
   * @return dni
  **/
  @ApiModelProperty(example = "11111111A", required = true, value = "")
  @NotNull


  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public RegistroVisitas nombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
    return this;
  }

  /**
   * Get nombreCompleto
   * @return nombreCompleto
  **/
  @ApiModelProperty(example = "Daniel Romero Sanchez", required = true, value = "")
  @NotNull


  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  public RegistroVisitas empresa(String empresa) {
    this.empresa = empresa;
    return this;
  }

  /**
   * Get empresa
   * @return empresa
  **/
  @ApiModelProperty(example = "LinkeIT", required = true, value = "")
  @NotNull


  public String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public RegistroVisitas fechaInicial(OffsetDateTime fechaInicial) {
    this.fechaInicial = fechaInicial;
    return this;
  }

  /**
   * Fecha de inicio de la visita en formato ISO-8601
   * @return fechaInicial
  **/
  @ApiModelProperty(example = "2020-06-12T09:00:00.585Z", required = true, value = "Fecha de inicio de la visita en formato ISO-8601")
  @NotNull

  @Valid

  public OffsetDateTime getFechaInicial() {
    return fechaInicial;
  }

  public void setFechaInicial(OffsetDateTime fechaInicial) {
    this.fechaInicial = fechaInicial;
  }

  public RegistroVisitas fechaFinal(OffsetDateTime fechaFinal) {
    this.fechaFinal = fechaFinal;
    return this;
  }

  /**
   * Fecha de inicio de la visita en formato ISO-8601
   * @return fechaFinal
  **/
  @ApiModelProperty(example = "2020-06-12T09:00:00.585Z", required = true, value = "Fecha de inicio de la visita en formato ISO-8601")
  @NotNull

  @Valid

  public OffsetDateTime getFechaFinal() {
    return fechaFinal;
  }

  public void setFechaFinal(OffsetDateTime fechaFinal) {
    this.fechaFinal = fechaFinal;
  }

  public RegistroVisitas tipoVisita(TipoVisita tipoVisita) {
    this.tipoVisita = tipoVisita;
    return this;
  }

  /**
   * Get tipoVisita
   * @return tipoVisita
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public TipoVisita getTipoVisita() {
    return tipoVisita;
  }

  public void setTipoVisita(TipoVisita tipoVisita) {
    this.tipoVisita = tipoVisita;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistroVisitas registroVisitas = (RegistroVisitas) o;
    return Objects.equals(this.dni, registroVisitas.dni) &&
        Objects.equals(this.nombreCompleto, registroVisitas.nombreCompleto) &&
        Objects.equals(this.empresa, registroVisitas.empresa) &&
        Objects.equals(this.fechaInicial, registroVisitas.fechaInicial) &&
        Objects.equals(this.fechaFinal, registroVisitas.fechaFinal) &&
        Objects.equals(this.tipoVisita, registroVisitas.tipoVisita);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dni, nombreCompleto, empresa, fechaInicial, fechaFinal, tipoVisita);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistroVisitas {\n");
    
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    nombreCompleto: ").append(toIndentedString(nombreCompleto)).append("\n");
    sb.append("    empresa: ").append(toIndentedString(empresa)).append("\n");
    sb.append("    fechaInicial: ").append(toIndentedString(fechaInicial)).append("\n");
    sb.append("    fechaFinal: ").append(toIndentedString(fechaFinal)).append("\n");
    sb.append("    tipoVisita: ").append(toIndentedString(tipoVisita)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

