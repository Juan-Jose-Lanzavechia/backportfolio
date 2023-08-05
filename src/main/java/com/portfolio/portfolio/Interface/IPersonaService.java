package com.portfolio.portfolio.Interface;

import java.util.List;
import com.portfolio.portfolio.Entity.Persona;

public interface IPersonaService {

    //Métod para traer lista de personas
    public List<Persona> getPersona();

    //Método para guardar objeto de tipo Persona
    public void savePersona(Persona persona);

    //Método para eliminar un objeto por id
    public void deletePersona(Long id);

    //Método para buscar una persona por id
    public Persona findPersona(Long id);
    
}
