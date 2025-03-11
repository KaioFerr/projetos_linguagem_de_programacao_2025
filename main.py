from prettytable import PrettyTable

def coletar_informacoes():
    lista_de_funcionarios = []
    for i in range(5):

        print(f"\nFUNCIONÁRIO {i+1}")

        nome = input("Digite o nome do funcionário: ")
        while True:
            try:
                departamento = int(input("Digite o departamento do funcionário: "))
                if departamento in [1,2]:
                    break
                else:
                    raise ValueError()

            except ValueError:
                print("Erro: O departamento deve ser um número inteiro (1, 2). Tente novamente.")

        while True:
            try:
                qtd_horas_mes = float(input("Digite a quantidade de horas trabalhadas no mês: "))
                break
            except ValueError:
                print("Erro: A quantidade de horas deve ser um número. Tente novamente.")

        funcionario = {"nome": nome, "departamento": departamento, "qtd_horas_mes": qtd_horas_mes}
        lista_de_funcionarios.append(funcionario)

    return lista_de_funcionarios
    

def calcular_salario_base(lista_de_funcionarios):

    for funcionario in lista_de_funcionarios:

        if funcionario["departamento"] == 1:
            funcionario["valor_hora_trabalhada"] = 22
            funcionario["salario_base"] = funcionario["qtd_horas_mes"] * funcionario["valor_hora_trabalhada"]

        else:
            funcionario["valor_hora_trabalhada"] = 12
            funcionario["salario_base"] = funcionario["qtd_horas_mes"] * funcionario["valor_hora_trabalhada"]


def calcular_horas_extras(lista_de_funcionarios):
    
    for funcionario in lista_de_funcionarios:

        funcionario["horas_adicionais"] = funcionario["qtd_horas_mes"] - 40

        if funcionario["horas_adicionais"] > 0:
            funcionario["horas_extras"] = funcionario["valor_hora_trabalhada"] * 2 * funcionario["horas_adicionais"]

        else:
            funcionario["horas_extras"] = 0

def calcular_insalubridade(lista_de_funcionarios):

    for funcionario in lista_de_funcionarios:

        if funcionario["departamento"] == 2:
            funcionario["insalubridade"] = 0.15
        else:
            funcionario["insalubridade"] = 0
    
def calcular_bonificacao(lista_de_funcionario):

    for funcionario in lista_de_funcionario:

        if 20 < funcionario["qtd_horas_mes"] <= 30:
            funcionario["bonificacao"] = 0.03 * funcionario["salario_base"]

        elif 30 < funcionario["qtd_horas_mes"] <= 40:
            funcionario["bonificacao"] = 0.05 * funcionario["salario_base"]

        elif funcionario["qtd_horas_mes"] > 40 and funcionario["departamento"] == 1:
            funcionario["bonificacao"] = 0.1 * funcionario["salario_base"]

        else:
            funcionario["bonificacao"] = 0

    
def calcular_INSS(lista_de_funcionarios):

    for funcionario in lista_de_funcionarios:
        
        funcionario["salario_bruto"] = funcionario["salario_base"] + funcionario["horas_extras"] + funcionario["insalubridade"] + funcionario["bonificacao"]
        funcionario["INSS"] = 0.07 * funcionario["salario_bruto"]

def calcular_imposto_de_renda(lista_de_funcionarios):

    for funcionario in lista_de_funcionarios:

        funcionario["imposto_de_renda"] = 0.12 * funcionario["salario_bruto"]

def plano_de_saude(lista_de_funcionarios):

    for funcionario in lista_de_funcionarios:

        funcionario["plano_de_saude"] = 20

def calcular_salario_liquido(lista_de_funcionarios):

    for funcionario in lista_de_funcionarios:

        funcionario["salario_liquido"] = funcionario["salario_bruto"] - funcionario["INSS"] - funcionario["imposto_de_renda"] - funcionario["plano_de_saude"]



def exibir_tabela(lista_de_funcionarios):
    tabela = PrettyTable()

    tabela.field_names = ["Nome", "Departamento", "Horas Trabalhadas", "Salário Base", "Horas Extras", 
                           "Insalubridade", "Bonificação", "Salário Bruto", "INSS", "Imposto de Renda", 
                           "Plano de Saúde", "Salário Líquido"]

    for funcionario in lista_de_funcionarios:
        tabela.add_row([
            funcionario["nome"],
            funcionario["departamento"],
            funcionario["qtd_horas_mes"],
            f"R$ {funcionario['salario_base']:.2f}",
            f"R$ {funcionario['horas_extras']:.2f}",
            f"R$ {funcionario['insalubridade']:.2f}",
            f"R$ {funcionario['bonificacao']:.2f}",
            f"R$ {funcionario['salario_bruto']:.2f}",
            f"R$ {funcionario['INSS']:.2f}",
            f"R$ {funcionario['imposto_de_renda']:.2f}",
            f"R$ {funcionario['plano_de_saude']:.2f}",
            f"R$ {funcionario['salario_liquido']:.2f}"
        ])

    print(tabela)
  

def testar_programa():
    lista_de_funcionarios = [
        {"nome": "Funcionário 1", "departamento": 1, "qtd_horas_mes": 42},
        {"nome": "Funcionário 2", "departamento": 2, "qtd_horas_mes": 38},
        {"nome": "Funcionário 3", "departamento": 1, "qtd_horas_mes": 30},
        {"nome": "Funcionário 4", "departamento": 2, "qtd_horas_mes": 50},
        {"nome": "Funcionário 5", "departamento": 1, "qtd_horas_mes": 20}
    ]
    
    calcular_salario_base(lista_de_funcionarios)
    calcular_horas_extras(lista_de_funcionarios)
    calcular_insalubridade(lista_de_funcionarios)
    calcular_bonificacao(lista_de_funcionarios)
    calcular_INSS(lista_de_funcionarios)
    calcular_imposto_de_renda(lista_de_funcionarios)
    plano_de_saude(lista_de_funcionarios)
    calcular_salario_liquido(lista_de_funcionarios)
    
    exibir_tabela(lista_de_funcionarios)
  

def executar_programa():
    lista_de_funcionarios = coletar_informacoes()    
    calcular_salario_base(lista_de_funcionarios)
    calcular_horas_extras(lista_de_funcionarios)
    calcular_insalubridade(lista_de_funcionarios)
    calcular_bonificacao(lista_de_funcionarios)
    calcular_INSS(lista_de_funcionarios)
    calcular_imposto_de_renda(lista_de_funcionarios)
    plano_de_saude(lista_de_funcionarios)
    calcular_salario_liquido(lista_de_funcionarios)
    
    exibir_tabela(lista_de_funcionarios)


#pode ser usado tanto o testar programa quanto o executar o programa, tó tirar o comentário "#"
#testar_programa()
#executar_programa()
