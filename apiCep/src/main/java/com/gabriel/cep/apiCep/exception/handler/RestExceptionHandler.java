package com.gabriel.cep.apiCep.exception.handler;

import com.gabriel.cep.apiCep.exception.CepNaoEncontradoException;
import com.gabriel.cep.apiCep.exception.ParametroInvalidoException;
import com.gabriel.cep.apiCep.exception.UfNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErroResponse> trataRegistroNaoEcontradoException(UfNaoEncontradoException ex) {
        ErroResponse errorResponse = new ErroResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<ErroResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErroResponse> trataParametroInvalidoException(ParametroInvalidoException ex) {
        ErroResponse errorResponse = new ErroResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<ErroResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
