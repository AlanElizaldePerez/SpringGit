package com.example.ejercicioSpring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePedidoDTO {

	@NotNull(message = "El ID del producto es obligatorio")
	private Long Id;

	@Min(value = 1, message = "La cantidad debe ser al menos 1")
	private int cantidad;

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) { 
		this.cantidad = cantidad;
		}
}