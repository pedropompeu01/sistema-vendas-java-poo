package projeto;

import java.io.*;
import java.util.*;

public class ListaProdutos {

    ArrayList<Produto> produtos;

    public ListaProdutos(){

        this.produtos = new ArrayList<>();
    }

    public void imprimirProdutos(){
        int i = 1;
        System.out.println("---LISTA DE PRODUTOS---");
        for(Produto produto : produtos){
            System.out.println("Produto "+i+":");
            System.out.println("Codigo -> "+produto.getCodigoProduto());
            System.out.println("Descricao do produto -> "+produto.getDescricaoProduto());
            System.out.println("Valor da compra -> "+produto.getValorCompra()+" $");
            System.out.println("Valor da venda -> "+produto.getValorVenda()+" $");
            System.out.println("Quantidade em estoque -> "+produto.getQtdEstoque());
            System.out.println("Estqoue minímo ->  "+produto.getEstoqueMin());
            System.out.println("[][][][][][][][][][][][][][][][][][]");
            i++;
        }
        System.out.println("FIM DA LISTA!");
    }
    public Produto verificarProduto(int codigo){
        for (Produto produto : produtos) {
            if(produto.getCodigoProduto() == codigo){
                System.out.println("Produto encontrado com sucesso");
                return produto;
            }
        }
        System.out.println("Prouto não encontrado");
        return null;
    }
    public void listarProdutosAbaixoMinimo() {
        boolean achou = false;
        for (Produto produto : produtos) {
            if (produto.getQtdEstoque() < produto.getEstoqueMin()) {
                System.out.println("Codigo: " + produto.getCodigoProduto() +
                        " | Descricao: " + produto.getDescricaoProduto() +
                        " | Estoque atual: " + produto.getQtdEstoque() +
                        " | Estoque minimo: " + produto.getEstoqueMin());
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum produto abaixo do estoque minimo!");
        }
    }

    public int gerarCodigoProduto() {
        int maior = 0;
        for (Produto produto : produtos) {
            if (produto.getCodigoProduto() > maior) {
                maior = produto.getCodigoProduto();
            }
        }
        return maior + 1;
    }

    public void adicionarProduto(int codigoProduto, String descricaoProduto, double valorCompra, double valorVenda, int qtdEstoque, int estoqueMin){

        //tlvz execao aqui
        if(verificarProduto(codigoProduto) != null){
            System.out.println("Já existe um produto com esse codigo");
            return;
        }

        Produto produto = new Produto(codigoProduto, descricaoProduto, valorCompra, valorVenda, qtdEstoque, estoqueMin);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso");
    }
    public boolean removerProduto(int codigoProduto){
        for (Produto produto : produtos) {
            if(produto.getCodigoProduto() == codigoProduto){
                produtos.remove(produto);
                System.out.println("Produto removido com sucesso");
                return true;
            }
        }
        System.out.println("Nao foi encontrado um produto para remover com esse codigo");
        return false;
    }

    public boolean alterarProduto(int codigoProduto, String descricaoProduto, double valorCompra, double valorVenda,int qtdEstoque, int estoqueMin){
        for (Produto produto : produtos) {
            if(produto.getCodigoProduto() == codigoProduto){
                produto.setDescricaoProduto(descricaoProduto);
                produto.setValorCompra(valorCompra);
                produto.setValorVenda(valorVenda);
                produto.setQtdEstoque(qtdEstoque);
                produto.setEstoqueMin(estoqueMin);
                System.out.println("Produto alterado com sucesso");
                return true;
            }
        }
        System.out.println("Produto nao encontrado!");
        return false;
    }
    public void gravarDados() throws FileNotFoundException {

        FileOutputStream saida = new FileOutputStream("src/projeto/ArquivoProdutos.txt");
        PrintStream printStream = new PrintStream(saida);

        for(Produto produto : produtos){
            printStream.println(produto.getCodigoProduto()+";"+produto.getDescricaoProduto()+";"+produto.getValorCompra()+";"+produto.getValorVenda()+";"+produto.getQtdEstoque()+";"+produto.getEstoqueMin());

        }
    }
    public void puxarDados() throws FileNotFoundException {

        FileInputStream entrada = new FileInputStream("src/projeto/ArquivoProdutos.txt");
        Scanner scanner = new Scanner(entrada);
        while(scanner.hasNextLine()){
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");

            Produto produto = new Produto(Integer.parseInt(dados[0]),dados[1],Double.parseDouble(dados[2]),Double.parseDouble(dados[3]),Integer.parseInt(dados[4]),Integer.parseInt(dados[5]));

            produtos.add(produto);
        }
    }
}
