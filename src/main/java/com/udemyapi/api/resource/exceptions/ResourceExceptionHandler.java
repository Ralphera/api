package com.udemyapi.api.resource.exceptions;


import com.udemyapi.api.services.exceptions.DataIntegratyViolationException;
import com.udemyapi.api.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

     @ExceptionHandler(ObjectNotFoundException.class) // ExceptionHandler indica a classe a ser manipulada
    public ResponseEntity<StandardError>objectNotFound(ObjectNotFoundException ex, HttpServletRequest request){
            StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegratyViolationException.class) // ExceptionHandler indica a classe a ser manipulada
    public ResponseEntity<StandardError>dataIntegrationViolationException(DataIntegratyViolationException ex, HttpServletRequest request){
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


}
