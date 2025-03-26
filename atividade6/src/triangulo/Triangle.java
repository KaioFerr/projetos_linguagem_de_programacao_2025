package triangulo;

public class Triangle {

    public double primeiroLado;
    public double segundoLado;
    public double terceiroLado;

    public String getTriangleType (){

        if (this.primeiroLado <= 0 || this.segundoLado <= 0 || this.terceiroLado <= 0 ||
                this.primeiroLado + this.segundoLado <= this.terceiroLado ||
                this.primeiroLado + this.terceiroLado <= this.segundoLado ||
                this.segundoLado + this.terceiroLado <= this.primeiroLado) {
            return "Valores inválidos para um triângulo";
        }

        if (this.primeiroLado == this.segundoLado && this.primeiroLado == this.terceiroLado) {
            return "O triângulo é equilátero";
        }

        if (this.primeiroLado != this.segundoLado && this.primeiroLado != this.terceiroLado && this.segundoLado != this.terceiroLado) {
            return "O triângulo é escaleno";
        }

        return "O triângulo é isósceles";
    }
}
