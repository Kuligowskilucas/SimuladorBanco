# Sistema de Financiamento Imobiliário

Este projeto é um sistema de financiamento imobiliário que calcula o pagamento mensal e o total a ser pago com base em diferentes tipos de financiamentos: Casa, Apartamento e Terreno. O sistema permite a entrada de dados pelo usuário e adiciona financiamentos diretamente no código para facilitar os testes.

## Estrutura do Projeto

O projeto está dividido nas seguintes partes:

- `main`: Contém a classe `Main` que executa o programa.
- `modelo`: Contém a classe abstrata `Financiamento` e suas subclasses `Casa`, `Apartamento` e `Terreno`.
- `util`: Contém a classe `InterfaceUsuario` para interação com o usuário.

## Funcionalidades

- **Casa**: Adiciona um valor fixo de R$ 80,00 por parcela após o cálculo dos juros.
- **Apartamento**: Utiliza o sistema de amortização PRICE para calcular o pagamento mensal.
- **Terreno**: Adiciona um acréscimo de 2% sobre o valor da parcela calculada com os juros.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
2. Abra o projeto no IntelliJ:
File > Open > Selecione o diretório do projeto.
3. Compile e execute o projeto:
Vá para Run > Run 'Main'.

Exemplo de Uso
Ao executar o programa, o usuário será solicitado a inserir os dados do financiamento (valor do imóvel, prazo de financiamento e taxa de juros anual). Em seguida, o programa calculará e exibirá o pagamento mensal e o total a ser pago para cada tipo de financiamento.

Estrutura das Classes
Main
Executa o programa e lida com a interação do usuário.
Adiciona financiamentos diretamente no código para facilitar os testes.
Financiamento (abstrata)
Define a estrutura básica de um financiamento.
Métodos abstratos para cálculo do pagamento mensal e total.
Casa, Apartamento, Terreno (subclasses de Financiamento)
Implementam regras específicas para cada tipo de financiamento.
InterfaceUsuario
Lida com a entrada de dados do usuário e garante que os valores sejam válidos.
