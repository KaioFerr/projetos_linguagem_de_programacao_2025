package folhaDePagamento;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<StringBuilder> listaDeFuncionario = new ArrayList<>();

        for (int i = 0; i < 2; i++) {

            String nome = JOptionPane.showInputDialog("Digite o nome do funcionário");
            int departamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o departamento"));
            double quantidadeDeHorasMes = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de horas trabalhadas no mês"));

            try {

                Funcionario funcionario = new Funcionario(nome, departamento, quantidadeDeHorasMes);
                listaDeFuncionario.addLast(funcionario.getDadosDoFuncionario());
                System.out.println(i+1 + " | " + listaDeFuncionario.get(i));

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
