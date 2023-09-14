package com.hptu.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.hptu.login.dto.LdapResponseDto;
import com.hptu.login.dto.RequestLdapDto;

import com.hptu.login.services.LdapService;

@RestController
@RequestMapping("/ldap")
public class LdapController {

    @Autowired
    private LdapService ldapservice;

   // @CrossOrigin(origins="http://helena.hptu.org.co")
    @RequestMapping(value = "/ldapHelena", method = RequestMethod.POST)
    public LdapResponseDto consulta(@RequestBody RequestLdapDto json){


        LdapResponseDto response = ldapservice.buscarUsuario(json.getUsuario(), json.getPassword());
    
        return response;

    }

    
}
