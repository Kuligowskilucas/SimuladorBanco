package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public void mostrarDadosFinanciamento() {
        System.out.printf("Valor do Imóvel: %.2f%n", valorImovel);
        System.out.printf("Prazo do Financiamento: %d anos%n", prazoFinanciamento);
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", taxaJurosAnual);
        System.out.printf("Pagamento Mensal: %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total do Pagamento: %.2f%n", calcularTotalPagamento());
    }
}
