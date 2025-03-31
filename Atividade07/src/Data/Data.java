package Data;

public class Data {

    private final int dia;
    private final int mes;
    private final int ano;
    
    public Data (int dia, int mes, int ano){

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {

        String data = dia + " de " +
                getMesPorExtenso() + " de " +
                ano;

        return isValido(this.dia, this.mes, this.ano)? data : "01/01/0001";
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public String getMesPorExtenso() {
        String[] meses =  {
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        return meses[this.mes - 1];
    }

    public int getAno() {
        return ano;
    }

    private boolean isValido(int dia, int mes, int ano) {
        return (dia > 0 && dia < 31) &&
                (mes > 0 && mes < 12) &&
                ano > 0;
    }

    public int compararDatas(Data dataCorrente) throws Exception{

        if (!isValido(dataCorrente.getDia(), dataCorrente.getMes(), dataCorrente.getAno())){
            throw new Exception("Data inválida!");
        }else{
            if (this.ano > dataCorrente.getAno()) return -1;
            else if (this.ano < dataCorrente.getAno()) return 1;

            if (this.mes > dataCorrente.getMes()) return -1;
            else if (this.mes < dataCorrente.getMes()) return 1;

            if (this.dia > dataCorrente.getDia()) return -1;
            else if (this.dia < dataCorrente.getDia()) return 1;

            return 0;
        }
    }

}
