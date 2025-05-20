package campeonato;

import jogo.Jogo;
import time.Time;

import java.util.ArrayList;
import java.util.Comparator;

public class Campeonato {
    private ArrayList<Time> listaDeTimes = new ArrayList<>();
    private ArrayList<Jogo> listaDeJogos = new ArrayList<>();

    public ArrayList<Time> getListaDeTimes() {
        return listaDeTimes;
    }

    public ArrayList<Jogo> getListaDeJogos() {
        return listaDeJogos;
    }

    public void adicionarTimeNaLista(Time time){
        listaDeTimes.add(time);
    }

    public void cadastrarJogo(Time time01, Time time02) throws Exception {
        listaDeJogos.forEach(jogo -> {
            if (jogo.getTime01().equals(time01) && jogo.getTime02().equals(time02)){
                throw new IllegalArgumentException("Este jogo já foi realizado! Escolha outra dupla de times.");
            }
        });
        Jogo novoJogo = new Jogo(time01, time02);
        listaDeJogos.add(novoJogo);
    }
}
