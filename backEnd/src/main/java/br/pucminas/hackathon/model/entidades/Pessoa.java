package br.pucminas.hackathon.model.entidades;

import java.util.regex.Pattern;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String email;
    protected Instituicao instituicao;

    public Pessoa(String nome, String cpf, String email, Instituicao instituicao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
        this.nome = nome.trim();

        if (cpf == null || cpf.trim().isEmpty() || cpf.trim().replaceAll("[^0-9]", "").length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve ser não nulo, não vazio e conter 11 dígitos numéricos.");
        }
        this.cpf = cpf.trim();

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O email não pode estar vazio.");
        }
        this.email = email.trim();

        if (instituicao == null) {
            throw new IllegalArgumentException("A instituição associada à pessoa não pode ser nula.");
        }
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode estar vazio.");
        }
        this.nome = nome.trim();
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O email não pode estar vazio.");
        }
        this.email = email.trim();
    }

    public void setInstituicao(Instituicao instituicao) {
        if (instituicao == null) {
            throw new IllegalArgumentException("A instituição associada à pessoa não pode ser nula.");
        }
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return "Pessoa [Nome: " + nome + ", CPF: " + cpf + ", Email: " + email + ", Instituição: " + (instituicao != null ? instituicao.getNome() : "Nenhuma") + "]";
    }
}