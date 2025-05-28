import departamento.Departamento;
import funcionario.Comissionado;
import funcionario.Funcionario;
import funcionario.Horista;
import funcionario.Mensalista;
import tabela.Tabela;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        ArrayList<Departamento> listaDeDepartamentos = new ArrayList<>();

        while (true) {
            int opcao = menu();

            switch (opcao) {
                case 1:
                    cadastroDepartamento(listaDeDepartamentos);
                    break;
                case 2:
                    cadastroFuncionario(listaDeDepartamentos);
                    break;
                case 3:
                    if (listaDeDepartamentos.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Não existe Departamento para ser escolhido");
                        break;
                    }
                    listarSalarioFuncionarioPorDepartamento(listaDeDepartamentos
                            .get(departamentoInput(listaDeDepartamentos)));
                    break;
                case 4:
                    if (listaDeDepartamentos.isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Não existe Departamento para ser escolhido");
                        break;
                    }
                    listarTotalSalarioDoDepartamento(listaDeDepartamentos
                            .get(departamentoInput(listaDeDepartamentos)));
                    break;
                case 5:
                    listarSalariosDeTodosDepartamentos(listaDeDepartamentos);
                    break;
                case 6:
                    exibirSalarioDeCadaDepartamento(listaDeDepartamentos);
                    break;
                case 7:
                    exibirTotalGeralSalario(listaDeDepartamentos);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static int menu() throws IllegalArgumentException{
        String mensagem = """
                1 - Cadastro de Departamento
                2 - Cadastro de Funcionário
                3 - Listar salário de um Departamento
                4 - Listar o total de salário do departamentos
                5 - Listar os salários de todos os Departamentos
                6 - Exibir o total de salários de cada Departamento
                7 - Exibir total geral de salários
                8 - Sair
                """;
        return Integer.parseInt(JOptionPane.showInputDialog(null, mensagem));
    }

    private static void cadastroDepartamento(
            ArrayList<Departamento> listaDeDepartamentos
    ) {
        try{
            Departamento departamento = new Departamento();
            departamento.setCodigoDepartamento(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do Departamento")));
            departamento.setDescricao(JOptionPane.showInputDialog(null, "Digite o nome do departamento"));
            departamento.setValorHoraTrabalhada(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da hora trabalhada")));
            listaDeDepartamentos.add(departamento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void cadastroFuncionario(
            ArrayList<Departamento> listaDeDepartamentos
    )  {
        try {
            if (listaDeDepartamentos.isEmpty()){
                throw new Exception("Não existe Departamento para registrar Funcionário!");
            }

            int departamentoInput = departamentoInput(listaDeDepartamentos);

            int tipoDeFuncionario = Integer.parseInt(String.valueOf(JOptionPane.showOptionDialog(
                    null,
                    "Qual tipo de Funcionário você gostaria de cadastrar?",
                    null, JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[] {"Mensalista", "Horista", "Comissionado"},
                    null)));

            switch (tipoDeFuncionario) {
                case 0:
                    cadastroMensalista(listaDeDepartamentos.get(departamentoInput));
                    break;
                case 1:
                    cadastroHorista(listaDeDepartamentos.get(departamentoInput));
                    break;
                case 2:
                    cadastroComissionado(listaDeDepartamentos.get(departamentoInput));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            };
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private static int departamentoInput(ArrayList<Departamento> listaDeDepartamentos) {
        return JOptionPane.showOptionDialog(
                null,
                "Selecione um Departamento",
                "Selecionar Departamento",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                listaDeDepartamentosString(listaDeDepartamentos),
                null
        );
    }

    private static String[] listaDeDepartamentosString(ArrayList<Departamento> listaDeDepartamentos) {
        String[] opcoes = new String[listaDeDepartamentos.size()];

        for (int i = 0; i < listaDeDepartamentos.size(); i++) {
            opcoes[i] = listaDeDepartamentos.get(i).getDescricao();
        }

        return opcoes;
    }


    private static void cadastroComissionado(
            Departamento departamento
    ) {
        try{
            Comissionado comissionado = new Comissionado();
            comissionado.setDepartamento(departamento);
            comissionado.setNome(JOptionPane.showInputDialog(null, "Digite o nome do Funcionário"));
            comissionado.setCidade(JOptionPane.showInputDialog(null, "Digite o nome da cidade"));
            comissionado.setEstado(JOptionPane.showInputDialog(null, "Digite o nome do estado"));
            comissionado.setQtdHorasTrabalhada(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a quantidade de horas trabalhadas")));
            comissionado.setValorDasVendas(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor das vendas")));
            comissionado.setComissaoPercentual(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o percentual da comissão")));
            departamento.adicionarFuncionario(comissionado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void cadastroHorista(
            Departamento departamento
    ) {
        try{
            Horista horista = new Horista();
            horista.setDepartamento(departamento);
            horista.setNome(JOptionPane.showInputDialog(null, "Digite o nome do Funcionário"));
            horista.setCidade(JOptionPane.showInputDialog(null, "Digite o nome da cidade"));
            horista.setEstado(JOptionPane.showInputDialog(null, "Digite o nome do estado"));
            horista.setQtdHorasTrabalhada(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a quantidade de horas trabalhadas")));
            departamento.adicionarFuncionario(horista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void cadastroMensalista(
            Departamento departamento
    ) {
        try{
            Mensalista mensalista = new Mensalista();
            mensalista.setDepartamento(departamento);
            mensalista.setNome(JOptionPane.showInputDialog(null, "Digite o nome do Funcionário"));
            mensalista.setCidade(JOptionPane.showInputDialog(null, "Digite o nome da cidade"));
            mensalista.setEstado(JOptionPane.showInputDialog(null, "Digite o nome do estado"));
            mensalista.setQtdHorasTrabalhada(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a quantidade de horas trabalhadas")));
            mensalista.setSalario(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o salário do Funcionário")));
            departamento.adicionarFuncionario(mensalista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void listarSalarioFuncionarioPorDepartamento(
            Departamento departamento
    ) {
        try{
            ArrayList<Funcionario> listaDeFuncionarios = departamento.getListaFuncionario();

            String[] colunas = {
                    "Funcionário",
                    "Salario",
                    "Departamento",
                    "Código do Departamento"
            };

            Object[][] dados = new Object[listaDeFuncionarios.size()][4];
            for (int i = 0; i < listaDeFuncionarios.size(); i++) {
                dados[i][0] = departamento.getListaFuncionario().get(i).getNome();
                dados[i][1] = departamento.getListaFuncionario().get(i).getSalario();
                dados[i][2] = departamento.getDescricao();
                dados[i][3] = departamento.getCodigoDepartamento();
            }

            Tabela tabela = new Tabela(colunas, dados);
            tabela.mostrarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void listarTotalSalarioDoDepartamento(
            Departamento departamento
    ) {
        try{
            String[] colunas = {
                    "Departamento",
                    "Total Salário"
            };

            Object[][] dados = new Object[1][2];
            dados[0][0] = departamento.getDescricao();
            dados[0][1] = departamento.getTotalSalario();

            Tabela tabela = new Tabela(colunas, dados);
            tabela.mostrarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void listarSalariosDeTodosDepartamentos(
            ArrayList<Departamento> listaDeDepartamentos
    ) {
        try{
            if (listaDeDepartamentos.isEmpty()){
                throw new Exception("Não existe Departamento para ser listado!");
            }

            ArrayList<Funcionario> listaDeFuncionarios = new ArrayList<>();

            listaDeDepartamentos.forEach(departamento -> {
                listaDeFuncionarios.addAll(departamento.getListaFuncionario());
            });

            String[] colunas = {
                    "Funcionário",
                    "Salario",
                    "Departamento",
                    "Código do Departamento"
            };

            Object[][] dados = new Object[listaDeFuncionarios.size()][4];

            int index = 0;
            for (Departamento departamento : listaDeDepartamentos) {
                for (Funcionario funcionario : departamento.getListaFuncionario()) {
                    dados[index][0] = funcionario.getNome();
                    dados[index][1] = funcionario.getSalario();
                    dados[index][2] = departamento.getDescricao();
                    dados[index][3] = departamento.getCodigoDepartamento();
                    index++;
                }
            }

            Tabela tabela = new Tabela(colunas, dados);
            tabela.mostrarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void exibirSalarioDeCadaDepartamento(
            ArrayList<Departamento> listaDeDepartamentos
    ) {
        try {

            if (listaDeDepartamentos.isEmpty()){
                throw new Exception("Não existe Departamento para ser listado!");
            }

            String[] colunas = {
                    "Departamento",
                    "Total Salário"
            };

            Object[][] dados = new Object[listaDeDepartamentos.size()][2];
            for (int i = 0; i < listaDeDepartamentos.size(); i++) {
                dados[i][0] = listaDeDepartamentos.get(i).getDescricao();
                dados[i][1] = listaDeDepartamentos.get(i).getTotalSalario();
            }

            Tabela tabela = new Tabela(colunas, dados);
            tabela.mostrarTabela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void exibirTotalGeralSalario(
            ArrayList<Departamento> listaDeDepartamentos
    ) {
        try{
            if (listaDeDepartamentos.isEmpty()){
                throw new Exception("Não existe Departamento para ser listado!");
            }

            double total = 0.0;
            for (Departamento departamento : listaDeDepartamentos) {
                total += departamento.getTotalSalario();
            }

            JOptionPane.showMessageDialog(null, "Total de Salário de Todos os setores:\nR$ " + total);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
