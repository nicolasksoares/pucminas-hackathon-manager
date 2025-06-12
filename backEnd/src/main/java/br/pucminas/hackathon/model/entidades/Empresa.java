package br.pucminas.hackathon.model.entidades;

public class Empresa extends Instituicao {

    private String tipoEmpresa;
    private String areaAtuacao;

    public Empresa(String nome, String cnpj, String endereco, String tipoEmpresa, String areaAtuacao) {
        super(nome, cnpj, endereco);

        if (tipoEmpresa == null || tipoEmpresa.trim().isEmpty()){
            throw new IllegalArgumentException("O tipo da empresa não pode estar vazio.");
        }
        this.tipoEmpresa = tipoEmpresa.trim();

        if(areaAtuacao == null || areaAtuacao.trim().isEmpty()){
            throw new IllegalArgumentException("A área de atuação não pode estar vazia.");
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
        if (tipoEmpresa == null || tipoEmpresa.trim().isEmpty()){
            throw new IllegalArgumentException("O tipo da empresa não pode estar vazio.");
        }
        this.tipoEmpresa = tipoEmpresa.trim();
    }

    public void setAreaAtuacao(String areaAtuacao){
        if(areaAtuacao == null || areaAtuacao.trim().isEmpty()){
            throw new IllegalArgumentException("A área de atuação não pode estar vazia.");
        }
        this.areaAtuacao = areaAtuacao.trim();
    }

    @Override
    public String toString() {
        return super.toString() + " [Tipo: " + tipoEmpresa + "]";
    }
}