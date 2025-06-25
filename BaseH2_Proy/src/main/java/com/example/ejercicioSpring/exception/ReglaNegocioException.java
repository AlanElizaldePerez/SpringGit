package com.example.ejercicioSpring.exception;

public class ReglaNegocioException extends RuntimeException {

	public ReglaNegocioException(String mensaje) {
        super(mensaje);
    }
}
