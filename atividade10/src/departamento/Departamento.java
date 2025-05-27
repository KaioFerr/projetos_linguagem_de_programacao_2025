package departamento;

import funcionario.Funcionario;

import java.util.ArrayList;

public class Departamento {
    private int codigoDepartamento;
    private String descricao;
    private Double valorHoraTrabalhada;
    private final ArrayList<Funcionario> listaFuncionario;

    public Departamento() {
        this.listaFuncionario = new ArrayList<>();
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(int codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorHoraTrabalhada() {
        return valorHoraTrabalhada;
    }

    public void setValorHoraTrabalhada(Double valorHoraTrabalhada) {
        this.valorHoraTrabalhada = valorHoraTrabalhada;
    }

    public ArrayList<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionario.setDepartamento(this);
        this.listaFuncionario.add(funcionario);
    }

    public Double getTotalSalario() {
        return listaFuncionario.stream()
                .mapToDouble(Funcionario::getSalario)
                .sum();
    }
}
