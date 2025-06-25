package com.example.ejercicioSpring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.ejercicioSpring.model.Producto;
import com.example.ejercicioSpring.repository.ProductoRepository;
import com.example.ejercicioSpring.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	@Autowired
    private ProductoRepository productoRepo;

    @Override
    public List<Producto> findAll() {
        return productoRepo.findAll();
    }
}
