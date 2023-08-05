package com.portfolio.portfolio.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portfolio.Security.Entity.Rol;
import com.portfolio.portfolio.Security.enums.RolNombre;

@Repository 
public interface iRolRepository extends JpaRepository <Rol, Integer> {
    Optional<Rol> findByRolNombre (RolNombre rolNombre); 

}