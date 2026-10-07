package projeto;

import java.io.*;
import java.util.*;
public class ListaVendas {

    ArrayList<Venda> vendas;

    public ListaVendas() {
        this.vendas = new ArrayList<>();
    }

    public int gerarNumeroVenda(){
        if(this.vendas.isEmpty()){
            return 1;
        }
        return vendas.get(vendas.size() - 1).getNumeroDaVenda() +1;
    }

    public void addVenda(String dataVenda, String tipoVenda, int codigoCliente, String dataVencimento) {

        int numeroVenda = gerarNumeroVenda();

        Venda venda = new Venda(numeroVenda, dataVenda, tipoVenda, codigoCliente, dataVencimento);

        vendas.add(venda);
    }
    public boolean verificarVenda(int numVenda){

        for(Venda venda: vendas){
            if (venda.getNumeroDaVenda() == numVenda){
                System.out.println("Venda existente");
                return true;
            }
        }
        System.out.println("Venda nao existente");
        return false;
    }
    public void imprimirVendas(){

        int i =1;
        System.out.println("---LISTAR DE VENDAS---");
        for(Venda venda: vendas){
            System.out.println("Venda "+i+":");
            System.out.println("Numero da Venda: "+venda.getNumeroDaVenda());
            System.out.println("Data da Venda: "+venda.getDataVenda());
            System.out.println("Tipo da Venda: "+venda.getTipoVenda());
            System.out.println("Codigo do Cliente que realizou a venda: "+venda.getCodigoCliente());
            System.out.println("Data Vencimento: "+venda.getDataVencimento());
            System.out.println("[][][][][][][][][][][][][][][][][][]");
            i++;
        }
        System.out.println("---FIM DA LISTA DE VENDAS---");
    }
    public int getUltimoNumeroVenda() {
        return vendas.get(vendas.size() - 1).getNumeroDaVenda();
    }
    public void consultarVendasPorPeriodo(String dataInicial, String dataFinal) {
        try {
            java.time.format.DateTimeFormatter formatter =
                    java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            java.time.LocalDate inicio = java.time.LocalDate.parse(dataInicial, formatter);
            java.time.LocalDate fim = java.time.LocalDate.parse(dataFinal, formatter);

            int contador = 0;
            for (Venda venda : vendas) {
                java.time.LocalDate dataVenda =
                        java.time.LocalDate.parse(venda.getDataVenda(), formatter);
                if (!dataVenda.isBefore(inicio) && !dataVenda.isAfter(fim)) {
                    System.out.println("Venda numero: " + venda.getNumeroDaVenda() +
                            " | Data: " + venda.getDataVenda() +
                            " | Tipo: " + venda.getTipoVenda());
                    contador++;
                }
            }
            if (contador == 0) {
                System.out.println("Nenhuma venda encontrada nesse periodo!");
            } else {
                System.out.println("Total de vendas no periodo: " + contador);
            }
        } catch (Exception e) {
            System.out.println("Data invalida! Use o formato dd/MM/yyyy");
        }
    }

    public void gravarDados() throws FileNotFoundException {

        FileOutputStream saida = new FileOutputStream("src/projeto/ArquivoVendas.txt");
        PrintStream printStream = new PrintStream(saida);

        for(Venda venda: vendas){
            printStream.println(venda.getNumeroDaVenda()+";"+venda.getDataVenda()+";"+venda.getTipoVenda()+";"+venda.getCodigoCliente()+";"+venda.getDataVencimento());
        }
    }
    public void puxarDados() throws FileNotFoundException {

        FileInputStream entrada = new FileInputStream("src/projeto/ArquivoVendas.txt");

        Scanner scanner = new Scanner(entrada);
        while(scanner.hasNextLine()){
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            Venda venda = new Venda(Integer.parseInt(dados[0]),dados[1],dados[2],Integer.parseInt(dados[3]),dados[4]);
            vendas.add(venda);
        }
    }
}
