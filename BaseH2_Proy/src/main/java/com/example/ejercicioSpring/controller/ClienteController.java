package com.example.ejercicioSpring.controller;

import com.example.ejercicioSpring.dto.ClienteDTO;
import com.example.ejercicioSpring.model.Cliente;
import com.example.ejercicioSpring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente registrar(@Valid @RequestBody ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        return service.guardar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }
}
