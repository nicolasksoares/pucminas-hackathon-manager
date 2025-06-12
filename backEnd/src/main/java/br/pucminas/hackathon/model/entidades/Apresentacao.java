package br.pucminas.hackathon.model.entidades;

import br.pucminas.hackathon.model.avaliacao.Avaliavel;
import java.time.LocalDateTime;

public class Apresentacao {

    private Projeto projeto;
    private Avaliavel banca;
    private Sala local;
    private LocalDateTime dataHora;

    public Apresentacao(Projeto projeto, Avaliavel banca, Sala local, LocalDateTime dataHora) {
        if (projeto == null) {
            throw new IllegalArgumentException("A apresentação deve ter um projeto associado.");
        }
        if (banca == null) {
            throw new IllegalArgumentException("A apresentação deve ter uma banca associada.");
        }
        if (local == null) {
            throw new IllegalArgumentException("A apresentação deve ter um local definido.");
        }
        if (dataHora == null) {
            throw new IllegalArgumentException("A apresentação deve ter data e hora definidos.");
        }
        this.projeto = projeto;
        this.banca = banca;
        this.local = local;
        this.dataHora = dataHora;
    }

    public void avaliar() {
        this.banca.calcularNotaFinal();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        if (projeto == null) {
            throw new IllegalArgumentException("O projeto não pode ser nulo.");
        }
        this.projeto = projeto;
    }

    public Avaliavel getBanca() {
        return banca;
    }

    public void setBanca(Avaliavel banca) {
        if (banca == null) {
            throw new IllegalArgumentException("A banca não pode ser nula.");
        }
        this.banca = banca;
    }

    public Sala getLocal() {
        return local;
    }

    public void setLocal(Sala local) {
        if (local == null) {
            throw new IllegalArgumentException("O local não pode ser nulo.");
        }
        this.local = local;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        if (dataHora == null) {
            throw new IllegalArgumentException("A data e hora não podem ser nulas.");
        }
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Apresentação do Projeto '" + projeto.getTitulo() + "' em " + dataHora + " na " + local;
    }
}