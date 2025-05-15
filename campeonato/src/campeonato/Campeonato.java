package campeonato;

import jogo.Jogo;
import time.Time;

import java.util.ArrayList;
import java.util.Comparator;

public class Campeonato {
    private ArrayList<Time> listaDeTimes = new ArrayList<>();

    public ArrayList<Time> getListaDeTimes() {
        return listaDeTimes;
    }

    public void adicionarTimeNaLista(Time time){
        listaDeTimes.add(time);
    }

    public void cadastrarJogo(Time time01, Time time02) throws Exception {
        if (time01.getListaUltimosOponentes().contains(time02)){
            throw new IllegalArgumentException("Jogo inválido: oponente já enfrentado.");
        }
        Jogo novoJogo = new Jogo(time01, time02);
    }

    public String tabelaDePontuacao(){
        listaDeTimes.sort(Comparator.comparingInt(Time::getPontuacao).reversed());
        StringBuilder tabela = new StringBuilder();
        tabela.append("Tabela de Resultados\n");
        for (int i = 0; i < listaDeTimes.size(); i++) {
            tabela.append((i + 1)).
                    append("º lugar: ").
                    append(listaDeTimes.get(i).getNome()).
                    append(" - Pontuação: ").
                    append(listaDeTimes.get(i).getPontuacao()).
                    append("\n");
        }
        return tabela.toString();
    }
}
