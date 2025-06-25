package com.example.ejercicioSpring.service;

import java.util.List;

import com.example.ejercicioSpring.dto.DetallePedidoDTO;
import com.example.ejercicioSpring.dto.PedidoDTO;
import com.example.ejercicioSpring.model.Pedido;

public interface PedidoService {
	
	public Pedido crearPedido(PedidoDTO dto);
    public List<Pedido> pedidosPorCliente(Long id);
    public Pedido buscarPedido(Long id);
	
    
}
