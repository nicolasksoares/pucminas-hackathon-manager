package br.pucminas.hackathon.model.entidades;

public class Jurado extends Profissional {
    public Jurado(String nome, String cpf, String email, Instituicao instituicao, String areaDeAtuacao, String cargo) {
        super(nome, cpf, email, instituicao, areaDeAtuacao, cargo);
    }
}
