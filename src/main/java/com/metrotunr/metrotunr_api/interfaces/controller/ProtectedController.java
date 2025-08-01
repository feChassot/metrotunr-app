package com.metrotunr.metrotunr_api.interfaces.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Autenticado com sucesso!";
    }
}

