package com.example.ejercicioSpring.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ReglaNegocioException.class)
	public ResponseEntity<String> manejarReglaNegocio(ReglaNegocioException excep) {
        return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<String> manejarRecursoNoEncontrado(RecursoNoEncontradoException excep) {
        return new ResponseEntity<>(excep.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> detalles = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            detalles.put(error.getField(), error.getDefaultMessage())
        );

        return generarError("Error de validación", detalles);
    }

    private ResponseEntity<Map<String, Object>> generarError(String mensaje, Object detalle) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("error", mensaje);
        error.put("detalle", detalle);
        error.put("timestamp", LocalDateTime.now());
        return ResponseEntity.badRequest().body(error);
    }
	

}
