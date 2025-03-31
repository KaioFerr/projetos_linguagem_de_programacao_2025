package Hora;

public class Main {
    public static void main(String[] args) throws Exception {
        Hora hora = new Hora(23,12, 12);
        Hora horaCorrente = new Hora(9, 13, 37);
        System.out.println(hora.displayHora());
        System.out.println(hora.compararHoras(horaCorrente));
    }
}
