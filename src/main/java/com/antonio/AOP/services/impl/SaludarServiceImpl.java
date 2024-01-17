package com.antonio.AOP.services.impl;

import com.antonio.AOP.services.ISaludarService;
import org.springframework.stereotype.Service;

@Service
public class SaludarServiceImpl implements ISaludarService {
    @Override
    public String saludar(String nombre, String frase) {
        System.out.println("aca saludo primero");
        return nombre.concat(frase);
    }

    @Override
    public String saludarB(String nombre, String frase) {
       // return nombre.concat(frase);
        throw new RuntimeException("algun error pal ejemplo");
    }
}
