package com.example.ejercicioSpring.service;

import java.util.List;

import com.example.ejercicioSpring.model.Producto;

public interface ProductoService {
	
	public List<Producto>findAll();
	//public Producto save(Producto producto);
	
	public Producto update(Long id, Producto updateProducto);
	public void deleteById(Long id);
	public Producto guardarConValidacion(Producto producto);
	 List<Producto> findByCategoriaId(Long categoriaId);
}
