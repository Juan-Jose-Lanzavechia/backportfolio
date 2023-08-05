package com.portfolio.portfolio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.portfolio.Entity.Educacion;

@Repository
public interface REducacion extends JpaRepository <Educacion,Integer> {
   //Como hicimos en experiencia laboral, vamos a hacer 2 métodos: un optional que busque por nombre
   // y un booleano para saber si existe ese nombre
   public Optional <Educacion> findByNombreE(String nombreE);//Va a buscar por el nombre
   public boolean existsByNombreE(String nombreE);//Va a devolver un verdadero o falso si existe o no existe

}
