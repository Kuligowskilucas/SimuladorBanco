package modelo;

public class Apartamento extends Financiamento {
    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int prazoMeses = getPrazoFinanciamento() * 12;
        return (getValorImovel() * Math.pow((1 + taxaMensal), prazoMeses) * taxaMensal) / (Math.pow((1 + taxaMensal), prazoMeses) - 1);
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.printf("Número de Vagas na Garagem: %d%n", numeroVagasGaragem);
        System.out.printf("Número do Andar: %d%n", numeroAndar);
    }
}
