package Curso;

import Aluno.Aluno;

import java.util.ArrayList;

public class Curso {
    private String nome;
    private int codigo;
    private ArrayList<Aluno> listaDeAlunos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void matricularAluno(Aluno aluno) throws Exception{
        try{
            listaDeAlunos.add(aluno);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public StringBuilder getlistaDeAlunos() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (int i = 0; i < listaDeAlunos.size(); i++){
            s.append(listaDeAlunos.get(i).getNome());
            if (i != listaDeAlunos.size() - 1) s.append(", ");
        }
        s.append("}");
        return s;
    }
}
