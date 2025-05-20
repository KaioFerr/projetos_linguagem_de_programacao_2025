package tabela;

import time.Time;

import javax.swing.*;
import java.util.ArrayList;

public class Tabela {
    private JTable tabela;
    private ArrayList<Time> listaDeTimes;

    public Tabela(ArrayList<Time> listaDeTimes) {
        this.listaDeTimes = listaDeTimes;
    }

    public JTable getTabela(){
        String[] colunas = {
                "Nome do Time",
                "Total de Jogos",
                "Vitória",
                "Empate",
                "Derrota",
                "Total de Pontos",
                "Gols Marcados",
                "Gols Sofridos",
                "Saldo de Gols"
        };

        Object[][] dados = new Object[listaDeTimes.size()][9];

        for (int i = 0; i < listaDeTimes.size(); i++) {
            Time time = listaDeTimes.get(i);
            dados[i][0] = time.getNome();
            dados[i][1] = time.getTotalJogos();
            dados[i][2] = time.getQtdVitoria();
            dados[i][3] = time.getQtdEmpate();
            dados[i][4] = time.getQtdDerrota();
            dados[i][5] = time.getPontuacao();
            dados[i][6] = time.getQtdGolsMarcados();
            dados[i][7] = time.getQtdGolsSofridos();
            dados[i][8] = time.getSaldoDeGols();
        }

        this.tabela = new JTable(dados, colunas);
        return this.tabela;
    }

    public void mostrarTabela() {
        JTable tabela = getTabela();
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new java.awt.Dimension(800, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Tabela de Times", JOptionPane.INFORMATION_MESSAGE);
    }

}
