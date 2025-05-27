package funcionario;

import departamento.Departamento;

public abstract class Funcionario {
    private String nome;
    private String cidade;
    private String estado;
    private Double qtdHorasTrabalhada;
    private Departamento departamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getQtdHorasTrabalhada() {
        return qtdHorasTrabalhada;
    }

    public void setQtdHorasTrabalhada(Double qtdHorasTrabalhada) {
        this.qtdHorasTrabalhada = qtdHorasTrabalhada;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public abstract Double getSalario();

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", qtdHorasTrabalhada=" + qtdHorasTrabalhada +
                ", departamento=" + (departamento != null ? departamento.getDescricao() : "Sem departamento") +
                '}';
    }

}
