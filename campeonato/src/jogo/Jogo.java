package jogo;

import time.Time;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class Jogo {
    private Time time01;
    private Time time02;
    private Integer pontoTime01;
    private Integer pontoTime02;

    public Jogo(Time time01, Time time02) throws Exception{

        Random random = new Random();
        try{
            this.time02 = time02;
            this.time01 = time01;

            time01.setTotalJogos();
            time02.setTotalJogos();

            this.pontoTime01 = random.nextInt(5);
            this.pontoTime02 = random.nextInt(5);

            time01.setQtdGolsMarcados(pontoTime01);
            time02.setQtdGolsMarcados(pontoTime02);

            time01.setQtdGolsSofridos(pontoTime02);
            time02.setQtdGolsSofridos(pontoTime01);

            JOptionPane.showMessageDialog(null, mostrarPlacar());;
            encerrarJogo();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar jogo.");
        }
    }

    public Time getTime01() {
        return time01;
    }

    public Time getTime02() {
        return time02;
    }

    public void encerrarJogo(){
        Integer pontoDeEmpate = 1;
        Integer pontoDeVitoria = 3;

        if (Objects.equals(pontoTime01, pontoTime02)) {
            time01.pontuar(pontoDeEmpate);
            time02.pontuar(pontoDeEmpate);

            time01.setQtdEmpate();
            time02.setQtdEmpate();

        } else if (pontoTime02 < pontoTime01) {
            time01.pontuar(pontoDeVitoria);
            time01.setQtdVitoria();
            time02.setQtdDerrota();
        }else {
            time02.pontuar(pontoDeVitoria);
            time01.setQtdDerrota();
            time02.setQtdVitoria();
        }
    }

    public String mostrarPlacar(){
        return time01.getNome() + pontoTime01 + " x " + pontoTime02 + time02.getNome();
    }
}
