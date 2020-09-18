package br.com.avexadoFarm.application.handler;

import br.com.avexadoFarm.infrastructure.exception.ObjectNotFoundException;
import br.com.avexadoFarm.infrastructure.exception.StandardError;
import br.com.avexadoFarm.infrastructure.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageService messageService;

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Object> ObjectNotFound(ObjectNotFoundException exception, ServletWebRequest request) {
        return handlerExcepion(exception, "erro.recurso-nao-encontrado", HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> userOrPasswordIncorrect(RuntimeException exception, ServletWebRequest request) {
        return handlerExcepion(exception, "security.usuario-senha-incorreto", HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> genericException(RuntimeException exception, ServletWebRequest request) {
        return handlerExcepion(exception, "erro.operacao-invalida", HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> genericException(AccessDeniedException exception, ServletWebRequest request) {
        return handlerExcepion(exception, "security.acesso-negado", HttpStatus.FORBIDDEN, request);
    }

    public ResponseEntity<Object> handlerExcepion(Exception exception, String message, HttpStatus status, ServletWebRequest request) {
        StandardError error = new StandardError(status.value(),
                messageService.getMessage(message),request.getRequest().getRequestURI());

        return handleExceptionInternal(exception, error, new HttpHeaders(), status, request);
    }
}
