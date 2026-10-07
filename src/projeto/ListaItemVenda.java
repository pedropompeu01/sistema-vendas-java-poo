package projeto;

import java.io.*;
import java.util.*;

public class ListaItemVenda {

    ArrayList<ItemVenda> itensvenda;

    public ListaItemVenda() {
         itensvenda= new ArrayList<>();
    }

    public boolean addItemVenda(int numeroVenda, int codigoProduto, int quantidadeVendida, ListaProdutos listaProdutos) {

        Produto produto = listaProdutos.verificarProduto(codigoProduto);

        if (produto == null) {
            System.out.println("Produto não encontrado!");
            return false;
        }

        if (produto.getQtdEstoque() < quantidadeVendida) {
            System.out.println("Estoque insuficiente!");
            return false;
        }

        produto.setQtdEstoque(produto.getQtdEstoque() - quantidadeVendida);

        ItemVenda item = new ItemVenda(numeroVenda, codigoProduto, quantidadeVendida, produto.getValorVenda());

        itensvenda.add(item);

        System.out.println("Item adicionado com sucesso!");
        return true;
    }
    public boolean produtoTemVenda(int codigoProduto) {
        for (ItemVenda item : itensvenda) {
            if (item.getCodigoProduto() == codigoProduto) {
                return true;
            }
        }
        return false;
    }
    public void gravarDados() throws FileNotFoundException {
        FileOutputStream saida = new FileOutputStream("src/projeto/ArquivoItensVendas.txt");
        PrintStream printStream = new PrintStream(saida);

        for (ItemVenda item : itensvenda) {
            printStream.println(item.getNumeroVenda()+";"+item.getCodigoProduto()+";"+item.getQuantidadeVendida()+";"+item.getValorVendaProduto());
        }
    }

    public void puxarDados() throws FileNotFoundException {
        FileInputStream entrada = new FileInputStream("src/projeto/ArquivoItensVendas.txt");
        Scanner scanner = new Scanner(entrada);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            ItemVenda item = new ItemVenda(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Double.parseDouble(dados[3]));
            itensvenda.add(item);
        }
    }
}
