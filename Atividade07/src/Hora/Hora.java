package Hora;

public class Hora {

    private final int horas;
    private final int minutos;
    private final int segundos;

    public Hora (int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;

    }

    public boolean isValido() {
        return (this.horas > 0 && this.horas < 24) &&
                (this.minutos > 0 && this.minutos < 60) &&
                (this.segundos > 0 && this.segundos < 60);
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public String displayHora() {
        return isValido()? "Display:\n" +
                this.horas + ":" +
                this.minutos + ":" +
                this.segundos : "00:00:00";
    }

    public String compararHoras(Hora horaCorrente) throws Exception{
        if(this.isValido() && horaCorrente.isValido()){

            if ((this.horas == horaCorrente.getHoras()) &&
                   (this.minutos == horaCorrente.getMinutos()) &&
                    (this.segundos == horaCorrente.getSegundos())) return "0";

            int diferencaEntreHorasEmSegundos = (this.horas - horaCorrente.getHoras()) * 60 * 60;
            int diferencaEntreMinutosEmSegundos = (this.minutos - horaCorrente.getMinutos()) * 60;
            int diferencaEntreSegundosEmSegundos = this.segundos - horaCorrente.getSegundos();

            int totalDeSegundos = Math.abs( diferencaEntreHorasEmSegundos +
                    diferencaEntreMinutosEmSegundos +
                    diferencaEntreSegundosEmSegundos);

            return "Diferenca de horas:\n" +
                    totalDeSegundos + " segundos";
        }else {
            throw new Exception("Horas, minutos ou segundos inválidos!");
        }
    }
}
