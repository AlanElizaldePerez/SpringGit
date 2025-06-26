package com.example.ejercicioSpring.serviceImpl;

import com.example.ejercicioSpring.dto.ClienteResumenDTO;
import com.example.ejercicioSpring.dto.DetallePedidoDTO;
import com.example.ejercicioSpring.dto.DetalleRespuestaDTO;
import com.example.ejercicioSpring.dto.PedidoDTO;
import com.example.ejercicioSpring.dto.PedidoRespuestaDTO;
import com.example.ejercicioSpring.exception.ReglaNegocioException;
import com.example.ejercicioSpring.model.Cliente;
import com.example.ejercicioSpring.model.DetallePedido;
import com.example.ejercicioSpring.model.Pedido;
import com.example.ejercicioSpring.model.Producto;
import com.example.ejercicioSpring.repository.ClienteRepository;
import com.example.ejercicioSpring.repository.PedidoRepository;
import com.example.ejercicioSpring.repository.ProductoRepository;
import com.example.ejercicioSpring.exception.RecursoNoEncontradoException;

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
    public PedidoRespuestaDTO crearPedido(PedidoDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getId())
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con ID: " + dto.getId()));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        List<DetallePedido> detalles = new ArrayList<>();
        double total = 0.0;

        for (DetallePedidoDTO d : dto.getProductos()) {
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

        pedido.setProductos(detalles);
        pedido.setTotal(total);
        
        if (pedido.getTotal() < 200.00) {
            throw new ReglaNegocioException("El total del pedido debe ser al menos $200.00");
        }

        Pedido guardado = pedidoRepo.save(pedido);

        // Mapeo personalizado
        PedidoRespuestaDTO respuesta = new PedidoRespuestaDTO();
        respuesta.setId(guardado.getId());
        respuesta.setFecha(guardado.getFecha());
        respuesta.setTotal(guardado.getTotal());

        ClienteResumenDTO clienteDTO = new ClienteResumenDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setCorreo(cliente.getCorreo());
        respuesta.setCliente(clienteDTO);

        List<DetalleRespuestaDTO> detalles1 = guardado.getProductos().stream().map(det -> {
            DetalleRespuestaDTO d = new DetalleRespuestaDTO();
            d.setProducto(det.getProducto().getNombre());
            d.setCantidad(det.getCantidad());
            d.setSubtotal(det.getSubtotal());
            return d;
        }).toList();

        respuesta.setDetalles(detalles1);

        return respuesta;

    }

    @Override
    public List<PedidoRespuestaDTO> pedidosPorCliente(Long Id) {
        Cliente cliente = clienteRepo.findById(Id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cliente no encontrado con ID: " + Id));
        return cliente.getPedidos().stream()
                .map(this::convertirAPedidoDTO)
                .toList();
    }

    @Override
    public PedidoRespuestaDTO buscarPedido(Long Id) {
    	Pedido pedido = pedidoRepo.findById(Id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con ID: " + Id));

        return convertirAPedidoDTO(pedido);
    }
    
    private PedidoRespuestaDTO convertirAPedidoDTO(Pedido pedido) {
	    PedidoRespuestaDTO respuesta = new PedidoRespuestaDTO();
	    respuesta.setId(pedido.getId());
	    respuesta.setFecha(pedido.getFecha());
	    respuesta.setTotal(pedido.getTotal());

	    ClienteResumenDTO clienteDTO = new ClienteResumenDTO();
	    clienteDTO.setId(pedido.getCliente().getId());
	    clienteDTO.setNombre(pedido.getCliente().getNombre());
	    clienteDTO.setCorreo(pedido.getCliente().getCorreo());
	    respuesta.setCliente(clienteDTO);

	    List<DetalleRespuestaDTO> detalles = pedido.getProductos().stream().map(det -> {
	        DetalleRespuestaDTO d = new DetalleRespuestaDTO();
	        d.setProducto(det.getProducto().getNombre());
	        d.setCantidad(det.getCantidad());
	        d.setSubtotal(det.getSubtotal());
	        return d;
	    }).toList();

	    respuesta.setDetalles(detalles);

	    return respuesta;
	}
    

	
}
