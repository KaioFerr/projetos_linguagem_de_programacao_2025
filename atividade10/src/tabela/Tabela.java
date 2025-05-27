package tabela;

import javax.swing.*;

public class Tabela {


    private JTable tabela;
    private String[] colunas;
    private Object[][] dados;


    public Tabela(
            String[] colunas,
            Object[][] dados
    ) {
        this.dados = dados;
        this.colunas = colunas;
    }

    public JTable construirTabelaFuncionarios() {
        this.tabela = new JTable(dados, colunas);
        return this.tabela;
    }

    public void mostrarTabela() {
        JTable tabela = construirTabelaFuncionarios();
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new java.awt.Dimension(800, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Tabela de Times", JOptionPane.INFORMATION_MESSAGE);
    }
}
