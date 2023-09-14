package com.hptu.login.services;

import com.hptu.login.dto.LdapResponseDto;

public interface LdapService {

    public LdapResponseDto buscarUsuario(String usuario, String password);
    
}
