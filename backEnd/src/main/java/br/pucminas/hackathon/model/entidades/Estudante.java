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

    @Override
    public boolean equals(Object o) {
        //Verifica se é o mesmo objeto na memória
        if (this == o) return true;

        //Verifica se o outro objeto é nulo ou de uma classe diferente
        if (o == null || getClass() != o.getClass()) return false;

        //Converte o outro objeto para a classe Estudante para poder comparar
        Estudante outroEstudante = (Estudante) o;

        //Compara o atributo chave (a matrícula). Se forem iguais, os objetos são considerados iguais.
        return this.matricula.equals(outroEstudante.matricula);
    }

    @Override
    public int hashCode() {
        return this.matricula.hashCode();
    }
}