package com.example.ejercicioSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ReglaNegocioException.class)
	public ResponseEntity<String> manejarReglaNegocio(ReglaNegocioException excep) {
        return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<String> manejarRecursoNoEncontrado(RecursoNoEncontradoException excep) {
        return new ResponseEntity<>(excep.getMessage(), HttpStatus.NOT_FOUND);
    }
	

}
