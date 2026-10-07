package projeto;

public class Cliente {

   private int codigoCliente;
   private String nome;
   private String endereco;
   private String telefone;

   public Cliente(int codigo, String nome, String endereco, String telefone) {
       this.codigoCliente = codigo;
       this.nome = nome;
       this.endereco = endereco;
       this.telefone = telefone;
   }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigo) {
        this.codigoCliente = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
