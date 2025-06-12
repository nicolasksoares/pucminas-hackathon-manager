package br.pucminas.hackathon.model.entidades;

import br.pucminas.hackathon.model.entidades.Instituicao;

public class Orientador extends Profissional {

    public Orientador(String nome, String cpf, String email, Instituicao instituicao, String areaDeAtuacao, String cargo) {
        super(nome, cpf, email, instituicao, areaDeAtuacao, cargo);
    }
}