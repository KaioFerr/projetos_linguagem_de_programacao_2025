package Aluno;

public class Aluno {

    private String matricula;
    private String nome;
    private Double notaProva1;
    private Double notaProva2;
    private Double notaTrabalho;

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNotaProva1() {
        return notaProva1;
    }

    public void setNotaProva1(Double notaProva1) throws Exception{
        if (notaProva1 > 3){
            throw new Exception("Nota da prova 1 inválida!");
        }
        this.notaProva1 = notaProva1;
    }

    public Double getnotaProva2() {
        return notaProva2;
    }

    public void setnotaProva2(Double notaProva2) throws Exception{
        if (notaProva2 > 3){
            throw new Exception("Nota da prova 2 inválida!");
        }
        this.notaProva2 = notaProva2;
    }

    public Double getNotaTrabalho() {
        return notaTrabalho;
    }

    public void setNotaTrabalho(Double notaTrabalho) throws Exception{
        if (notaTrabalho > 6){
            throw new Exception("Nota do trabalho inválida!");
        }
        this.notaTrabalho = notaTrabalho;
    }

    public Double notaTotal() {
        return this.notaProva1 + this.notaProva1 + this.notaTrabalho;
    }

    public boolean isAprovado() {
        return this.notaTotal() >= 6;
    }

    @Override
    public String toString() {

        String statusDeAprovacao = isAprovado() ? "aprovado" : "reprovado";

        return "Matricula: " + matricula +
                ", \nNome: " + nome +
                ", \nNota da prova 1: " + notaProva1 +
                ", \nNota da prova 2: " + notaProva2 +
                ", \nNota do trabalho: " + notaTrabalho +
                ", \nAprovado: " + statusDeAprovacao;
    }

}
