package com.example.ejercicioSpring.controller;

import com.example.ejercicioSpring.dto.PedidoDTO;
import com.example.ejercicioSpring.dto.PedidoRespuestaDTO;
import com.example.ejercicioSpring.model.Pedido;
import com.example.ejercicioSpring.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<?> crearPedido(@Valid @RequestBody PedidoDTO dto) {
        PedidoRespuestaDTO respuesta = service.crearPedido(dto);
        return ResponseEntity.ok()
                .header("X-Pedido-Creado", "true")
                .header("X-Fecha-Registro", LocalDate.now().toString())
                .body(respuesta);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PedidoRespuestaDTO>> pedidosPorCliente(@PathVariable Long id) {
        List<PedidoRespuestaDTO> pedidos = service.pedidosPorCliente(id);
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoRespuestaDTO> buscarPedido(@PathVariable Long id) {
        PedidoRespuestaDTO pedido = service.buscarPedido(id);
        return ResponseEntity.ok(pedido);
    }
}

