package com.hptu.login.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.hptu.login.model.Usuarios;

public class LoginResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String description;
    private Optional<Usuarios> data;

    

    

   

    public Optional<Usuarios> getData() {
        return data;
    }

    public void setData(Optional<Usuarios> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
