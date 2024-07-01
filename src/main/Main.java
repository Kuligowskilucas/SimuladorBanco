package main;

import modelo.*;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> financiamentos = new ArrayList<>();
    
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();
    
        double tamanhoAreaConstruida = interfaceUsuario.pedirTamanhoAreaConstruida();
        double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
        Casa financiamentoUsuarioCasa = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno);
        financiamentos.add(financiamentoUsuarioCasa);
    
        int numeroVagasGaragem = interfaceUsuario.pedirNumeroVagasGaragem();
        int numeroAndar = interfaceUsuario.pedirNumeroAndar();
        Apartamento financiamentoUsuarioApartamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar);
        financiamentos.add(financiamentoUsuarioApartamento);
    
        String tipoZona = interfaceUsuario.pedirTipoZona();
        Terreno financiamentoUsuarioTerreno = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
        financiamentos.add(financiamentoUsuarioTerreno);
    
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
    
        try {
            financiamentoUsuarioCasa.aplicarDesconto(200);
        } catch (DescontoMaiorDoQueJurosException e) {
            System.out.println(e.getMessage());
        }
    
        salvarFinanciamentosEmArquivo(financiamentos, "financiamentos.txt");
    
        List<Financiamento> financiamentosLidos = lerFinanciamentosDoArquivo("financiamentos.txt");
        System.out.println("\nFinanciamentos lidos do arquivo de texto:");
        for (Financiamento financiamento : financiamentosLidos) {
            financiamento.mostrarDadosFinanciamento();
        }
    
        serializarFinanciamentos(financiamentos, "financiamentos.ser");
    
        List<Financiamento> financiamentosDesserializados = desserializarFinanciamentos("financiamentos.ser");
        System.out.println("\nFinanciamentos desserializados:");
        for (Financiamento financiamento : financiamentosDesserializados) {
            financiamento.mostrarDadosFinanciamento();
        }
    }
    

    private static void salvarFinanciamentosEmArquivo(List<Financiamento> financiamentos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Financiamento financiamento : financiamentos) {
                writer.write(financiamento.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Financiamento> lerFinanciamentosDoArquivo(String nomeArquivo) {
        List<Financiamento> financiamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Financiamento financiamento = processarLinha(linha);
                financiamentos.add(financiamento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return financiamentos;
    }

    private static Financiamento processarLinha(String linha) {
        String[] dados = linha.split(",");
        String tipo = dados[0];
        double valorImovel = Double.parseDouble(dados[1]);
        int prazoFinanciamento = Integer.parseInt(dados[2]);
        double taxaJurosAnual = Double.parseDouble(dados[3]);
    
        switch (tipo) {
            case "Casa":
                double tamanhoAreaConstruida = Double.parseDouble(dados[4]);
                double tamanhoTerreno = Double.parseDouble(dados[5]);
                return new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, tamanhoAreaConstruida, tamanhoTerreno);
            case "Apartamento":
                int numeroVagasGaragem = Integer.parseInt(dados[4]);
                int numeroAndar = Integer.parseInt(dados[5]);
                return new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar);
            case "Terreno":
                String tipoZona = dados[4];
                return new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
            default:
                throw new IllegalArgumentException("Tipo de financiamento desconhecido: " + tipo);
        }
    }
    

    private static void serializarFinanciamentos(List<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(financiamentos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Financiamento> desserializarFinanciamentos(String nomeArquivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (List<Financiamento>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
