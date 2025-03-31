package Data;

public class Main {
    public static void main(String[] args) throws Exception {

        Data data = new Data(24,11,2000);
        Data dataCorrente = new Data(25,10,2001);
        System.out.println(data + "\n" + data.compararDatas(dataCorrente));
    }
}
