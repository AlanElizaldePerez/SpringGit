package com.example.ejercicioSpring.service;

import java.util.List;

import com.example.ejercicioSpring.model.Pedido;

public interface PedidoService {
	
	public List<Pedido>findAll();
	public Pedido update(Long id, Pedido pedidoCliente);
	public void deleteById(Long id);
	public Pedido guardarConValidacion(Pedido pedido);
	 List<Pedido> findByCategoriaId(Long PedidoId);
}
