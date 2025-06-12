package br.pucminas.hackathon.model.avaliacao;

import br.pucminas.hackathon.model.entidades.Jurado;
import br.pucminas.hackathon.model.entidades.Projeto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Banca {

    private static final int MAX_JURADOS = 4;
    private final Projeto projetoAvaliado;
    private final Map<Jurado, Integer> jurados;

    public Banca(Projeto projetoAvaliado) {
        if (projetoAvaliado == null) {
            throw new IllegalArgumentException("A banca precisa estar associada a um projeto.");
        }
        this.projetoAvaliado = projetoAvaliado;
        this.jurados = new HashMap<>();
    }

    public boolean adicionarJurado(Jurado jurado) {
        if (jurado == null || this.jurados.size() >= MAX_JURADOS || this.jurados.containsKey(jurado)) {
            return false;
        }
        this.jurados.put(jurado, null);
        return true;
    }

    public void atribuirNota(Jurado jurado, int nota) {
        if (!this.jurados.containsKey(jurado)) {
            throw new IllegalArgumentException("Este jurado não pertence a esta banca.");
        }
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.jurados.put(jurado, nota);
    }

    public void calcularNotaFinal() {
        if (this.jurados.size() != MAX_JURADOS || this.jurados.containsValue(null)) {
            throw new IllegalStateException("Não é possível calcular a nota final. A banca não está completa ou nem todos os jurados avaliaram.");
        }

        double somaDasNotas = 0;
        for (Integer nota : this.jurados.values()) {
            somaDasNotas += nota;
        }

        double media = somaDasNotas / MAX_JURADOS;
        this.projetoAvaliado.setNotaFinal(media);
    }

    public Projeto getProjetoAvaliado() {
        return projetoAvaliado;
    }

    public Map<Jurado, Integer> getJurados() {
        return Collections.unmodifiableMap(jurados);
    }

    @Override
    public String toString() {
        return "Banca do Projeto: '" + projetoAvaliado.getTitulo() + "' (" + jurados.size() + "/" + MAX_JURADOS + " jurados)";
    }
}