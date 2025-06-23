package com.example.ejercicioSpring.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {

	@NotBlank(message = "El nombre no puede ser vacío")
	@Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caractéres")
	@Pattern(regexp = "^(?!.\\bgratis\\b).$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "El nombre no puede contener la palabra 'gratis'")
	private String nombre;

	@DecimalMin(value = "1.00", inclusive = true, message = "El precio mínimo es 1.00")
	@Digits(integer = 10, fraction = 2, message = "El precio debe tener máximo dos decimales")
	private double precio;

	@NotNull(message = "El stock no puede ser nulo")
	@Min(value = 0, message = "El stock no puede ser negativo")
	private Integer stock;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}