package com.gabriel.cep.apiCep.controller;

import com.gabriel.cep.apiCep.exception.ParametroInvalidoException;
import com.gabriel.cep.apiCep.exception.UfNaoEncontradoException;
import com.gabriel.cep.apiCep.model.Cep;
import com.gabriel.cep.apiCep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "ceps")
public class CepController {
    @Autowired
    private CepService cepService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Cep>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(cepService.buscarTodosCeps());
    }

    @GetMapping(value = { "{uf}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Cep>> getUf(@PathVariable(name = "uf") String siglaUf) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cepService.buscarPorUf(siglaUf));
    }

    @GetMapping(value = { "{cidade}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Cep>> getCidade(@PathVariable(name = "cidade") String cidade) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cepService.buscarPorCidade(cidade));
    }

    @GetMapping(value = { "{cep}" }, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Cep> buscarPorCep(@PathVariable(name = "cep") Integer cep) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cepService.buscarPorCep(cep));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cep> adicionar(@RequestBody Cep cep) throws ParametroInvalidoException {
        if(cep.getCep() == null || cep.getCidade().isBlank() || cep.getCidade() == null
        || cep.getSiglaUf().isBlank() || cep.getSiglaUf() == null
                || cep.getEstado().isBlank() || cep.getEstado() == null
        ){
            throw new ParametroInvalidoException("Não podem ser nulo ou vazio!");
        }
        cepService.inserirCep(cep);
        return ResponseEntity.status(HttpStatus.CREATED).body(cep);
    }



}
