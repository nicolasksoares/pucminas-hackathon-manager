package br.pucminas.hackathon.model.entidades;

public class Projeto {
    private String titulo;
    private String descricao;
    private Profissional orientador;
    private Equipe equipe;
    private double notaFinal;

    public Projeto(String titulo, String descricao, Equipe equipe, Profissional orientador) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título do projeto não pode ser nulo ou vazio.");
        }
        if (equipe == null) {
            throw new IllegalArgumentException("O projeto deve estar associado a uma equipe.");
        }
        if (orientador == null) {
            throw new IllegalArgumentException("O projeto deve ter um orientador.");
        }

        this.titulo = titulo.trim();
        this.descricao = descricao;
        this.equipe = equipe;
        this.orientador = orientador;
        this.notaFinal = 0.0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Profissional getOrientador() {
        return orientador;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título do projeto não pode ser nulo ou vazio.");
        }
        this.titulo = titulo.trim();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setOrientador(Profissional orientador) {
        if (orientador == null) {
            throw new IllegalArgumentException("O orientador não pode ser nulo.");
        }
        this.orientador = orientador;
    }

    public void setNotaFinal(double notaFinal) {
        if (notaFinal < 0) { // Validação simples
            throw new IllegalArgumentException("A nota final não pode ser negativa.");
        }
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Projeto: '" + titulo + "' | Equipe: " + equipe.getNomeEquipe() + " | Nota Final: " + notaFinal;
    }
}