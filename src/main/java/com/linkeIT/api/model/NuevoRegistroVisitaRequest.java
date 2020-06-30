package com.linkeIT.api.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * NuevoRegistroVisitaRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-14T14:21:41.163+02:00")

public class NuevoRegistroVisitaRequest   {
  @JsonProperty("visitante")
  private Visitante visitante = null;

  @JsonProperty("fechaEntrada")
  private OffsetDateTime fechaEntrada = null;

  @JsonProperty("tipoVisita")
  private TipoVisita tipoVisita = null;

  public NuevoRegistroVisitaRequest visitante(Visitante visitante) {
    this.visitante = visitante;
    return this;
  }

  /**
   * Get visitante
   * @return visitante
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Visitante getvisitante() {
    return visitante;
  }

  public void setvisitante(Visitante visitante) {
    this.visitante = visitante;
  }

  public NuevoRegistroVisitaRequest fechaEntrada(OffsetDateTime fechaEntrada) {
    this.fechaEntrada = fechaEntrada;
    return this;
  }

  /**
   * Fecha de inicio de la visita en formato ISO-8601
   * @return fechaEntrada
  **/
  @ApiModelProperty(example = "2020-06-12T09:00:00.000Z", required = true, value = "Fecha de inicio de la visita en formato ISO-8601")
  @NotNull

  @Valid

  public OffsetDateTime getFechaEntrada() {
    return fechaEntrada;
  }

  public void setFechaEntrada(OffsetDateTime fechaEntrada) {
    this.fechaEntrada = fechaEntrada;
  }

  public NuevoRegistroVisitaRequest tipoVisita(TipoVisita tipoVisita) {
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
    NuevoRegistroVisitaRequest nuevoRegistroVisitaRequest = (NuevoRegistroVisitaRequest) o;
    return Objects.equals(this.visitante, nuevoRegistroVisitaRequest.visitante) &&
        Objects.equals(this.fechaEntrada, nuevoRegistroVisitaRequest.fechaEntrada) &&
        Objects.equals(this.tipoVisita, nuevoRegistroVisitaRequest.tipoVisita);
  }

  @Override
  public int hashCode() {
    return Objects.hash(visitante, fechaEntrada, tipoVisita);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NuevoRegistroVisitaRequest {\n");
    
    sb.append("    visitante: ").append(toIndentedString(visitante)).append("\n");
    sb.append("    fechaEntrada: ").append(toIndentedString(fechaEntrada)).append("\n");
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

