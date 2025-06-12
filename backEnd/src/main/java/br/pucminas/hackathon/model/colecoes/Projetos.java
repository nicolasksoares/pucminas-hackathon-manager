package br.pucminas.hackathon.model.colecoes;

import br.pucminas.hackathon.model.entidades.Projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Projetos {

    private static final Projetos INSTANCE = new Projetos();

    private final List<Projeto> projetos;

    private Projetos() {
        this.projetos = new ArrayList<>();
    }

    public static Projetos getInstance() {
        return INSTANCE;
    }

    public void adicionar(Projeto projeto) {
        if (projeto != null) {
            this.projetos.add(projeto);
        }
    }

    public Projeto buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return null;
        }
        return this.projetos.stream()
                .filter(p -> p.getTitulo().equalsIgnoreCase(titulo.trim()))
                .findFirst()
                .orElse(null);
    }

    public List<Projeto> getTodosOsProjetos() {
        return Collections.unmodifiableList(this.projetos);
    }
}