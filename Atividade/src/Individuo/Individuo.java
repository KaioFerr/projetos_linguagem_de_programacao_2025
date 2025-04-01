package Individuo;

public class Individuo {
    private int idade;
    private String nome;
    private Double peso;
    private String sexo;
    private Double altura;

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

    public void setSexo(String sexo) throws Exception {
        if (sexo.toLowerCase() != "masculino" || sexo.toLowerCase() != "feminino") throw new Exception("Sexo invalido (Masculino, Feminino)");
        this.sexo = sexo.toLowerCase();
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) throws Exception{
        if (altura < 0) throw new Exception("Altura invalido");
        this.altura = altura;
    }
}


