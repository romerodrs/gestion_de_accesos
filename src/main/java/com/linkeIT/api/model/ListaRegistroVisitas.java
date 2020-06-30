package com.linkeIT.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.linkeIT.api.model.RegistroVisitas;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ListaRegistroVisitas
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-14T14:21:41.163+02:00")

public class ListaRegistroVisitas   {
	  @JsonProperty("listaRegistroVisitas")
	  @Valid
	  private List<RegistroVisitas> listaRegistroVisitas = null;

	  public ListaRegistroVisitas listaRegistroVisitas(List<RegistroVisitas> listaRegistroVisitas) {
	    this.listaRegistroVisitas = listaRegistroVisitas;
	    return this;
	  }

	  public ListaRegistroVisitas addListaRegistroVisitasItem(RegistroVisitas listaRegistroVisitasItem) {
	    if (this.listaRegistroVisitas == null) {
	      this.listaRegistroVisitas = new ArrayList<>();
	    }
	    this.listaRegistroVisitas.add(listaRegistroVisitasItem);
	    return this;
	  }

	  /**
	   * lista de registro de visitas
	   * @return listaRegistroVisitas
	  **/
	  @ApiModelProperty(value = "lista de registro de visitas")

	  @Valid

	  public List<RegistroVisitas> getListaRegistroVisitas() {
	    return listaRegistroVisitas;
	  }

	  public void setListaRegistroVisitas(List<RegistroVisitas> listaRegistroVisitas) {
	    this.listaRegistroVisitas = listaRegistroVisitas;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    ListaRegistroVisitas listaRegistroVisitas = (ListaRegistroVisitas) o;
	    return Objects.equals(this.listaRegistroVisitas, listaRegistroVisitas.listaRegistroVisitas);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(listaRegistroVisitas);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ListaRegistroVisitas {\n");
	    
	    sb.append("    listaRegistroVisitas: ").append(toIndentedString(listaRegistroVisitas)).append("\n");
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

