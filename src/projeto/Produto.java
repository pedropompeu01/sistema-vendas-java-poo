package projeto;

public class Produto {

    private int codigoProduto;
    private String descricaoProduto;
    private double valorCompra;
    private double valorVenda;
    private int qtdEstoque;
    private int estoqueMin;

    public Produto(int codigoProduto, String descricaoProduto, double valorCompra, double valorVenda, int qtdEstoque, int estoqueMin) {
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.qtdEstoque = qtdEstoque;
        this.estoqueMin = estoqueMin;
    }
    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}
