package modelo;

public class Apartamento extends Financiamento {

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int prazoMeses = getPrazoFinanciamento() * 12;
        return (getValorImovel() * Math.pow((1 + taxaMensal), prazoMeses) * taxaMensal) / (Math.pow((1 + taxaMensal), prazoMeses) - 1);
    }
}
