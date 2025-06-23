package com.example.ejercicioSpring.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicioSpring.model.Producto;

public interface ProductoRepository extends JpaRepository <Producto,Long>  {

}
