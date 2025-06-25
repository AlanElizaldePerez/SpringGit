package com.example.ejercicioSpring.service;

import java.util.List;

import com.example.ejercicioSpring.model.Cliente;

public interface ClienteService {
	
	public Cliente guardar(Cliente c);
    public List<Cliente> listar();
}
