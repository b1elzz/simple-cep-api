package com.gabriel.cep.apiCep.repository;

import com.gabriel.cep.apiCep.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CepRepository extends JpaRepository<Cep, Integer> {
      List<Cep> findBySiglaUf(String siglaUf);
      List<Cep> findByCidade(String cidade);
      Cep findByCep(Integer cep);
}
