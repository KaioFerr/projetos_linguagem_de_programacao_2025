package time;

import java.util.ArrayList;

public class Time {
    private String nome;
    private Integer pontuacao;
    private final ArrayList<Time> listaUltimosOponentes;
    private Integer qtdJogos;

    public Time(String nome) {
        this.qtdJogos = 0;
        this.nome = nome;
        this.pontuacao = 0;
        this.listaUltimosOponentes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Integer getQtdJogos() {
        return qtdJogos;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void pontuar(Integer pontuacao) {
        this.pontuacao += pontuacao;
    }

    public ArrayList<Time> getListaUltimosOponentes() {
        return listaUltimosOponentes;
    }

    public void setUltimoOponente(Time ultimoOponente) {
        listaUltimosOponentes.add(ultimoOponente);
    }
}
