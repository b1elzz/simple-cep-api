package com.gabriel.cep.apiCep.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cep")
public class Cep {

    @Id
    @Column(name = "cep")
    private Integer cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "siglaUf")
    private String siglaUf;

    public Cep() {
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cep cep1 = (Cep) o;
        return Objects.equals(cep, cep1.cep) && Objects.equals(cidade, cep1.cidade) && Objects.equals(estado, cep1.estado) && Objects.equals(siglaUf, cep1.siglaUf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, cidade, estado, siglaUf);
    }

    @Override
    public String toString() {
        return "Cep{" +
                "cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", siglaUf='" + siglaUf + '\'' +
                '}';
    }
}
