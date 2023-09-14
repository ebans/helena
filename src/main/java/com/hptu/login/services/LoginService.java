package com.hptu.login.services;

import com.hptu.login.dto.LoginResponseDto;

public interface LoginService  {

   
    public  LoginResponseDto buscarUsuario(int usuario, String password);



}
