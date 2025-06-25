package com.example.ejercicioSpring.service;

import java.util.List;

import com.example.ejercicioSpring.dto.PedidoDTO;
import com.example.ejercicioSpring.dto.PedidoRespuestaDTO;
import com.example.ejercicioSpring.model.Pedido;

public interface PedidoService {
	
	public PedidoRespuestaDTO crearPedido(PedidoDTO dto);
    public List<Pedido> pedidosPorCliente(Long id);
    public Pedido buscarPedido(Long id);
	
    
}
