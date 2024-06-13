package main;

import modelo.*;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> financiamentos = new ArrayList<>();

        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();
        Casa financiamentoUsuario = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual);
        financiamentos.add(financiamentoUsuario);

        financiamentos.add(new Casa(500000, 10, 10));
        financiamentos.add(new Apartamento(300000, 15, 8));
        financiamentos.add(new Apartamento(200000, 20, 7));
        financiamentos.add(new Terreno(100000, 5, 12));

        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        for (Financiamento financiamento : financiamentos) {
            totalValorImoveis += financiamento.getValorImovel();
            totalValorFinanciamentos += financiamento.calcularTotalPagamento();
        }

        System.out.printf("Total de todos os imóveis: %.2f%n", totalValorImoveis);
        System.out.printf("Total de todos os financiamentos: %.2f%n", totalValorFinanciamentos);
    }
}
