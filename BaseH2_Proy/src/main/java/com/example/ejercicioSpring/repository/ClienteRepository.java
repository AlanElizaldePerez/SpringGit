package com.example.ejercicioSpring.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicioSpring.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Long>  {

}
