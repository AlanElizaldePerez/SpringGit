package com.example.ejercicioSpring.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate fecha;

	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<DetallePedido> productos;

	private double total;

	@PrePersist
	public void inicializarFechaYTotal() {
		this.fecha = LocalDate.now();
		calcularTotal();
	}

	@PreUpdate
	public void calcularTotal() {
		this.total = productos != null ? productos.stream().mapToDouble(DetallePedido::getSubtotal).sum() : 0.0;
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetallePedido> getProductos() {
		return productos;
	}

	public void setProductos(List<DetallePedido> productos) {
		this.productos = productos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
