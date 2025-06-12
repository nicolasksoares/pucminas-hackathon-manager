package br.pucminas.hackathon.model.entidades;

import br.pucminas.hackathon.model.entidades.Instituicao;

public class Empresa extends Instituicao {
    private String tipoEmpresa;
    private String areaAtuacao;
    public Empresa(String tipoEmpresa, String areaAtuacao, String nome, String cnpj, String endereco) {
        super(nome, cnpj, endereco);
        if (tipoEmpresa == null || tipoEmpresa.trim().length() == 0){
            throw new IllegalArgumentException("O tipo da empresa não pode estar vazio.");
        }
        this.tipoEmpresa = tipoEmpresa.trim();

        if(areaAtuacao == null || areaAtuacao.trim().length() == 0){
            throw new IllegalArgumentException("A área de atuação não deve estar vazia.");
        }
        this.areaAtuacao = areaAtuacao.trim();
    }

    public String getTipoEmpresa (){
        return tipoEmpresa;
    }
    public String getAreaAtuacao(){
        return areaAtuacao;
    }


    public void setTipoEmpresa(String tipoEmpresa) {
        if (tipoEmpresa == null || tipoEmpresa.trim().length() == 0){
            throw new IllegalArgumentException("O tipo da empresa não pode estar vazio.");
        }
        this.tipoEmpresa = tipoEmpresa.trim();
    }
    public void setAreaAtuacao(String areaAtuacao){
        if(areaAtuacao == null || areaAtuacao.trim().length() == 0){
            throw new IllegalArgumentException("A área de atuação não deve estar vazia.");
        }
        this.areaAtuacao = areaAtuacao.trim();
    }
}