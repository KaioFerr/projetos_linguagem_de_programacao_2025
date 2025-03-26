package triangulo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Triangle newTriangle = new Triangle();

        while (true){

           int option = JOptionPane.showConfirmDialog(null, "Bem-vindo ao programa!\nPressione OK para continuar.", "Início", JOptionPane.OK_CANCEL_OPTION);

           if(option == JOptionPane.CANCEL_OPTION){
               break;
           }else {
               while (true){

                   try {
                       newTriangle.primeiroLado = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do lado 01"));
                       newTriangle.segundoLado = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do lado 02"));
                       newTriangle.terceiroLado = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do lado 03"));
                       JOptionPane.showMessageDialog(null, newTriangle.getTriangleType());
                       break;
                   }catch (NumberFormatException e){
                       JOptionPane.showMessageDialog(null, "Entrada inválida! Tente novamente");
                   }
               }
           }
        }
    }
}