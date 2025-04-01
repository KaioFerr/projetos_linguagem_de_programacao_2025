package Voo;

import Data.Data;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                int numeroDoVoo = solicitarInteiro("Digite o número do voo");
                int diaDoVoo = solicitarInteiro("Digite o dia do voo");
                int mesDoVoo = solicitarInteiro("Digite o mês do voo");
                int anoDoVoo = solicitarInteiro("Digite o ano do voo");

                Data dataDoVoo = new Data(diaDoVoo, mesDoVoo, anoDoVoo);
                Voo novoVoo = new Voo(numeroDoVoo, dataDoVoo);

                processarReservas(novoVoo);
                JOptionPane.showMessageDialog(null, novoVoo + "\nSaindo...");
                break;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static int solicitarInteiro(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Digite um número válido.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private static void processarReservas(Voo voo) throws Exception {
        while (true) {
            int confirmacao = JOptionPane.showConfirmDialog(null, "Gostaria de reservar um assento?", "Reserva", JOptionPane.YES_NO_OPTION);

            if (confirmacao != JOptionPane.YES_OPTION) {
                break;
            }

            while (true) {
                int numeroDoAssento = solicitarInteiro("Digite o número do assento");
                if (voo.reservarAssento(numeroDoAssento)) {
                    JOptionPane.showMessageDialog(null, "Assento Reservado!\n" + voo);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Assento Ocupado! " + voo.proximoLivre() + "\nQuantidade de vagas: " + voo.vagas(), "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
