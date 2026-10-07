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
└── projecao/
    ├── Cliente.java
    ├── ItemVenda.java
    ├── Produto.java
    ├── Venda.java
    ├── ListaClientes.java
    ├── ListaProdutos.java
    ├── ListaItemVenda.java
    ├── ListaVendas.java
    └── Main.java
