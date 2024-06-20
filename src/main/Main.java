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

        // Exemplo de cadastro de uma Casa
        double tamanhoAreaConstruida = interfaceUsuario.pedirTamanhoAreaConstruida();
        double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
        Casa financiamentoUsuarioCasa = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno);
        financiamentos.add(financiamentoUsuarioCasa);

        // Exemplo de cadastro de um Apartamento
        int numeroVagasGaragem = interfaceUsuario.pedirNumeroVagasGaragem();
        int numeroAndar = interfaceUsuario.pedirNumeroAndar();
        Apartamento financiamentoUsuarioApartamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar);
        financiamentos.add(financiamentoUsuarioApartamento);

        // Exemplo de cadastro de um Terreno
        String tipoZona = interfaceUsuario.pedirTipoZona();
        Terreno financiamentoUsuarioTerreno = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
        financiamentos.add(financiamentoUsuarioTerreno);

        // Exemplo de financiamentos pré-cadastrados
        financiamentos.add(new Casa(500000, 10, 10, 200, 500));
        financiamentos.add(new Apartamento(300000, 15, 8, 2, 5));
        financiamentos.add(new Apartamento(200000, 20, 7, 1, 10));
        financiamentos.add(new Terreno(100000, 5, 12, "Residencial"));

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
