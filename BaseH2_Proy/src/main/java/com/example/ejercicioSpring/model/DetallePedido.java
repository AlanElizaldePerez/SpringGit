package com.example.ejercicioSpring.model;

import jakarta.persistence.*;

@Entity
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@ManyToOne(optional = false)
	@JoinColumn(name = "pedido_id")
	
	
	private Pedido pedido;

	private int cantidad;

	private double subtotal;

	public void calcularSubtotal() {
		if (producto != null && cantidad > 0) {
			this.subtotal = cantidad * producto.getPrecio();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}
