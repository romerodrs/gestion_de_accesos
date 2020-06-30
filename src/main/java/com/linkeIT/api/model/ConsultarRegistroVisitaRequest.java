package com.linkeIT.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ConsultarRegistroVisitaRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-14T14:21:41.163+02:00")

public class ConsultarRegistroVisitaRequest   {
  @JsonProperty("fechaInicialRango")
  private OffsetDateTime fechaInicialRango = null;

  @JsonProperty("fechaFinalRango")
  private OffsetDateTime fechaFinalRango = null;

  public ConsultarRegistroVisitaRequest fechaInicialRango(OffsetDateTime fechaInicialRango) {
    this.fechaInicialRango = fechaInicialRango;
    return this;
  }

  /**
   * Fecha de inicio de la visita en formato ISO-8601
   * @return fechaInicialRango
  **/
  @ApiModelProperty(example = "2020-06-12T09:00:00.000Z", required = true, value = "Fecha de inicio de la visita en formato ISO-8601")
  @NotNull

  @Valid

  public OffsetDateTime getFechaInicialRango() {
    return fechaInicialRango;
  }

  public void setFechaInicialRango(OffsetDateTime fechaInicialRango) {
    this.fechaInicialRango = fechaInicialRango;
  }

  public ConsultarRegistroVisitaRequest fechaFinalRango(OffsetDateTime fechaFinalRango) {
    this.fechaFinalRango = fechaFinalRango;
    return this;
  }

  /**
   * Fecha de inicio de la visita en formato ISO-8601
   * @return fechaFinalRango
  **/
  @ApiModelProperty(example = "2020-06-12T11:00:00.000Z", required = true, value = "Fecha de inicio de la visita en formato ISO-8601")
  @NotNull

  @Valid

  public OffsetDateTime getFechaFinalRango() {
    return fechaFinalRango;
  }

  public void setFechaFinalRango(OffsetDateTime fechaFinalRango) {
    this.fechaFinalRango = fechaFinalRango;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsultarRegistroVisitaRequest consultarRegistroVisitaRequest = (ConsultarRegistroVisitaRequest) o;
    return Objects.equals(this.fechaInicialRango, consultarRegistroVisitaRequest.fechaInicialRango) &&
        Objects.equals(this.fechaFinalRango, consultarRegistroVisitaRequest.fechaFinalRango);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fechaInicialRango, fechaFinalRango);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsultarRegistroVisitaRequest {\n");
    
    sb.append("    fechaInicialRango: ").append(toIndentedString(fechaInicialRango)).append("\n");
    sb.append("    fechaFinalRango: ").append(toIndentedString(fechaFinalRango)).append("\n");
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

