package Aluno;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String nome = JOptionPane.showInputDialog("Digite o nome do aluno");
        String matricula = JOptionPane.showInputDialog("Digite a matricula do aluno");
        Double notaProva1 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da prova 1"));
        Double notaProva2 = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota da prova 2"));
        Double notaTrabalho = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota do trabalho"));

        try {

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setMatricula(matricula);
            aluno.setNotaProva1(notaProva1);
            aluno.setnotaProva2(notaProva2);
            aluno.setNotaTrabalho(notaTrabalho);
            JOptionPane.showMessageDialog(null, aluno);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
