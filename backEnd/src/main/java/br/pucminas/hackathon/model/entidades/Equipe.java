package br.pucminas.hackathon.model.entidades;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Equipe {
    private String nomeEquipe;
    private List<Estudante> membros;

    public Equipe(String nomeEquipe) {
        if( nomeEquipe == null || nomeEquipe.trim().isEmpty()){
            throw new IllegalArgumentException("O nome da equipe não pode estar vazio");
        }
        this.nomeEquipe = nomeEquipe.trim();
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Estudante estudante) {
        if (estudante == null) {
            throw new IllegalArgumentException("Não é possível adicionar um membro nulo.");
        }

        if (this.membros.contains(estudante)) {
            System.out.println("O estudante " + estudante.getNome() + " já faz parte da equipe.");
            return;
        }

        if (this.membros.size() < 5) {
            this.membros.add(estudante);
        } else {
            System.out.println("A equipe '" + this.nomeEquipe + "' já está cheia.");
        }
    }

    public String getNomeEquipe(){
        return nomeEquipe;
    }
    public List<Estudante> getMembros() {
        return Collections.unmodifiableList(this.membros);
    }

    public void setNomeEquipe(String nomeEquipe) {
        if(nomeEquipe == null || nomeEquipe.trim().isEmpty()){
            throw new IllegalArgumentException("O nome da equipe não pode estar vazio");
        }
        this.nomeEquipe = nomeEquipe.trim();
    }

    @Override
    public String toString() {
        return "Equipe: " + nomeEquipe + ", Membros: " + membros.size() + "/5";
    }
}