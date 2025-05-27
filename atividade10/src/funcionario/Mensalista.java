package funcionario;

public class Mensalista extends Funcionario{
    private Double salario;

    @Override
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
