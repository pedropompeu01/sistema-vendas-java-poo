package projeto;

import java.io.*;
import java.util.*;

public class ListaClientes {

    ArrayList<Cliente> clientes;

    public ListaClientes() {
        clientes = new ArrayList<>();
    }

    public void addCliente(int codigo, String nome, String endereco, String telefone) {

        if(buscarCliente(codigo) != null){
            // talvez lancar uma execao aqui
            System.out.println("Já existe um cliente cadastrado com este codigo");
            return;
        }
        Cliente cliente = new Cliente(codigo, nome, endereco, telefone);

        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso");

    }
    public int gerarCodigoCliente() {
        int maior = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getCodigoCliente() > maior) {
                maior = cliente.getCodigoCliente();
            }
        }
        return maior + 1;
    }
    public void imprimirClientes(){
        int i=1;
        System.out.println("---LISTA DE CLIENTES---");
        for (Cliente cliente : clientes) {
            System.out.println( "Cliente " + i +":");
            System.out.println("Codigo -> " + cliente.getCodigoCliente());
            System.out.println("Nome -> " + cliente.getNome());
            System.out.println("Endereco -> " + cliente.getEndereco());
            System.out.println("Telefone -> " + cliente.getTelefone());
            System.out.println("[][][][][][][][][][][][][][][][][][]");
            i++;
        }
        System.out.println("FIM DA LISTA!");
    }

    public Cliente buscarCliente(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigoCliente() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    public boolean removerCliente(int codigo){
        for (Cliente cliente : clientes) {
            if (cliente.getCodigoCliente() == codigo) {
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }
    public boolean alterarCliente(int codigo, String nome, String endereco, String telefone){
        for (Cliente cliente : clientes) {
            if (cliente.getCodigoCliente() == codigo) {
                cliente.setNome(nome);
                cliente.setEndereco(endereco);
                cliente.setTelefone(telefone);
                System.out.println("Dados alterados com sucesso!");
                return true;
            }
        }
        System.out.println("Cliente nao encontrado!");
        return false;
    }

    public void gravarDados() throws FileNotFoundException{

        FileOutputStream saida = new FileOutputStream("src/projeto/ArquivoClientes.txt");
        PrintStream printStream = new PrintStream(saida);

        for(Cliente c : clientes){
            printStream.println(c.getCodigoCliente()+";"+c.getNome()+";"+c.getEndereco()+";"+c.getTelefone());
        }
    }
    public void puxarDados() throws FileNotFoundException{
        FileInputStream entrada = new FileInputStream("src/projeto/ArquivoClientes.txt");
        Scanner scanner = new Scanner(entrada);

        while(scanner.hasNextLine()){
            String linha = scanner.nextLine();
            String[] dados = linha.split(";");
            Cliente c = new Cliente(Integer.parseInt(dados[0]),dados[1],dados[2],dados[3]);
            clientes.add(c);
        }
    }
}
