package Individuo;

public class Individuo {
    private String nome;
    private String sexo;
    private int idade;
    private Double peso;
    private Double altura;
    private Double taxaAtividadeFisica;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) throws Exception{
        if (peso < 0) throw new Exception("Peso invalido");
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(int indice) {
        String[] tipoSexo = {"Masculino", "Feminino"};
        this.sexo = tipoSexo[indice];
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) throws Exception{
        if (altura < 0) throw new Exception("Altura invalido");
        this.altura = altura;
    }
    
    public void setTaxaAtividadeFisica(int nivelAtividadeFisica) throws Exception {
        if (nivelAtividadeFisica >= 0 && nivelAtividadeFisica < 5){
            double[] listaDeNiveisDeAtividadeFisica = {1.2, 1.375, 1.55, 1.725, 1.9};
            this.taxaAtividadeFisica = listaDeNiveisDeAtividadeFisica[nivelAtividadeFisica];
        }else throw new Exception("Taxa Atividade Fisica Invalida (1-5)");
    }

    public Double getTaxaAtividadeFisica() {
        return taxaAtividadeFisica;
    }
}


