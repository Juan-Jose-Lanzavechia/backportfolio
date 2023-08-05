package com.portfolio.portfolio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.Entity.Experiencia;
import com.portfolio.portfolio.Repository.RExperiencia;

import jakarta.transaction.Transactional;

@Service //Indica que se trata de un service
@Transactional //Mantiene la persistencia. Lo que tengamos acá también lo va a tener en la base de datos.
public class SExperiencia {
   @Autowired //Inyecta el repositorio. En este caso, el repositorio RExperiencia.java 
   RExperiencia rExperiencia;

   //A continuación estamos hacienndo mención al Entity Experiencia.java
   public List<Experiencia> list(){
    return rExperiencia.findAll(); //Lo que hace es arar una lista con todas las experiencias que encuentre 
   }

   public Optional<Experiencia> getOne(int id){

    return rExperiencia.findById(id);//Para que busque uno en particular por id
   }

   public Optional<Experiencia> getByNombreE(String nombreE){  //Para que busque por el nombre. Aqí el Optional puede o no estar.
    return rExperiencia.findByNombreE(nombreE);
    }

    public void save(Experiencia expe){  //Para guardar una nueva experiencia
        rExperiencia.save(expe);

    }

    public void delete(int id){
        rExperiencia.deleteById(id);
    }

    //Creamos 2 métodos más para saber si existen el objeto o experiencia que estamos buscando, tanto por id como por nombre
    public boolean existsById(int id){
        return rExperiencia.existsById(id);

    }
    public boolean existsByNombreE(String nombreE){
        return rExperiencia.existsByNombreE(nombreE);

    }
}
