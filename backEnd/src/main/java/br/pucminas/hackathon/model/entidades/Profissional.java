package br.pucminas.hackathon.model.entidades;

import br.pucminas.hackathon.model.entidades.Instituicao;
import br.pucminas.hackathon.model.entidades.Pessoa;

public abstract class Profissional extends Pessoa {
    private String areaDeAtuacao;
    private String cargo;

    public Profissional(String nome, String cpf, String email, Instituicao instituicao, String areaDeAtuacao, String cargo) {
        super(nome, cpf, email, instituicao);

        if (areaDeAtuacao == null || areaDeAtuacao.trim().isEmpty()) {
            throw new IllegalArgumentException("A sua área de atuação não pode estar vazia!");
        }
        this.areaDeAtuacao = areaDeAtuacao.trim();

        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("O cargo não pode estar vazio!");
        }
        this.cargo = cargo.trim();
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        if (areaDeAtuacao == null || areaDeAtuacao.trim().isEmpty()) {
            throw new IllegalArgumentException("A sua área de atuação não pode estar vazia!");
        }
        this.areaDeAtuacao = areaDeAtuacao.trim();
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("O cargo não pode estar vazio!");
        }
        this.cargo = cargo.trim();
    }

    @Override
    public String toString() {
        return "Profissional [" + super.toString() + ", Cargo: " + cargo + ", Área: " + areaDeAtuacao + "]";
    }
}