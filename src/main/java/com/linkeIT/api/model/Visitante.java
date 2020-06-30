package com.linkeIT.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Visitante
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-14T14:21:41.163+02:00")

public class Visitante   {
  @JsonProperty("dni")
  private String dni = null;

  @JsonProperty("nombreCompleto")
  private String nombreCompleto = null;

  @JsonProperty("empresa")
  private String empresa = null;

  public Visitante dni(String dni) {
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

  public Visitante nombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
    return this;
  }

  /**
   * Get nombreCompleto
   * @return nombreCompleto
  **/
  @ApiModelProperty(example = "Daniel Romero Sanchez", value = "")


  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  public Visitante empresa(String empresa) {
    this.empresa = empresa;
    return this;
  }

  /**
   * Get empresa
   * @return empresa
  **/
  @ApiModelProperty(example = "LinkeIT", value = "")


  public String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Visitante visitante = (Visitante) o;
    return Objects.equals(this.dni, visitante.dni) &&
        Objects.equals(this.nombreCompleto, visitante.nombreCompleto) &&
        Objects.equals(this.empresa, visitante.empresa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dni, nombreCompleto, empresa);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Visitante {\n");
    
    sb.append("    dni: ").append(toIndentedString(dni)).append("\n");
    sb.append("    nombreCompleto: ").append(toIndentedString(nombreCompleto)).append("\n");
    sb.append("    empresa: ").append(toIndentedString(empresa)).append("\n");
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

