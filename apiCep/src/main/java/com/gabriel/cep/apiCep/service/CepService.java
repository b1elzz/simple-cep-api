package com.gabriel.cep.apiCep.service;

import com.gabriel.cep.apiCep.exception.ParametroInvalidoException;
import com.gabriel.cep.apiCep.model.Cep;
import com.gabriel.cep.apiCep.repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    public void inserirCep(Cep cepDados) throws ParametroInvalidoException {
         cepRepository.save(cepDados);
    }

    public List<Cep> buscarTodosCeps(){
        return cepRepository.findAll();
    }

    public List<Cep> buscarPorCidade(String cidade){
        return cepRepository.findByCidade(cidade);
    }

    public List<Cep> buscarPorUf(String siglaUf){
        return cepRepository.findBySiglaUf(siglaUf);
    }

    public void removerCep(Integer cep){
        cepRepository.deleteById(cep);
    }

    public Cep buscarPorCep(Integer cep){
       return cepRepository.findById(cep).orElseThrow(() -> new IllegalArgumentException("Cep Inexistente!"));
    }


}
