package com.portfolio.portfolio.Dto;

import jakarta.validation.constraints.NotBlank;

public class DtoEducacion {
    @NotBlank //Indica que los campos no pueden estar vacíos
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    //CONSTRUCTORES
    public DtoEducacion() {
    }

    public DtoEducacion(@NotBlank String nombreE, @NotBlank String descripcionE) {
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
