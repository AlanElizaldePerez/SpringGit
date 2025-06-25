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
	    private ClienteRepository repo;
		
		@Override
		public Cliente guardar(Cliente c) {
			 return repo.save(c);
		}

		@Override
		public List<Cliente> listar() {
			return repo.findAll();
		}



	}
