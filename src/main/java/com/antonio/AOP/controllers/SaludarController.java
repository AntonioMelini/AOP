package com.antonio.AOP.controllers;

import com.antonio.AOP.services.ISaludarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api")
public class SaludarController {
    @Autowired
    private ISaludarService saludarService;
    @GetMapping("/a")
    public ResponseEntity<?> saludarControler(){
        return ResponseEntity.ok(Collections.singletonMap("saludo",saludarService.saludar("juan ","hola gordo fofo")));
    }
    @GetMapping("/b")
    public ResponseEntity<?> saludarControlerB(){
        return ResponseEntity.ok(Collections.singletonMap("saludoB",saludarService.saludarB("antonio ","hola gordo toni")));
    }
}
