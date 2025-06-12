package br.pucminas.hackathon.model.entidades;

public class Estudante extends Pessoa {
    private String matricula;
    private String curso;

    public Estudante(String nome,String cpf,String email,Instituicao instituicao,String matricula,String curso) {
        super(nome,cpf,email,instituicao);

        if( matricula == null || matricula.trim().isEmpty()){
            throw new IllegalArgumentException("A matrícula não pode estar vazia!");
        }
        this.matricula = matricula.trim();

        if( curso == null || curso.trim().isEmpty()){
            throw new IllegalArgumentException("O curso não pode estar vazio!");
        }
        this.curso = curso.trim();
    }

    public String getMatricula() {
        return matricula;
    }
    public String getCurso(){
        return curso;
    }

    protected void setMatricula(String matricula){
        if( matricula == null || matricula.trim().isEmpty()){
            throw new IllegalArgumentException("A matrícula não pode estar vazia!");
        }
        this.matricula = matricula.trim();
    }
    public void setCurso(String curso){
        if( curso == null || curso.trim().isEmpty()){
            throw new IllegalArgumentException("O curso não pode estar vazio!");
        }
        this.curso = curso.trim();
    }

    @Override
    public String toString() {
        return "Estudante [" + super.toString() + ", Matrícula: " + matricula + ", Curso: " + curso + "]";
    }
}