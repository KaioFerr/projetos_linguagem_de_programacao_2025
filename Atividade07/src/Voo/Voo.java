package Voo;

import Data.Data;

public class Voo {

    private int numeroDoVoo;
    private Data dataDoVoo;
    private boolean[] listaDeAssentos = new boolean[100];

    public Voo(int numeroDoVoo, Data dataDoVoo) {
        this.numeroDoVoo = numeroDoVoo;
        this.dataDoVoo = dataDoVoo;
    }

    public int getVoo() {
        return numeroDoVoo;
    }

    public Data getData() {
        return dataDoVoo;
    }

    public boolean reservarAssento(int numeroDoAssento) throws Exception{

        if(numeroDoAssento - 1 > 100 || numeroDoAssento < 0){
            throw new Exception("Número do assento deve estar entre 1 e 100");
        }

        if (!listaDeAssentos[numeroDoAssento - 1]){
            listaDeAssentos[numeroDoAssento - 1] = true;
            return true;
        }else return false;
    }

    public int vagas(){
        int contadorDeAssentos = 0;

        for (boolean assento : listaDeAssentos){
            if(!assento) {
                contadorDeAssentos++;
            }
        }

        return contadorDeAssentos;
    }

    public String proximoLivre() {
        for (int i = 0; i < 100; i++) {
            if(!listaDeAssentos[i]){
                return "Assento " + (i + 1) + " disponível!";
            }
        }
        return "Nenhum assento disponível!";
    }

    @Override
    public String toString() {
        return "Número do Voo: " + numeroDoVoo +
                "\nData do Voo: " + dataDoVoo;
    }
}
