package br.pucminas.hackathon.model.entidades;

import java.util.Objects;

public class Sala {

    private String predio;
    private String identificador;

    public Sala(String predio, String identificador) {
        if (predio == null || predio.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do prédio não pode ser nulo ou vazio.");
        }
        if (identificador == null || identificador.trim().isEmpty()) {
            throw new IllegalArgumentException("O identificador da sala não pode ser nulo ou vazio.");
        }
        this.predio = predio.trim();
        this.identificador = identificador.trim();
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        if (predio == null || predio.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do prédio não pode ser nulo ou vazio.");
        }
        this.predio = predio.trim();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        if (identificador == null || identificador.trim().isEmpty()) {
            throw new IllegalArgumentException("O identificador da sala não pode ser nulo ou vazio.");
        }
        this.identificador = identificador.trim();
    }

    @Override
    public String toString() {
        return "Sala " + identificador + " (" + predio + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return predio.equals(sala.predio) && identificador.equals(sala.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(predio, identificador);
    }
}