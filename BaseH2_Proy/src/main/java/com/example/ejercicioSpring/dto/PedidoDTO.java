package com.example.ejercicioSpring.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoDTO {

	@NotNull(message = "El ID del cliente es obligatorio")
	private Long Id;

	@NotEmpty(message = "Debe haber al menos un producto en el pedido")
	private List<DetallePedidoDTO> productos;

	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public List<DetallePedidoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<DetallePedidoDTO> productos) {
		this.productos = productos;
	}
}