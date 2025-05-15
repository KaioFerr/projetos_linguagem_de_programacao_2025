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
            this.pontoTime01 = random.nextInt(5);
            this.pontoTime02 = random.nextInt(5);
            JOptionPane.showMessageDialog(null, mostrarPlacar());;
            encerrarJogo();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar jogo.");
        }
    }

    public void encerrarJogo(){

        time01.setUltimoOponente(time02);
        time02.setUltimoOponente(time01);

        Integer pontoDeEmpate = 1;
        Integer pontoDeVitoria = 3;

        if (Objects.equals(pontoTime01, pontoTime02)) {
            time01.pontuar(pontoDeEmpate);
            time02.pontuar(pontoDeEmpate);
        } else if (pontoTime02 < pontoTime01) {
            time01.pontuar(pontoDeVitoria);
        }else {
            time02.pontuar(pontoDeVitoria);
        }
    }

    public String mostrarPlacar(){
        return time01.getNome() + pontoTime01 + " x " + pontoTime02 + time02.getNome();
    }
}
