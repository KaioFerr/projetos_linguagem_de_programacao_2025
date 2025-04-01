package NumeroInteiro;

public class NumeroInteiro {

    private int numeroInteiro;

    public NumeroInteiro() {
        this.numeroInteiro = 0;
    }

    public NumeroInteiro (int numero){
        this.numeroInteiro = numero;
    }

    public int soma (int numero){
        return this.numeroInteiro += numero;
    }

    public int subtrai(int numero){
        return this.numeroInteiro -= numero;
    }

    public boolean isPrimo(){
        if (this.numeroInteiro < 2) return false;
        for (int i = 2; i * i <= this.numeroInteiro; i++) {
            if (this.numeroInteiro % i == 0) return false;
        }
        return true;
    }

    public int getNextPrimo() {
        int nextPrimo = this.numeroInteiro + 1;
        while (!new NumeroInteiro(nextPrimo).isPrimo()) {
            nextPrimo++;
        }
        return nextPrimo;
    }

    public int getNumeroInteiro() {
        return this.numeroInteiro;
    }
}
