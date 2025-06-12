package br.pucminas.hackathon.model.colecoes;

import br.pucminas.hackathon.model.entidades.Apresentacao;
import br.pucminas.hackathon.model.entidades.Projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Apresentacoes {

    private static final Apresentacoes INSTANCE = new Apresentacoes();

    private final List<Apresentacao> apresentacoes;

    private Apresentacoes() {
        this.apresentacoes = new ArrayList<>();
    }

    public static Apresentacoes getInstance() {
        return INSTANCE;
    }

    public void adicionar(Apresentacao apresentacao) {
        if (apresentacao != null) {
            this.apresentacoes.add(apresentacao);
        }
    }

    public Apresentacao buscarPorProjeto(Projeto projeto) {
        if (projeto == null) {
            return null;
        }
        return this.apresentacoes.stream()
                .filter(a -> a.getProjeto().equals(projeto))
                .findFirst()
                .orElse(null);
    }

    public List<Apresentacao> getTodasAsApresentacoes() {
        return Collections.unmodifiableList(this.apresentacoes);
    }
}