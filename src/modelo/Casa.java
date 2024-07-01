package modelo;

public class Casa extends Financiamento {
    private double tamanhoAreaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamanhoAreaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamanhoAreaConstruida = tamanhoAreaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int prazoMeses = getPrazoFinanciamento() * 12;
        return (getValorImovel() * Math.pow((1 + taxaMensal), prazoMeses) * taxaMensal) / (Math.pow((1 + taxaMensal), prazoMeses) - 1) + 80;
    }

    public double getTamanhoAreaConstruida() {
        return tamanhoAreaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public void aplicarDesconto(double desconto) throws DescontoMaiorDoQueJurosException {
        double jurosMensal = calcularPagamentoMensal() - (getValorImovel() / (getPrazoFinanciamento() * 12));
        if (desconto > jurosMensal) {
            throw new DescontoMaiorDoQueJurosException("O valor do desconto não pode ser maior do que o valor dos juros.");
        }
        
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.printf("Tamanho da Área Construída: %.2f m²%n", tamanhoAreaConstruida);
        System.out.printf("Tamanho do Terreno: %.2f m²%n", tamanhoTerreno);
    }

    @Override
    public String toString() {
        return "Casa," + getValorImovel() + "," + getPrazoFinanciamento() + "," + getTaxaJurosAnual() + "," + tamanhoAreaConstruida + "," + tamanhoTerreno;
    }
}
