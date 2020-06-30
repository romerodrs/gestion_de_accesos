package com.linkeIT.api.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * El tipo de visita puede ser Comercial, Cliente, Proveedor u Otro
 */
public enum TipoVisita {
  
  COMERCIAL("COMERCIAL"),
  
  CLIENTE("CLIENTE"),
  
  PROVEEDOR("PROVEEDOR"),
  
  OTROS("OTROS");

  private String value;

  TipoVisita(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TipoVisita fromValue(String text) {
    for (TipoVisita b : TipoVisita.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

