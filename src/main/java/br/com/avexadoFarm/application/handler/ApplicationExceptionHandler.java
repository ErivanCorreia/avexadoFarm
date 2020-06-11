package br.com.avexadoFarm.application.handler;

import br.com.avexadoFarm.infrastructure.exception.ObjectNotFoundException;
import br.com.avexadoFarm.infrastructure.exception.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException exception, WebRequest request) {
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), request.getDescription(false).substring(4));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
