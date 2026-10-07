package projeto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ListaProdutos listaProdutos = new ListaProdutos();
    static ListaClientes listaClientes = new ListaClientes();
    static ListaVendas listaVendas = new ListaVendas();
    static ListaItemVenda listaItemVenda = new ListaItemVenda();

    public static void main(String[] args) {

        // Carregar dados dos arquivos ao iniciar
        try {
            listaProdutos.puxarDados();
        } catch (Exception e) {
            System.out.println("Arquivo de produtos nao encontrado, iniciando vazio.");
        }
        try {
            listaClientes.puxarDados();
        } catch (Exception e) {
            System.out.println("Arquivo de clientes nao encontrado, iniciando vazio.");
        }
        try {
            listaVendas.puxarDados();
        } catch (Exception e) {
            System.out.println("Arquivo de vendas nao encontrado, iniciando vazio.");
        }
        try {
            listaItemVenda.puxarDados();
        } catch (Exception e) {
            System.out.println("Arquivo de itens de vendas nao encontrado, iniciando vazio.");
        }

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1 - Produtos");
            System.out.println("2 - Clientes");
            System.out.println("3 - Vendas");
            System.out.println("4 - Consultas");
            System.out.println("5 - Sair");

            opcao = lerInt("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    menuProdutos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    menuVendas();
                    break;
                case 4:
                    menuConsultas();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida! Digite um numero de 1 a 5.");
            }
        }
    }

    //METODOS DE LEITURA

    // Le um numero inteiro. Se o usuario digitar letra/caractere, avisa e pede de novo.
    static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = scanner.nextInt();
                scanner.nextLine(); // limpa o buffer
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida! Digite apenas numeros inteiros.");
                scanner.nextLine(); // descarta a entrada errada
            }
        }
    }

    // le um numero decimal
    static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                double valor = scanner.nextDouble();
                scanner.nextLine(); // limpa o buffer
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida! Digite apenas numeros (use virgula para decimais).");
                scanner.nextLine(); // descarta a entrada errada
            }
        }
    }

    // le um texto que nao pode ficar vazio.
    static String lerString(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            System.out.println("O campo nao pode ficar vazio!");
        }
    }

    //MENU PRODUTOS
    static void menuProdutos() {
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n===== MENU PRODUTOS =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Alterar produto");
            System.out.println("4 - Excluir produto");
            System.out.println("5 - Voltar");

            opcao = lerInt("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    consultarProduto();
                    break;
                case 3:
                    alterarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opcao invalida! Digite um numero de 1 a 5.");
            }
        }
    }

    static void cadastrarProduto() {
        System.out.println("\n--- CADASTRAR PRODUTO ---");
        String descricao = lerString("Descricao do produto: ");
        double valorCompra = lerDouble("Valor de compra: ");
        double valorVenda = lerDouble("Valor de venda: ");
        int qtdEstoque = lerInt("Quantidade em estoque: ");
        int estoqueMin = lerInt("Estoque minimo: ");

        int codigo = listaProdutos.gerarCodigoProduto();
        listaProdutos.adicionarProduto(codigo, descricao, valorCompra, valorVenda, qtdEstoque, estoqueMin);
        System.out.println("Codigo gerado automaticamente: " + codigo);

        try {
            listaProdutos.gravarDados();
        } catch (Exception e) {
            System.out.println("Erro ao gravar dados no arquivo.");
        }
    }

    static void consultarProduto() {
        System.out.println("\n--- CONSULTAR PRODUTO ---");
        int codigo = lerInt("Informe o codigo do produto: ");

        Produto p = listaProdutos.verificarProduto(codigo);
        if (p != null) {
            System.out.println("Codigo: " + p.getCodigoProduto());
            System.out.println("Descricao: " + p.getDescricaoProduto());
            System.out.println("Valor compra: " + p.getValorCompra());
            System.out.println("Valor venda: " + p.getValorVenda());
            System.out.println("Estoque: " + p.getQtdEstoque());
            System.out.println("Estoque minimo: " + p.getEstoqueMin());
        } else {
            System.out.println("Produto nao encontrado!");
        }
    }

    static void alterarProduto() {
        System.out.println("\n--- ALTERAR PRODUTO ---");
        int codigo = lerInt("Informe o codigo do produto: ");

        Produto p = listaProdutos.verificarProduto(codigo);
        if (p == null) {
            System.out.println("Produto nao encontrado!");
            return;
        }

        String descricao = lerString("Nova descricao: ");
        double valorCompra = lerDouble("Novo valor de compra: ");
        double valorVenda = lerDouble("Novo valor de venda: ");
        int qtdEstoque = lerInt("Nova quantidade em estoque: ");
        int estoqueMin = lerInt("Novo estoque minimo: ");

        listaProdutos.alterarProduto(codigo, descricao, valorCompra, valorVenda, qtdEstoque, estoqueMin);

        try {
            listaProdutos.gravarDados();
        } catch (Exception e) {
            System.out.println("Erro ao gravar dados no arquivo.");
        }
    }

    static void excluirProduto() {
        System.out.println("\n--- EXCLUIR PRODUTO ---");
        int codigo = lerInt("Informe o codigo do produto: ");

        Produto p = listaProdutos.verificarProduto(codigo);
        if (p == null) {
            System.out.println("Produto nao encontrado!");
            return;
        }

        if (listaItemVenda.produtoTemVenda(codigo)) {
            System.out.println("Nao e possivel excluir! Produto vinculado a uma venda.");
            return;
        }

        listaProdutos.removerProduto(codigo);

        try {
            listaProdutos.gravarDados();
        } catch (Exception e) {
            System.out.println("Erro ao gravar dados no arquivo.");
        }
    }

    // CLIENTES
    static void menuClientes() {
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n===== MENU CLIENTES =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar cliente");
            System.out.println("3 - Alterar cliente");
            System.out.println("4 - Excluir cliente");
            System.out.println("5 - Voltar");

            opcao = lerInt("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    alterarCliente();
                    break;
                case 4:
                    excluirCliente();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opcao invalida! Digite um numero de 1 a 5.");
            }
        }
    }

    static void cadastrarCliente() {
        System.out.println("\n--- CADASTRAR CLIENTE ---");
        String nome = lerString("Nome: ");
        String endereco = lerString("Endereco: ");
        String telefone = lerString("Telefone: ");

        int codigo = listaClientes.gerarCodigoCliente();
        listaClientes.addCliente(codigo, nome, endereco, telefone);
        System.out.println("Codigo gerado automaticamente: " + codigo);

        try {
            listaClientes.gravarDados();
        } catch (Exception e) {
            System.out.println("Erro ao gravar dados no arquivo.");
        }
    }

    static void consultarCliente() {
        System.out.println("\n--- CONSULTAR CLIENTE ---");
        int codigo = lerInt("Informe o codigo do cliente: ");

        Cliente c = listaClientes.buscarCliente(codigo);
        if (c != null) {
            System.out.println("Codigo: " + c.getCodigoCliente());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Endereco: " + c.getEndereco());
            System.out.println("Telefone: " + c.getTelefone());
        } else {
            System.out.println("Cliente nao encontrado!");
        }
    }

    static void alterarCliente() {
        System.out.println("\n--- ALTERAR CLIENTE ---");
        int codigo = lerInt("Informe o codigo do cliente: ");

        Cliente c = listaClientes.buscarCliente(codigo);
        if (c == null) {
            System.out.println("Cliente nao encontrado!");
            return;
        }

        String nome = lerString("Novo nome: ");
        String endereco = lerString("Novo endereco: ");
        String telefone = lerString("Novo telefone: ");

        listaClientes.alterarCliente(codigo, nome, endereco, telefone);

        try {
            listaClientes.gravarDados();
        } catch (Exception e) {
            System.out.println("Erro ao gravar dados no arquivo.");
        }
    }

    static void excluirCliente() {
        System.out.println("\n--- EXCLUIR CLIENTE ---");
        int codigo = lerInt("Informe o codigo do cliente: ");

        if (listaClientes.removerCliente(codigo)) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente nao encontrado!");
        }

        try {
            listaClientes.gravarDados();
        } catch (Exception e) {
            System.out.println("Erro ao gravar dados no arquivo.");
        }
    }

    // ==================== MENU VENDAS ====================
    static void menuVendas() {
        int opcao = 0;

        while (opcao != 2) {
            System.out.println("\n===== MENU VENDAS =====");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Voltar");

            opcao = lerInt("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    realizarVenda();
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opcao invalida! Digite 1 ou 2.");
            }
        }
    }

    static void realizarVenda() {
        System.out.println("\n--- REALIZAR VENDA ---");

        // Data da venda capturada automaticamente do sistema
        java.time.LocalDate hoje = java.time.LocalDate.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataVenda = hoje.format(formatter);
        System.out.println("Data da venda (automatica): " + dataVenda);

        // Tipo da venda - loop ate digitar valido
        String tipoVenda;
        while (true) {
            tipoVenda = lerString("Tipo da venda (vista/prazo): ");
            if (tipoVenda.equalsIgnoreCase("vista") || tipoVenda.equalsIgnoreCase("prazo")) {
                break;
            }
            System.out.println("Tipo invalido! Digite 'vista' ou 'prazo'.");
        }

        int codigoCliente = -1;
        String dataVencimento = dataVenda;

        if (tipoVenda.equalsIgnoreCase("prazo")) {
            // ate informar um cliente valido
            while (true) {
                codigoCliente = lerInt("Codigo do cliente: ");
                Cliente c = listaClientes.buscarCliente(codigoCliente);
                if (c != null) {
                    System.out.println("Cliente: " + c.getNome());
                    break;
                }
                System.out.println("Cliente nao encontrado! Tente novamente.");
            }

            // Loop ate informar data de vencimento valida (igual ou superior a data da venda)
            while (true) {
                String dataDigitada = lerString("Data de vencimento (dd/MM/yyyy): ");
                try {
                    java.time.LocalDate vencimento = java.time.LocalDate.parse(dataDigitada, formatter);
                    if (vencimento.isBefore(hoje)) {
                        System.out.println("A data de vencimento deve ser igual ou superior a data da venda!");
                    } else {
                        dataVencimento = dataDigitada;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Data invalida! Use o formato dd/MM/yyyy.");
                }
            }
        }

        // cria a venda
        listaVendas.addVenda(dataVenda, tipoVenda, codigoCliente, dataVencimento);
        int numeroVenda = listaVendas.getUltimoNumeroVenda();
        System.out.println("Nota Fiscal numero " + numeroVenda + " gerada!");

        // adicionar itens na venda
        String continuar = "s";
        while (continuar.equalsIgnoreCase("s")) {
            int codigoProduto = lerInt("Codigo do produto: ");

            Produto p = listaProdutos.verificarProduto(codigoProduto);
            if (p == null) {
                System.out.println("Produto nao encontrado!");
            } else {
                System.out.println("Produto: " + p.getDescricaoProduto() + " | Estoque disponivel: " + p.getQtdEstoque());
                int quantidade = lerInt("Quantidade: ");
                listaItemVenda.addItemVenda(numeroVenda, codigoProduto, quantidade, listaProdutos);
            }

            continuar = lerString("Adicionar outro produto? (s/n): ");
        }

        // gravar tudo nos arquivos apos fazer a alteracao
        try {
            listaVendas.gravarDados();
            listaItemVenda.gravarDados();
            listaProdutos.gravarDados(); // estoque atualizado
        } catch (Exception e) {
            System.out.println("Erro ao gravar dados nos arquivos.");
        }

        System.out.println("Venda finalizada com sucesso!");
    }

    //CONSULTAS
    static void menuConsultas() {
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n===== MENU CONSULTAS =====");
            System.out.println("1 - Vendas realizadas em um periodo");
            System.out.println("2 - Produtos abaixo do estoque minimo");
            System.out.println("3 - Voltar");

            opcao = lerInt("Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    consultaVendasPorPeriodo();
                    break;
                case 2:
                    consultaProdutosAbaixoMinimo();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opcao invalida! Digite um numero de 1 a 3.");
            }
        }
    }

    static void consultaVendasPorPeriodo() {
        System.out.println("\n--- VENDAS POR PERIODO ---");
        String dataInicial = lerString("Data inicial (dd/MM/yyyy): ");
        String dataFinal = lerString("Data final (dd/MM/yyyy): ");

        listaVendas.consultarVendasPorPeriodo(dataInicial, dataFinal);
    }

    static void consultaProdutosAbaixoMinimo() {
        System.out.println("\n--- PRODUTOS ABAIXO DO ESTOQUE MINIMO ---");
        listaProdutos.listarProdutosAbaixoMinimo();
    }
}
