package com.hptu.login.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hptu.login.dao.UsuariosDao;
import com.hptu.login.dto.LoginDto;
import com.hptu.login.dto.LoginResponseDto;
import com.hptu.login.model.Usuarios;
import com.hptu.login.services.LoginService;

@Service
public class LoginImpl implements LoginService {

    @Autowired
    private UsuariosDao usuarios;

    @Override
    @Transactional
    public LoginResponseDto buscarUsuario(int usuario, String password) {
        System.out.println("inicio la transaccion");

        LoginResponseDto response = new LoginResponseDto();

        try {
            
            Optional<Usuarios> usuariosDto =  usuarios.findById(usuario);


            if(usuariosDto!= null ){
                response.setCode("200");
                response.setDescription("Exitoso");
                response.setData(usuariosDto);
            }else{

                response.setCode("400");
                response.setDescription("Error en la conculta");
               
            }

        




        } catch (Exception e) {
           e.printStackTrace();
           response.setCode("500");
           response.setDescription("No encuentra informacion "+e.toString());




        }
        return response;

      
    }

}
