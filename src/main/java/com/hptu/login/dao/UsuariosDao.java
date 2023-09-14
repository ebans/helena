package com.hptu.login.dao;

import org.springframework.data.repository.CrudRepository;

import com.hptu.login.model.Usuarios;

public interface UsuariosDao extends CrudRepository<Usuarios, Integer> {
    
}
