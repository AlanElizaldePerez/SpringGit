package com.example.ejercicioSpring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
	private String nombre;

	@NotBlank(message = "El correo no puede estar vacío")
	@Email(message = "Debe ser un correo válido")
	private String correo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}