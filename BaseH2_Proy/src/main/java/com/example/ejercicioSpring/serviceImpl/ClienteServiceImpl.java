	package com.example.ejercicioSpring.serviceImpl;
	
	import java.util.List;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.example.ejercicioSpring.exception.ReglaNegocioException;
import com.example.ejercicioSpring.model.Cliente;
	import com.example.ejercicioSpring.repository.ClienteRepository;
	import com.example.ejercicioSpring.service.ClienteService;
	@Service
	public class ClienteServiceImpl implements ClienteService {

		@Autowired
	    private ClienteRepository repo;
		
		@Override
		public Cliente guardar(Cliente c) {
			if (c.getCorreo() == null || c.getCorreo().trim().isEmpty()) {
	            throw new ReglaNegocioException("El correo no puede estar vacío.");
	        }
			 return repo.save(c);
		}

		@Override
		public List<Cliente> listar() {
			return repo.findAll();
		}



	}
