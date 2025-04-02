package calculadoraIMC;


import Individuo.Individuo;

import java.util.Objects;

public class CalculadoraIMC {

    private Individuo individuo;

    public CalculadoraIMC(Individuo individuo) {
        this.individuo = individuo;
    }

    public Double getTaxaMetabolica () {

        if (Objects.equals(this.individuo.getSexo(), "masculino")) {
            return 88.362 + (13.397 * this.individuo.getPeso()) + (4.799 * this.individuo.getAltura()) - (5.677 * this.individuo.getIdade());
        }

        return 447.593 + (9.247 * this.individuo.getPeso()) + (3.098 * this.individuo.getAltura()) - (4.330 * this.individuo.getIdade());
    }

    public Double gastoCalorioDiario(){
        return getTaxaMetabolica() * individuo.getTaxaAtividadeFisica();
    }

    public Double getQuantidadeIdealDaAgua() {
        return 0.35 * this.individuo.getPeso();
    }

    public Double getDeficitMetabolico (Double quantidadeParaPerderPeso, int dia) {
        return 7000 * quantidadeParaPerderPeso / dia;
    }

    public Double quantidadeCaloriaCorida(Double distancia){
        return 0.6 * this.individuo.getPeso() * distancia;
    }




}





//Para homens: TMB =
//Para mulheres: TMB = 447.593 + (9.247 * peso em kg) + (3.098 * altura em cm) – (4.330 * idade em anos