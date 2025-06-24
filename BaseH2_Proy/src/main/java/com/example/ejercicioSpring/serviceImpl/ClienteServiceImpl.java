	package com.example.ejercicioSpring.serviceImpl;
	
	import java.util.List;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	
	import com.example.ejercicioSpring.model.Cliente;
	import com.example.ejercicioSpring.repository.ClienteRepository;
	import com.example.ejercicioSpring.service.ClienteService;
	@Service
	public class ClienteServiceImpl implements ClienteService {

	    @Autowired
	    private ClienteRepository clienteRepository;

	    @Override
	    public List<Cliente> findAll() {
	        return clienteRepository.findAll();
	    }

	    @Override
	    public Cliente save(Cliente cliente) {
	        return clienteRepository.save(cliente);
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
