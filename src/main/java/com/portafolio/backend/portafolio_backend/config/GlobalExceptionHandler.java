package com.portafolio.backend.portafolio_backend.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        // Aquí puedes realizar cualquier lógica adicional antes de redirigir al índice.
        return "redirect:/"; // Redirige al índice de la aplicación.
    }
    
}
