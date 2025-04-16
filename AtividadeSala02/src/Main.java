import Aluno.Aluno;
import Curso.Curso;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Aluno aluno01 = new Aluno();
        aluno01.setMatricula(123);
        aluno01.setNome("Kaio");

        Aluno aluno02 = new Aluno();
        aluno02.setNome("Pato");
        aluno02.setMatricula(124);

        Curso curso01 = new Curso();
        curso01.setCodigo(12);
        curso01.setNome("Engenharia de Software");

        Curso curso02 = new Curso();
        curso02.setNome("Linguagem de Programação");
        curso02.setCodigo(13);

        aluno01.matricularAluno(curso01);
        aluno01.matricularAluno(curso02);

        aluno02.matricularAluno(curso01);

        JOptionPane.showMessageDialog(null, aluno01.getlistaDeCursos());
        JOptionPane.showMessageDialog(null, aluno02.getlistaDeCursos());

        JOptionPane.showMessageDialog(null, curso01.getlistaDeAlunos());
        JOptionPane.showMessageDialog(null, curso02.getlistaDeAlunos());

    }
}