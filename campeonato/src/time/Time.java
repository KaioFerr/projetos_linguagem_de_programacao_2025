package time;

public class Time {
    private String nome;
    private Integer pontuacao;
    private Integer totalJogos;
    private Integer qtdVitoria;
    private Integer qtdDerrota;
    private Integer qtdGolsMarcados;
    private Integer qtdGolsSofridos;
    private Integer qtdEmpate;

    public Time(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.totalJogos = 0;
        this.qtdVitoria = 0;
        this.qtdDerrota = 0;
        this.qtdGolsMarcados = 0;
        this.qtdGolsSofridos = 0;
        this.qtdEmpate = 0;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTotalJogos() {
        return totalJogos;
    }

    public void setTotalJogos(){
        this.totalJogos++;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void pontuar(Integer pontuacao) {
        this.pontuacao += pontuacao;
    }

    public Integer getQtdVitoria() {
        return qtdVitoria;
    }

    public void setQtdVitoria() {
        this.qtdVitoria++;
    }

    public Integer getQtdDerrota() {
        return qtdDerrota;
    }

    public void setQtdDerrota() {
        this.qtdDerrota++;
    }

    public Integer getQtdGolsMarcados() {
        return qtdGolsMarcados;
    }

    public void setQtdGolsMarcados(Integer qtdGolsMarcados) {
        this.qtdGolsMarcados += qtdGolsMarcados;
    }

    public Integer getQtdGolsSofridos() {
        return qtdGolsSofridos;
    }

    public void setQtdGolsSofridos(Integer qtdGolsSofridos) {
        this.qtdGolsSofridos += qtdGolsSofridos;
    }

    public Integer getSaldoDeGols() {
        return qtdGolsMarcados - qtdGolsSofridos;
    }

    public Integer getQtdEmpate() {
        return qtdEmpate;
    }

    public void setQtdEmpate() {
        this.qtdEmpate ++;
    }
}
