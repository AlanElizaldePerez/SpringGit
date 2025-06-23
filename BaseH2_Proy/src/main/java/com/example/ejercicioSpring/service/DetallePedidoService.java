package com.example.ejercicioSpring.service;

import java.util.List;

import com.example.ejercicioSpring.model.DetallePedido;

public interface DetallePedidoService {
	
	public List<DetallePedido>findAll();
	//public DetallePedido save(DetallePedido detallePedido);
	
	public DetallePedido update(Long id, DetallePedido updateDetallePedido);
	public void deleteById(Long id);
	public DetallePedido guardarConValidacion(DetallePedido detallePedido);
	 List<DetallePedido> findByCategoriaId(Long DetallePedidoId);
}
