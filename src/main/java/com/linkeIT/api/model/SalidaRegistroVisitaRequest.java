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
 * SalidaRegistroVisitaRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-14T14:21:41.163+02:00")

public class SalidaRegistroVisitaRequest   {
  @JsonProperty("dni")
  private String dni = null;

  @JsonProperty("fechaSalida")
  private OffsetDateTime fechaSalida = null;

  public SalidaRegistroVisitaRequest dni(String dni) {
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

  public SalidaRegistroVisitaRequest fechaSalida(OffsetDateTime fechaSalida) {
    this.fechaSalida = fechaSalida;
    return this;
  }

  /**
   * Fecha de inicio de la visita en formato ISO-8601
   * @return fechaSalida
  **/
  @ApiModelProperty(example = "2020-06-12T09:00:00.000Z", value = "Fecha de inicio de la visita en formato ISO-8601")

  @Valid

  public OffsetDateTime getfechaSalida() {
    return fechaSalida;
  }

  public void setfechaSalida(OffsetDateTime fechaSalida) {
    this.fechaSalida = fechaSalida;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SalidaRegistroVisitaRequest salidaRegistroVisitaRequest = (SalidaRegistroVisitaRequest) o;
    return Objects.equals(this.dni, salidaRegistroVisitaRequest.dni) &&
        Objects.equals(this.fechaSalida, salidaRegistroVisitaRequest.fechaSalida);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dni, fechaSalida);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SalidaRegistroVisitaRequest {\n");
    
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    fechaSalida: ").append(toIndentedString(fechaSalida)).append("\n");
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

