	package com.example.ejercicioSpring.serviceImpl;
	
	import java.util.List;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	
	import com.example.ejercicioSpring.model.Cliente;
import com.example.ejercicioSpring.model.DetallePedido;
import com.example.ejercicioSpring.repository.ClienteRepository;
import com.example.ejercicioSpring.repository.DetallePedidoRepository;
import com.example.ejercicioSpring.service.DetallePedidoService;
	@Service
	public class DetallePedidoServiceImpl implements DetallePedidoService {

	    @Autowired
	    private DetallePedidoRepository detallePedidoRepository;
 
	    @Override
	    public List<DetallePedido> findAll() {
	        return detallePedidoRepository.findAll();
	    }

	    @Override
	    public DetallePedido save (DetallePedido detallePedido) {
	        return detallePedidoRepository.save(detallePedido);
	    }

	    @Override
	    public Cliente update(Long id, Cliente clienteActualizado) {
	        Cliente cliente = clienteRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
	        cliente.setNombre(clienteActualizado.getNombre());
	        return clienteRepository.save(cliente);
	    }

	    @Override
	    public void deleteById(Long id) {
	        if (!clienteRepository.existsById(id)) {
	            throw new RuntimeException("Cliente no encontrado para eliminar");
	        }
	        clienteRepository.deleteById(id);
	    }

		@Override
		public Cliente updatesave(Long id, Cliente updateCliente) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Cliente guardarConValidacion(Cliente Cliente) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Cliente> findByCategoriaId(Long ClienteId) {
			// TODO Auto-generated method stub
			return null;
		}


	}
