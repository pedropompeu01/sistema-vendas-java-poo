package projeto;

public class Venda {

    private int numeroDaVenda;
    private String dataVenda;
    private String tipoVenda; // a prazo ou a vista
    private int codigoCliente;
    private String dataVencimento;

    public Venda(int numeroDaVenda, String dataVenda, String tipoVenda, int codigoCliente, String dataVencimento) {
        this.numeroDaVenda = numeroDaVenda;
        this.dataVenda = dataVenda;
        this.tipoVenda = tipoVenda;
        this.codigoCliente = codigoCliente;
        this.dataVencimento = dataVencimento;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public int getNumeroDaVenda() {
        return numeroDaVenda;
    }

    public void setNumeroDaVenda(int numeroDaVenda) {
        this.numeroDaVenda = numeroDaVenda;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
}
