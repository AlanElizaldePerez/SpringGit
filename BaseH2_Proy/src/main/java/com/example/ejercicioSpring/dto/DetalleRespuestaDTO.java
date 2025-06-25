package com.example.ejercicioSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleRespuestaDTO {
    private String producto;
    private int cantidad;
    private double subtotal;
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
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