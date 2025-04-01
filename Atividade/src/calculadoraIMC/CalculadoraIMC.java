package calculadoraIMC;


import Individuo.Individuo;

import java.util.Objects;

public class CalculadoraIMC {

    public Double getTaxaMetabolica (Individuo individuo) {

        if (Objects.equals(individuo.getSexo(), "masculino")) {
            return 88.362 + (13.397 * individuo.getPeso()) + (4.799 * individuo.getAltura()) - (5.677 * individuo.getIdade());
        }

        return 447.593 + (9.247 * individuo.getPeso()) + (3.098 * individuo.getAltura()) - (4.330 * individuo.getIdade());
    }

    public Double getQuantidadeIdealDaAgua(Individuo individuo) {
        return 0.35 * individuo.getPeso();
    }

    public Double getDeficitMetabolico (Individuo individuo) {

    }




}





//Para homens: TMB =
//Para mulheres: TMB = 447.593 + (9.247 * peso em kg) + (3.098 * altura em cm) – (4.330 * idade em anos