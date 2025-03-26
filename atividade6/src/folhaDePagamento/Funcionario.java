package folhaDePagamento;



public class Funcionario {

    public String nome;
    public int departamento;
    public double quantidadeDeHorasMes;
    public double salarioBase;
    public double horaExtra;
    public double insalubridade;
    public double bonificacao;
    public double inss;
    public double ir;
    public double planoDeSaude = 20;
    public double salarioLiquido;
    public double valorDaHoraTrabalhada;
    public double horasAdicionais;
    public double salarioBruto;

    public Funcionario(String nome, int departamento, double quantidadeDeHorasMes) throws Exception {

        this.nome = nome;
        this.departamento = departamento;
        this.quantidadeDeHorasMes = quantidadeDeHorasMes;

        this.calcularSalarioBase();
        this.calcularHoraExtra();
        this.calcularInsalubridade();
        this.calcularBonificacao();
        this.calcularInssEIR();
        this.calcularSalarioLiquido();
    }

    private void calcularSalarioBase() throws Exception {

        if (this.departamento == 1){
            this.valorDaHoraTrabalhada = 22;
        }else if (this.departamento == 2){
            this.valorDaHoraTrabalhada = 12;
        }
        else {
            throw new Exception("Departamento inválido!");
        }
        this.salarioBase = this.valorDaHoraTrabalhada * this.quantidadeDeHorasMes;
    }

    private void calcularHoraExtra() {

        this.horasAdicionais = this.quantidadeDeHorasMes - 40;

        if (this.horasAdicionais >= 0){

            this.horaExtra = this.valorDaHoraTrabalhada * 2 * this.horasAdicionais;
        }else {
            this.horaExtra = 0;
        }
    }

    private void calcularInsalubridade() throws Exception {
        if (this.departamento == 2){
            this.insalubridade = 0.15;
        }else this.insalubridade = 0;
    }

    private void calcularBonificacao(){

        if (this.quantidadeDeHorasMes > 20 && this.quantidadeDeHorasMes <= 30){
            this.bonificacao = 0.03;
        }else if (this.quantidadeDeHorasMes > 30 && this.quantidadeDeHorasMes <= 40) {
            this.bonificacao = 0.05;
        }else if (this.quantidadeDeHorasMes > 40 && this.departamento == 1){
            this.bonificacao = 0.1;
        }else this.bonificacao = 0;
    }

    private void calcularInssEIR() {

        this.salarioBruto = this.salarioBase + this.horaExtra + this.insalubridade + this.bonificacao;

        this.inss = 0.07 * this.salarioBruto;

        this.ir = 0.12 * this.salarioBruto;
    }

    private void calcularSalarioLiquido(){
        this.salarioLiquido = this.salarioBruto - this.inss - this.ir + this.planoDeSaude;
    }

    public StringBuilder getDadosDoFuncionario() {

        StringBuilder informacoesDoFuncionario = new StringBuilder();
        
        informacoesDoFuncionario.append("Nome: ").append(this.nome).append(" | ");
        informacoesDoFuncionario.append("Salário base: ").append(this.salarioBase).append(" | ");
        informacoesDoFuncionario.append("Hora Extra: ").append(this.horaExtra).append(" | ");
        informacoesDoFuncionario.append("Insalubridade: ").append(this.insalubridade).append(" | ");
        informacoesDoFuncionario.append("Bonificação: ").append(this.bonificacao).append(" | ");
        informacoesDoFuncionario.append("INSS: ").append(this.inss).append(" | ");
        informacoesDoFuncionario.append("IR: ").append(this.ir).append(" | ");
        informacoesDoFuncionario.append("Plano Saúde: ").append(this.planoDeSaude).append(" | ");
        informacoesDoFuncionario.append("Salário Líquido: ").append(this.salarioLiquido).append(" | ");

        return informacoesDoFuncionario;
    }
}
