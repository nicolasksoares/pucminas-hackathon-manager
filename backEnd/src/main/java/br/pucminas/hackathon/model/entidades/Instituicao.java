package br.pucminas.hackathon.model.entidades;

public abstract class Instituicao {
    private String nome;
    private String cnpj;
    private String endereco;


    public Instituicao(String nome, String cnpj, String endereco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da instituição não pode estar vazio.");
        }
        this.nome = nome.trim();

        if (cnpj == null || cnpj.trim().isEmpty() || cnpj.trim().replaceAll("[^0-9]", "").length() != 14) {
            throw new IllegalArgumentException("CNPJ inválido. Verifique se não está vazio e possui 14 dígitos.");
        }
        this.cnpj = cnpj.trim();

        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O endereco da instituição não pode estar vazio.");
        }
        this.endereco = endereco.trim();
    }

    public String getNome() {
        return nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da instituição não pode estar vazio.");
        }
        this.nome = nome.trim();
    }
    protected void setCnpj(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty()|| cnpj.trim().replaceAll("[^0-9]", "").length() != 14) {
            throw new IllegalArgumentException("CNPJ inválido. Verifique se não está vazio e possui 14 dígitos.");
        }
        this.cnpj = cnpj.trim();
    }
    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O endereco da instituição não pode estar vazio.");
        }
        this.endereco = endereco.trim();
    }

    @Override
    public String toString() {
        return "Instituicao [Nome: " + getNome() + ", CNPJ: " + getCnpj() + ", Endereco: " + getEndereco() + "]";
    }
}