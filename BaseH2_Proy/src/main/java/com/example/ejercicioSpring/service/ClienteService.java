package com.example.ejercicioSpring.service;

import java.util.List;

import com.example.ejercicioSpring.model.Cliente;

public interface ClienteService {
	
	public List<Cliente>findAll();
	public Cliente updatesave(Long id, Cliente updateCliente);
	public void deleteById(Long id);
	public Cliente guardarConValidacion(Cliente Cliente);
	 List<Cliente> findByCategoriaId(Long ClienteId);
	public Cliente save(Cliente cliente);
	public Cliente update(Long id, Cliente clienteActualizado);
}
