import campeonato.Campeonato;
import tabela.Tabela;
import time.Time;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Campeonato campeonato = new Campeonato();

        while(true){
            if (listarTimes(campeonato)){
                break;
            }
        }

        while(true) {
            if(!criarJogo(campeonato)){
                break;
            }
        }

    }
    private static boolean listarTimes(Campeonato campeonato) throws Exception{

        try{
            int qtdTimes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de times:"));

            if (qtdTimes > 10) throw new Exception("Quantidade de times inválida");

            for (int i = 0; i < qtdTimes; i++) {
                try {
                    String nomeTime = JOptionPane.showInputDialog("Digite o nome do time: ");
                    Time time = new Time(nomeTime);
                    campeonato.adicionarTimeNaLista(time);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage() + ": Erro ao listar times");
                }
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    private static boolean criarJogo(Campeonato campeonato) throws Exception {

        ArrayList <Time> listaDeTimes = campeonato.getListaDeTimes();

        if (JOptionPane.showConfirmDialog(null, "Gostaria de criar um jogo?") == JOptionPane.OK_OPTION) {
            try{
                StringBuilder mensagem = new StringBuilder();

                for (int i = 0; i < listaDeTimes.size(); i++) {
                    mensagem.append(i).
                            append(" - time ").
                            append(listaDeTimes.get(i).getNome()).
                            append("\n");
                }

                listaDeTimes.forEach(time -> {

                    int time01 = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem + "Digite o index do time 01:"));
                    int time02 = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem + "Digite o index do time 02:"));

                    if (time.getTotalJogos() < listaDeTimes.size()) {
                        try {
                            campeonato.cadastrarJogo(listaDeTimes.get(time01), listaDeTimes.get(time02));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                //implemtar tabela
                Tabela tabela = new Tabela(campeonato.getListaDeTimes());
                tabela.mostrarTabela();
//                JOptionPane.showMessageDialog(null, campeonato.tabelaDePontuacao());
                return true;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            return true;
        }
        //implementar tabela
        Tabela tabela = new Tabela(campeonato.getListaDeTimes());
        tabela.mostrarTabela();
//        JOptionPane.showMessageDialog(null, campeonato.tabelaDePontuacao());
        return false;
    }
}
