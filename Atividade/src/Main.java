import Individuo.Individuo;
import calculadoraIMC.CalculadoraIMC;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Individuo ind = new Individuo();
        solicitarDados(ind);
        processarDados(ind);
    }

    private static void processarDados(Individuo ind) throws Exception {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC(ind);

        Double peso = Double.valueOf(JOptionPane.showInputDialog("Quantos quilogramas você gostaria de perder"));
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Quantos dias você gostaria de perder esse peso"));
        Double distancia = Double.valueOf(JOptionPane.showInputDialog("Distancia percorrida na corrida"));

        String mensagem = "Nome: " + ind.getNome() +
                "\nTaxa Metabólica: " + String.format("%.2f",calculadoraIMC.getTaxaMetabolica()) +
                "\nGasto Calórico Diário: " + String.format("%.2f",calculadoraIMC.gastoCalorioDiario()) +
                "\nQuantidade de água: " + String.format("%.2f", calculadoraIMC.getQuantidadeIdealDaAgua()) +
                "\nDeficit Calórico: " + String.format("%.2f", calculadoraIMC.getDeficitMetabolico(peso, dia)) +
                "\nCaloria perdida na corrida: " + String.format("%.2f", calculadoraIMC.quantidadeCaloriaCorida(distancia));

        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static void solicitarDados(Individuo individuo) throws Exception {
        individuo.setNome(JOptionPane.showInputDialog("Digite o nome do individuo"));

        individuo.setSexo(Integer.parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "Informe seu sexo",
                null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] {"Masculino", "Feminino"}, null))));
        individuo.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do individuo")));
        individuo.setPeso(Double.valueOf(JOptionPane.showInputDialog("Digite seu peso")));
        individuo.setAltura(Double.valueOf(JOptionPane.showInputDialog("Digite seu altura")));
        individuo.setTaxaAtividadeFisica(Integer.parseInt(String.valueOf(JOptionPane.showOptionDialog(null, "Informe seu nível de atividade física",
                null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] {"Sedentário", "Levemente ativo", "Moderadamente ativo", "Altamente ativo", "Extremamente ativo"}, null))));
    }
}