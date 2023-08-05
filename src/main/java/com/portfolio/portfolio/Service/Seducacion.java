package com.portfolio.portfolio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portfolio.Entity.Educacion;
import com.portfolio.portfolio.Repository.REducacion;


@Service
@Transactional
public class Seducacion {
    @Autowired
    REducacion rEducacion;

    //Desarrollamos los métodos
    //1
    public List<Educacion> list() {
        return rEducacion.findAll();
    }
   //2
    public Optional<Educacion> getOne(int id){
        return rEducacion.findById(id);
    }
    //3
    public Optional<Educacion> getByNombreE (String nombreE){
        return rEducacion.findByNombreE(nombreE);
    }
    //4 Para guardar el objeto educacion
    public void save(Educacion educacion){
        rEducacion.save(educacion); 
    }

    //5 Para que busque el id y borre el mismo
    public void delete(int id){
        rEducacion.deleteById(id);
    }
    //6
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    //7
    public boolean existsByNombreE(String nombreE){
        return rEducacion.existsByNombreE(nombreE);
    }
}
