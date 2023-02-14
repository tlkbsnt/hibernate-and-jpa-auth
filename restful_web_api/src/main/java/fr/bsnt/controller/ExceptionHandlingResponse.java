package fr.bsnt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlingResponse extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<ErrorDetails> handlerExceptionAll(Exception ex, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails( LocalDateTime.now(),
                ex.getMessage(),webRequest.getDescription( false ));
            return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR );
    }
    public final ResponseEntity<ErrorDetails> handlerExceptionUserNotFound(Exception ex, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails( LocalDateTime.now(),
                ex.getMessage(),webRequest.getDescription( false ));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND );
    }
}

