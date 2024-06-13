package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        double valor;
        do {
            System.out.print("Digite o valor do imóvel (positivo): ");
            valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Valor inválido. Por favor, insira um valor positivo.");
            }
        } while (valor <= 0);
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento em anos (positivo): ");
            prazo = scanner.nextInt();
            if (prazo <= 0) {
                System.out.println("Prazo inválido. Por favor, insira um prazo positivo.");
            }
        } while (prazo <= 0);
        return prazo;
    }

    public double pedirTaxaJurosAnual() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (positiva): ");
            taxa = scanner.nextDouble();
            if (taxa <= 0) {
                System.out.println("Taxa inválida. Por favor, insira uma taxa positiva.");
            }
        } while (taxa <= 0);
        return taxa;
    }

    public boolean pedirContinuar() {
        return scanner.nextBoolean();
    }
}
