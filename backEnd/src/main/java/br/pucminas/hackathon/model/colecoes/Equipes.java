package br.pucminas.hackathon.model.colecoes;

import br.pucminas.hackathon.model.entidades.Equipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Equipes {

    private static final Equipes INSTANCE = new Equipes();

    private final List<Equipe> equipes;

    private Equipes() {
        this.equipes = new ArrayList<>();
    }

    public static Equipes getInstance() {
        return INSTANCE;
    }

    public void adicionar(Equipe equipe) {
        if (equipe != null) {
            this.equipes.add(equipe);
        }
    }

    public Equipe buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        return this.equipes.stream()
                .filter(e -> e.getNomeEquipe().equalsIgnoreCase(nome.trim()))
                .findFirst()
                .orElse(null);
    }

    public List<Equipe> getTodasAsEquipes() {
        return Collections.unmodifiableList(this.equipes);
    }
}