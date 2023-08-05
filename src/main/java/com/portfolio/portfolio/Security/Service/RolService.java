package com.portfolio.portfolio.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portfolio.Security.Entity.Rol;
import com.portfolio.portfolio.Security.Repository.iRolRepository;
import com.portfolio.portfolio.Security.enums.RolNombre;

import jakarta.transaction.Transactional;

@Service
@Transactional 
public class RolService {
    @Autowired
    iRolRepository iRolRepository;   

    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}
