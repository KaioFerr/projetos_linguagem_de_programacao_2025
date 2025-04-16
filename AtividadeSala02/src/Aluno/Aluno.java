package Aluno;

import Curso.Curso;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private int matricula;
    private ArrayList<Curso> listaDeCursos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public boolean matricularAluno(Curso curso){
        try {
            curso.matricularAluno(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaDeCursos.add(curso);
    }

    public StringBuilder getlistaDeCursos() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (int i = 0; i < listaDeCursos.size(); i++){
            s.append(listaDeCursos.get(i).getNome());
            if (i != listaDeCursos.size() - 1) s.append(", ");
        }
        s.append("}");
        return s;
    }
}
