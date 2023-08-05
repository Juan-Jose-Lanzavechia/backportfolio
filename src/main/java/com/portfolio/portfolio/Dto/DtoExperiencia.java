package com.portfolio.portfolio.Dto;

import jakarta.validation.constraints.NotBlank;

//Aquí vamos a replicar  los campos que tenemos en el Entity. Como diferencia, no ponndremos el id.
public class DtoExperiencia {
 @NotBlank //Anotación que significa que los campos no pueden estar en blanco o vacíos.
 private String nombreE;
 @NotBlank
 private String descripcionE;

//CONSTRUCTORES
 public DtoExperiencia() {
}

public DtoExperiencia(@NotBlank String nombreE, @NotBlank String descripcionE) {
    this.nombreE = nombreE;
    this.descripcionE = descripcionE;
}

//GETTER AND SETTER
public String getNombreE() {
    return nombreE;
}

public void setNombreE(String nombreE) {
    this.nombreE = nombreE;
}

public String getDescripcionE() {
    return descripcionE;
}

public void setDescripcionE(String descripcionE) {
    this.descripcionE = descripcionE;
}
 

 


}
