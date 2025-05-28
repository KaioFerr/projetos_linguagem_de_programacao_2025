package funcionario;

public class Comissionado extends Funcionario{
    private Double valorDasVendas;
    private Double comissaoPercentual;

    public Double getValorDasVendas() {
        return valorDasVendas;
    }

    public void setValorDasVendas(Double valorDasVendas) {
        this.valorDasVendas = valorDasVendas;
    }

    public Double getComissaoPercentual() {
        return comissaoPercentual;
    }

    public void setComissaoPercentual(Double comissaoPercentual) {
        this.comissaoPercentual = comissaoPercentual;
    }

    @Override
    public Double getSalario() {
        return valorDasVendas * (comissaoPercentual/100);
    }
}
