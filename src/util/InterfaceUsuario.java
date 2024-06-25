package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        double valor = 0;
        while (true) {
            try {
                System.out.print("Digite o valor do imóvel (positivo): ");
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    throw new IllegalArgumentException("Valor inválido. Por favor, insira um valor positivo.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        while (true) {
            try {
                System.out.print("Digite o prazo do financiamento em anos (positivo): ");
                prazo = scanner.nextInt();
                if (prazo <= 0) {
                    throw new IllegalArgumentException("Prazo inválido. Por favor, insira um prazo positivo.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return prazo;
    }

    public double pedirTaxaJurosAnual() {
        double taxa = 0;
        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual (positiva): ");
                taxa = scanner.nextDouble();
                if (taxa <= 0) {
                    throw new IllegalArgumentException("Taxa inválida. Por favor, insira uma taxa positiva.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return taxa;
    }

    public double pedirTamanhoAreaConstruida() {
        double tamanho = 0;
        while (true) {
            try {
                System.out.print("Digite o tamanho da área construída (em m², positivo): ");
                tamanho = scanner.nextDouble();
                if (tamanho <= 0) {
                    throw new IllegalArgumentException("Tamanho inválido. Por favor, insira um valor positivo.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tamanho;
    }

    public double pedirTamanhoTerreno() {
        double tamanho = 0;
        while (true) {
            try {
                System.out.print("Digite o tamanho do terreno (em m², positivo): ");
                tamanho = scanner.nextDouble();
                if (tamanho <= 0) {
                    throw new IllegalArgumentException("Tamanho inválido. Por favor, insira um valor positivo.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tamanho;
    }

    public int pedirNumeroVagasGaragem() {
        int vagas = 0;
        while (true) {
            try {
                System.out.print("Digite o número de vagas na garagem (positivo): ");
                vagas = scanner.nextInt();
                if (vagas <= 0) {
                    throw new IllegalArgumentException("Número de vagas inválido. Por favor, insira um valor positivo.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return vagas;
    }

    public int pedirNumeroAndar() {
        int andar = 0;
        while (true) {
            try {
                System.out.print("Digite o número do andar (positivo): ");
                andar = scanner.nextInt();
                if (andar <= 0) {
                    throw new IllegalArgumentException("Número do andar inválido. Por favor, insira um valor positivo.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return andar;
    }

    public String pedirTipoZona() {
        System.out.print("Digite o tipo de zona (residencial ou comercial): ");
        return scanner.next();
    }

    public boolean pedirContinuar() {
        boolean continuar = false;
        while (true) {
            try {
                System.out.print("Deseja continuar? (true/false): ");
                continuar = scanner.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira true ou false.");
                scanner.next();
            }
        }
        return continuar;
    }
}
