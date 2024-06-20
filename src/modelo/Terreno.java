package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensalBase = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12 / 100));
        return pagamentoMensalBase * 1.02;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.printf("Tipo de Zona: %s%n", tipoZona);
    }
}
