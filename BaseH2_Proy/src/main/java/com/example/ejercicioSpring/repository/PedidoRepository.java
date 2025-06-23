package com.example.ejercicioSpring.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ejercicioSpring.model.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido,Long>  {

}
