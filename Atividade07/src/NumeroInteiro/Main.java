package NumeroInteiro;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        NumeroInteiro numero = new NumeroInteiro();

        while (true) {
            String opcao = JOptionPane.showInputDialog(
                    "Número atual: " + numero.getNumeroInteiro() + "\n\n" +
                            "Escolha uma opção:\n" +
                            "1 - Definir um novo número\n" +
                            "2 - Somar um número\n" +
                            "3 - Subtrair um número\n" +
                            "4 - Verificar se é primo\n" +
                            "5 - Encontrar o próximo número primo\n" +
                            "6 - Sair"
            );

            if (opcao == null || opcao.equals("6")) {
                JOptionPane.showMessageDialog(null, "Saindo...");
                break;
            }

            switch (opcao) {
                case "1":
                    int novoNumero = Integer.parseInt(JOptionPane.showInputDialog("Digite um novo número inteiro:"));
                    numero = new NumeroInteiro(novoNumero);
                    break;

                case "2":
                    int valorSoma = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para somar:"));
                    numero.soma(valorSoma);
                    break;

                case "3":
                    int valorSubtracao = Integer.parseInt(JOptionPane.showInputDialog("Digite um número para subtrair:"));
                    numero.subtrai(valorSubtracao);
                    break;

                case "4":
                    boolean primo = numero.isPrimo();
                    JOptionPane.showMessageDialog(null, "O número " + numero.getNumeroInteiro() +
                            (primo ? " é primo!" : " não é primo!"));
                    break;

                case "5":
                    int proximoPrimo = numero.getNextPrimo();
                    JOptionPane.showMessageDialog(null, "O próximo número primo é: " + proximoPrimo);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um número de 1 a 6.");
                    break;
            }
        }
    }
}
