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

    public double pedirTamanhoAreaConstruida() {
        double tamanho;
        do {
            System.out.print("Digite o tamanho da área construída (em m², positivo): ");
            tamanho = scanner.nextDouble();
            if (tamanho <= 0) {
                System.out.println("Tamanho inválido. Por favor, insira um valor positivo.");
            }
        } while (tamanho <= 0);
        return tamanho;
    }

    public double pedirTamanhoTerreno() {
        double tamanho;
        do {
            System.out.print("Digite o tamanho do terreno (em m², positivo): ");
            tamanho = scanner.nextDouble();
            if (tamanho <= 0) {
                System.out.println("Tamanho inválido. Por favor, insira um valor positivo.");
            }
        } while (tamanho <= 0);
        return tamanho;
    }

    public int pedirNumeroVagasGaragem() {
        int vagas;
        do {
            System.out.print("Digite o número de vagas na garagem (positivo): ");
            vagas = scanner.nextInt();
            if (vagas <= 0) {
                System.out.println("Número de vagas inválido. Por favor, insira um valor positivo.");
            }
        } while (vagas <= 0);
        return vagas;
    }

    public int pedirNumeroAndar() {
        int andar;
        do {
            System.out.print("Digite o número do andar (positivo): ");
            andar = scanner.nextInt();
            if (andar <= 0) {
                System.out.println("Número do andar inválido. Por favor, insira um valor positivo.");
            }
        } while (andar <= 0);
        return andar;
    }

    public String pedirTipoZona() {
        System.out.print("Digite o tipo de zona (residencial ou comercial): ");
        return scanner.next();
    }

    public boolean pedirContinuar() {
        System.out.print("Deseja continuar? (true/false): ");
        return scanner.nextBoolean();
    }
}
