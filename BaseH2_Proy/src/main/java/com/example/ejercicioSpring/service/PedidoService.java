package com.example.ejercicioSpring.service;

import java.util.List;

import com.example.ejercicioSpring.dto.PedidoDTO;
import com.example.ejercicioSpring.dto.PedidoRespuestaDTO;
import com.example.ejercicioSpring.model.Pedido;

public interface PedidoService {
	
	public PedidoRespuestaDTO crearPedido(PedidoDTO dto);
    public List<PedidoRespuestaDTO> pedidosPorCliente(Long id);
    public PedidoRespuestaDTO buscarPedido(Long id);
	
    
}
