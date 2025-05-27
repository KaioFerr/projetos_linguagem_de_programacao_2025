package funcionario;

public class Horista extends Funcionario{
    @Override
    public Double getSalario(){
        return this.getQtdHorasTrabalhada() * this.getDepartamento().getValorHoraTrabalhada();
    }
}
