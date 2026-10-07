# 🛒 Sistema de Gestão de Vendas (POO - Java)

Este repositório contém o meu **primeiro projeto desenvolvido com Programação Orientada a Objetos (POO)** em **Java**. O sistema é uma aplicação de console voltada para o gerenciamento comercial, englobando o controle completo de produtos, clientes, itens de venda e transações comerciais, com persistência de dados em arquivos de texto.

---

## 🚀 Funcionalidades Principais

* **Gerenciamento de Produtos:** Cadastro com geração automática de códigos, consulta, alteração, exclusão com validação de vínculo e verificação de estoque mínimo.
* **Gerenciamento de Clientes:** Cadastro, listagem, atualização de dados cadastrais e remoção com segurança.
* **Controle de Vendas:** Realização de vendas à vista ou a prazo (com validação de data de vencimento e cliente cadastrado), controle de estoque em tempo real e associação de itens.
* **Persistência de Dados:** Salvamento e carregamento automático das informações utilizando arquivos de texto locais (`.txt`).
* **Tratamento de Erros:** Validação de entradas no console para evitar que o programa quebre com caracteres inválidos.

---

## 📂 Estrutura do Projeto

Todos os arquivos estão organizados sob o pacote `projeto` dentro do diretório `src`:

```text
src/
└── projeto/
    ├── Cliente.java
    ├── ItemVenda.java
    ├── Produto.java
    ├── Venda.java
    ├── ListaClientes.java
    ├── ListaProdutos.java
    ├── ListaItemVenda.java
    ├── ListaVendas.java
    └── Main.java


🛠️ Tecnologias e Conceitos Aplicados
Linguagem: Java

Conceitos de POO: Classes, Objetos, Atributos, Encapsulamento, Métodos e Associações entre Classes.

Estruturas de Dados: ArrayList para manipulação dinâmica das coleções em memória.

Manipulação de Arquivos & Exceções: Uso de FileOutputStream, FileInputStream, Scanner, PrintStream e blocos try-catch para persistência robusta.

🖥️ Como Executar o Projeto
Certifique-se de ter o Java JDK instalado na sua máquina.

Clone este repositório ou baixe os arquivos em formato ZIP.

Abra a sua IDE favorita (como IntelliJ IDEA ou Eclipse) e configure o projeto mantendo a estrutura de pacotes src/projeto/.

Execute a classe principal Main.java para iniciar o programa.

📖 Como Utilizar o Sistema
Ao executar a classe Main.java, o sistema exibirá um menu interativo no console com as seguintes opções:

Produtos: Permite cadastrar novos produtos (gerando códigos automáticos), consultar por código, alterar informações, excluir produtos (desde que não estejam vinculados a vendas) e verificar o estoque.

Clientes: Gerencia o cadastro de novos clientes, consultas detalhadas, alterações de dados e remoções.

Vendas: Permite realizar vendas selecionando a modalidade (à vista ou a prazo), informando o cliente (quando a prazo), definindo a data de vencimento e adicionando os produtos desejados ao carrinho com baixa automática no estoque.

Consultas: Oferece relatórios úteis, como a listagem de vendas realizadas em um determinado período (informando a data inicial e final) e a verificação de produtos com estoque abaixo do mínimo recomendado.

Sair: Encerra a aplicação de forma segura, salvando automaticamente as informações nos arquivos de texto correspondentes (.txt).
