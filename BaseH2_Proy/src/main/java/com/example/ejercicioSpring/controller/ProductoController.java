package com.example.ejercicioSpring.controller;

import com.example.ejercicioSpring.model.Producto;
import com.example.ejercicioSpring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listar() {
        return service.findAll();
    }
}
