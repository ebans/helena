package com.hptu.login.dto;

import java.io.Serializable;

public class RequestLoginDto implements Serializable {

    private static final long serialVersionUID = 1L;


    private int usuario;
    private String password;


    
    public int getUsuario() {
        return usuario;
    }
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    
    
}
