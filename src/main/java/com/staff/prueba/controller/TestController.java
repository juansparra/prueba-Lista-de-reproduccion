package com.staff.prueba.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String test(Authentication authentication){
        return "Bienvenido a la pagina de prueba" + authentication.getName();
    }
}
