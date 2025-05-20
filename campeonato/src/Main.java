import campeonato.Campeonato;
import tabela.Tabela;
import time.Time;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();

        while (true) {
            if (solicitarTimes(campeonato)) {
                break;
            }
        }

        while (true) {
            if (!gerenciarJogos(campeonato)) {
                break;
            }
        }

        Tabela tabela = new Tabela(campeonato.getListaDeTimes());
        tabela.mostrarTabela();

        JOptionPane.showMessageDialog(null, "Encerrando o programa. Obrigado por utilizar o sistema!");
    }

    private static boolean solicitarTimes(Campeonato campeonato) {
        try {
            int qtdTimes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de times (máximo 10):"));

            if (qtdTimes < 2 || qtdTimes > 10) {
                throw new Exception("Quantidade de times inválida");
            }

            for (int i = 0; i < qtdTimes; i++) {
                String nome = JOptionPane.showInputDialog("Digite o nome do time " + (i + 1) + ":");
                campeonato.adicionarTimeNaLista(new Time(nome));
            }

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return false;
        }
    }

    private static boolean gerenciarJogos(Campeonato campeonato) {
        ArrayList<Time> times = campeonato.getListaDeTimes();

        if (JOptionPane.showConfirmDialog(null, "Gostaria de criar um jogo?") != JOptionPane.OK_OPTION) {
            return false;
        }

        try {
            StringBuilder lista = new StringBuilder();
            for (int i = 0; i < times.size(); i++) {
                lista.append(i).append(" - ").append(times.get(i).getNome()).append("\n");
            }

            int index1 = Integer.parseInt(JOptionPane.showInputDialog(lista + "Digite o índice do Time 01:"));
            int index2 = Integer.parseInt(JOptionPane.showInputDialog(lista + "Digite o índice do Time 02:"));

            if (index1 == index2) {
                JOptionPane.showMessageDialog(null, "Os times devem ser diferentes.");
                return true;
            }

            if (index1 < 0 || index1 >= times.size() || index2 < 0 || index2 >= times.size()) {
                JOptionPane.showMessageDialog(null, "Índices inválidos.");
                return true;
            }

            Time time1 = times.get(index1);
            Time time2 = times.get(index2);

            if (time1.getTotalJogos() >= times.size() - 1 || time2.getTotalJogos() >= times.size() - 1) {
                JOptionPane.showMessageDialog(null, "Um dos times já atingiu o limite de jogos.");
                return true;
            }

            campeonato.cadastrarJogo(time1, time2);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite um número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar jogo: " + e.getMessage());
        }

        return true;
    }
}
