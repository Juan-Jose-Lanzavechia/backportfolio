package com.portfolio.portfolio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portfolio.Entity.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    
}
