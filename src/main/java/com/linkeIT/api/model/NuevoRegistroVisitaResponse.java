package com.linkeIT.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.linkeIT.api.model.Error;
import com.linkeIT.api.model.Result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * NuevoRegistroVisitaResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-14T14:21:41.163+02:00")

public class NuevoRegistroVisitaResponse   {
  @JsonProperty("result")
  private Result result = null;

  @JsonProperty("idRegistroVisita")
  private String idRegistroVisita = null;

  @JsonProperty("errors")
  @Valid
  private List<Error> errors = null;

  public NuevoRegistroVisitaResponse result(Result result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Result getResult() {
    return result;
  }

  public void setResult(Result result) {
    this.result = result;
  }

  public NuevoRegistroVisitaResponse idRegistroVisita(String idRegistroVisita) {
    this.idRegistroVisita = idRegistroVisita;
    return this;
  }

  /**
   * Get idRegistroVisita
   * @return idRegistroVisita
  **/
  @ApiModelProperty(example = "1", value = "")


  public String getIdRegistroVisita() {
    return idRegistroVisita;
  }

  public void setIdRegistroVisita(String idRegistroVisita) {
    this.idRegistroVisita = idRegistroVisita;
  }

  public NuevoRegistroVisitaResponse errors(List<Error> errors) {
    this.errors = errors;
    return this;
  }

  public NuevoRegistroVisitaResponse addErrorsItem(Error errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Errors list
   * @return errors
  **/
  @ApiModelProperty(value = "Errors list")

  @Valid

  public List<Error> getErrors() {
    return errors;
  }

  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NuevoRegistroVisitaResponse nuevoRegistroVisitaResponse = (NuevoRegistroVisitaResponse) o;
    return Objects.equals(this.result, nuevoRegistroVisitaResponse.result) &&
        Objects.equals(this.idRegistroVisita, nuevoRegistroVisitaResponse.idRegistroVisita) &&
        Objects.equals(this.errors, nuevoRegistroVisitaResponse.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result, idRegistroVisita, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NuevoRegistroVisitaResponse {\n");
    
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    idRegistroVisita: ").append(toIndentedString(idRegistroVisita)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

