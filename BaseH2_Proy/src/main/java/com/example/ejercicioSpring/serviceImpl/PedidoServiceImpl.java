package com.example.ejercicioSpring.serviceImpl;

import com.example.ejercicioSpring.dto.DetallePedidoDTO;
import com.example.ejercicioSpring.dto.PedidoDTO;
import com.example.ejercicioSpring.exception.ReglaNegocioException;
import com.example.ejercicioSpring.exception.RecursoNoEncontradoException;
import com.example.ejercicioSpring.model.*;
import com.example.ejercicioSpring.repository.*;
import com.example.ejercicioSpring.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired private PedidoRepository pedidoRepo;
    @Autowired private ClienteRepository clienteRepo;
    @Autowired private ProductoRepository productoRepo;

    @Override
    public Pedido crearPedido(PedidoDTO dto) {
        // dto.getId() se refiere al clienteId según tu estructura
        Cliente cliente = clienteRepo.findById(dto.getId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con ID: " + dto.getId()));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        List<DetallePedido> detalles = new ArrayList<>();
        double total = 0.0;

        for (DetallePedidoDTO d : dto.getProductos()) {
            // d.getId() es el productoId
            Producto producto = productoRepo.findById(d.getId())
                    .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con ID: " + d.getId()));

            if (d.getCantidad() > 5) {
                throw new ReglaNegocioException("No puedes pedir más de 5 unidades del producto: " + producto.getNombre());
            }

            if (producto.getStock() < d.getCantidad()) {
                throw new ReglaNegocioException("No hay suficiente stock para el producto: " + producto.getNombre());
            }

            // Descontar stock
            producto.setStock(producto.getStock() - d.getCantidad());
            productoRepo.save(producto);

            // Crear detalle
            DetallePedido detalle = new DetallePedido();
            detalle.setProducto(producto);
            detalle.setCantidad(d.getCantidad());
            detalle.calcularSubtotal();
            detalle.setPedido(pedido);

            total += detalle.getSubtotal();
            detalles.add(detalle);
        }

        if (total < 200.0) {
            throw new ReglaNegocioException("El total del pedido debe ser al menos $200.00");
        }

        pedido.setProductos(detalles);
        pedido.setTotal(total);

        return pedidoRepo.save(pedido);
    }

    @Override
    public List<Pedido> pedidosPorCliente(Long Id) {
        Cliente cliente = clienteRepo.findById(Id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con ID: " + Id));
        return cliente.getPedidos();
    }

    @Override
    public Pedido buscarPedido(Long Id) {
        return pedidoRepo.findById(Id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con ID: " + Id));
    }

	
}
