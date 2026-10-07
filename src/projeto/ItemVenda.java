package projeto;

public class ItemVenda {

    private int numeroVenda; //pegar de outra classe
    private int codigoProduto; // pegar de outra classe
    private int quantidadeVendida;
    private double valorVendaProduto; //pegar de outra classe

    public ItemVenda(int numeroVenda, int codigoProduto, int quantidadeVendida, double valorVendaProduto) {
        this.numeroVenda = numeroVenda;
        this.codigoProduto = codigoProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.valorVendaProduto = valorVendaProduto;
    }

    public int getNumeroVenda() {
        return numeroVenda;
    }

    public void setNumeroVenda(int numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public double getValorVendaProduto() {
        return valorVendaProduto;
    }

    public void setValorVendaProduto(double valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }

}
