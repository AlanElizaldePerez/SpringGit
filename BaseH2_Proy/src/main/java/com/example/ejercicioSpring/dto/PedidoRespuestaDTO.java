package com.example.ejercicioSpring.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRespuestaDTO {
    private Long id;
    private LocalDate fecha;
    private double total;
    private ClienteResumenDTO cliente;
    private List<DetalleRespuestaDTO> detalles;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ClienteResumenDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteResumenDTO cliente) {
		this.cliente = cliente;
	}
	public List<DetalleRespuestaDTO> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleRespuestaDTO> detalles) {
		this.detalles = detalles;
	}
	
	
}