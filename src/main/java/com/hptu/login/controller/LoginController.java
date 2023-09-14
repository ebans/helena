package com.hptu.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hptu.login.dto.LoginResponseDto;
import com.hptu.login.dto.RequestLoginDto;
import com.hptu.login.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

     @Autowired
     private LoginService loginService;

   //  @CrossOrigin(origins="http://helena.hptu.org.co")
     @RequestMapping(value = "/loginHelena", method = RequestMethod.POST)
     public LoginResponseDto consultar(@RequestBody RequestLoginDto json){


        LoginResponseDto response = loginService.buscarUsuario(json.getUsuario(),json.getPassword());


        return response	;
     }
    
}
