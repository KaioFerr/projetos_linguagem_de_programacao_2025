#include <iostream>
#include <string>
#include <list>
#include <iomanip>
using namespace std;

struct Funcionario{
    string name;
    int departamento;
    double quantidadeDeHorasMes;
    double salarioBase;
    double horaExtra;
    double insalubridade;
    double bonificacao;
    double inss;
    double ir;
    double planoDeSaude = 20;
    double salarioLiquido;
    double valorDaHoraTrabalhada;
    double horasAdicionais;
    double salarioBruto;
};

list<Funcionario> coletandoInformacoes(){
    
    list<Funcionario> listaDeFuncionarios;
    
    for (int i = 0; i < 5; i++) {
        
        Funcionario funcionario;
        
        cout << "FUNCIONARIO " << i+1 << endl;
        
        cout << "Digite o nome do funcionario: " << endl;
        getline(cin, funcionario.name);

        while (true) {
            
            cout << "Digite o departamento do funcionario: " << endl;
            cin >> funcionario.departamento;

            if (funcionario.departamento == 1 || funcionario.departamento == 2){
                break;
            }else cout << "Escolha uma opcao valida (1,2). Tente novamente." << endl;
        }
        
        while (true) {
            
            cout << "Digite a quantidade de horas no mes: " << endl;
            cin >> funcionario.quantidadeDeHorasMes;

            if (funcionario.quantidadeDeHorasMes > 0){
                break;
            }else cout << "Valor invalido, tente novamente." << endl;
        }
        cin.ignore();
        cout << endl;
        
        listaDeFuncionarios.push_back(funcionario);
    }
    
    return listaDeFuncionarios;
}

void calcularSalarioBase(list<Funcionario>& lista){
    
    for (Funcionario& funcionario : lista) {
        
        if (funcionario.departamento == 1){
            funcionario.valorDaHoraTrabalhada = 22;
        }else funcionario.valorDaHoraTrabalhada = 12;
        
        funcionario.salarioBase = funcionario.valorDaHoraTrabalhada * funcionario.quantidadeDeHorasMes;
    }
    
}

void calcularHoraExtra(list<Funcionario>& lista){
    
    for (Funcionario& funcionario : lista) {
        
        funcionario.horasAdicionais = funcionario.quantidadeDeHorasMes - 40;
        
        if (funcionario.horasAdicionais >= 0){
            
            funcionario.horaExtra = funcionario.valorDaHoraTrabalhada * 2 * funcionario.horasAdicionais;
        } else funcionario.horaExtra = 0;
    }
}

void calcularInsalubridade(list<Funcionario>& lista){
    
    for (Funcionario& funcionario : lista){
        
        if (funcionario.departamento == 2){
            funcionario.insalubridade = 0.15;
        }else funcionario.insalubridade = 0;
    }
}

void calcularBonificacao(list<Funcionario>& lista){
    
    for (Funcionario& funcionario : lista){
        
        if (funcionario.quantidadeDeHorasMes > 20 && funcionario.quantidadeDeHorasMes <= 30){
            funcionario.bonificacao = 0.03;
        }else if (funcionario.quantidadeDeHorasMes > 30 && funcionario.quantidadeDeHorasMes <= 40) {
            funcionario.bonificacao = 0.05;
        }else if (funcionario.quantidadeDeHorasMes > 40 && funcionario.departamento == 1){
            funcionario.bonificacao = 0.1;
        }else funcionario.bonificacao = 0;
    }

}

void calcularInssEIR(list<Funcionario>& lista){
    
    for (Funcionario& funcionario : lista){
        
        funcionario.salarioBruto = funcionario.salarioBase + funcionario.horaExtra + funcionario.insalubridade + funcionario.bonificacao;
    
        funcionario.inss = 0.07 * funcionario.salarioBruto;     
        
        funcionario.ir = 0.12 * funcionario.salarioBruto;
    }
    

}

void calcularSalarioLiquido(list<Funcionario>& lista){
    
    for (Funcionario& funcionario : lista) {
        
        funcionario.salarioLiquido = funcionario.salarioBruto - funcionario.inss - funcionario.ir + funcionario.planoDeSaude;
    }
}


void imprimirFolhaDePagamento(const list<Funcionario>& lista) {

    const int larguraColuna = 14;
    
    cout << "| " << setw(larguraColuna) << left << "Nome"
         << "| " << setw(larguraColuna) << "Departamento"
         << "| " << setw(larguraColuna) << "Salario Base"
         << "| " << setw(larguraColuna) << "Hora Extra"
         << "| " << setw(larguraColuna) << "Insalubridade"
         << "| " << setw(larguraColuna) << "Bonificacao"
         << "| " << setw(larguraColuna) << "INSS"
         << "| " << setw(larguraColuna) << "IR"
         << "| " << setw(larguraColuna) << "Plano de Saude"
         << "| " << setw(larguraColuna) << "Salario Liquido"
         << "\n";

    for (const Funcionario& funcionario : lista) {
        cout << "| " << setw(larguraColuna) << left << funcionario.name
             << "| " << setw(larguraColuna) << funcionario.departamento
             << "| " << setw(larguraColuna) << funcionario.salarioBase
             << "| " << setw(larguraColuna) << funcionario.horaExtra
             << "| " << setw(larguraColuna) << funcionario.insalubridade
             << "| " << setw(larguraColuna) << funcionario.bonificacao
             << "| " << setw(larguraColuna) << funcionario.inss
             << "| " << setw(larguraColuna) << funcionario.ir
             << "| " << setw(larguraColuna) << funcionario.planoDeSaude
             << "| " << setw(larguraColuna) << funcionario.salarioLiquido
             << "\n";
    }
}

int main() {
    list<Funcionario> lista = coletandoInformacoes();
    
    calcularSalarioBase(lista);
    calcularHoraExtra(lista);
    calcularInsalubridade(lista);
    calcularBonificacao(lista);
    calcularInssEIR(lista);
    calcularSalarioLiquido(lista);
    
    imprimirFolhaDePagamento(lista);
    
    return 0;
}
