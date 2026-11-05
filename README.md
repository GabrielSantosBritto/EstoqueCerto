# EstoqueCerto

## 1. Sobre o projeto

O **EstoqueCerto** é um sistema de gestão de compras e controle de estoque desenvolvido com o objetivo de auxiliar micro e pequenos comerciantes na organização de suas aquisições de mercadorias.

A aplicação busca centralizar informações sobre fornecedores, produtos e compras, permitindo acompanhar os itens adquiridos e registrar a entrada das mercadorias no estoque.

## 2. Problema e justificativa

Micro e pequenos comerciantes frequentemente enfrentam dificuldades para organizar suas compras, acompanhar os pedidos realizados e controlar a entrada de mercadorias.

A utilização de controles manuais ou ferramentas descentralizadas pode dificultar o acompanhamento das aquisições, gerar inconsistências nas quantidades disponíveis e comprometer a organização das informações.

O EstoqueCerto propõe uma solução para esse problema por meio de uma aplicação que centraliza o gerenciamento de fornecedores, produtos e compras, mantendo o histórico das movimentações de estoque.

## 3. Objetivo do projeto

Desenvolver uma aplicação que permita aos pequenos comerciantes organizar suas compras de mercadorias, acompanhar os produtos adquiridos e atualizar o estoque a partir da confirmação do recebimento das compras.

## 4. Integrantes da equipe

- Agenor Santos Britto
- Gabriel Santos Britto
- Thaylon Ferreira

## 5. Tecnologias utilizadas

- **Java:** linguagem de programação.
- **Spring Boot:** framework para desenvolvimento da aplicação.
- **Spring Data JPA:** gerenciamento da persistência de dados.
- **Hibernate:** implementação ORM.
- **MySQL:** sistema gerenciador de banco de dados.
- **Maven:** gerenciamento de dependências e construção do projeto.
- **Postman:** ferramenta para testes das requisições HTTP.

## 6. API externa

O projeto utilizará a **BrasilAPI**, uma API pública que disponibiliza informações cadastrais de empresas a partir de consultas de CNPJ.

A integração será utilizada no cadastro de fornecedores, permitindo consultar e validar as informações cadastrais de uma empresa por meio do seu CNPJ.

**Endpoint previsto:**

`GET https://brasilapi.com.br/api/cnpj/v1/{cnpj}`

Documentação: https://brasilapi.com.br/docs

## 7. Requisitos funcionais

| Código | Requisito |
|---|---|
| RF01 | Permitir cadastrar e consultar fornecedores. |
| RF02 | Permitir consultar informações de empresas por meio da BrasilAPI, utilizando o CNPJ. |
| RF03 | Permitir cadastrar e consultar produtos. |
| RF04 | Permitir registrar compras vinculadas a fornecedores. |
| RF05 | Permitir adicionar produtos e suas respectivas quantidades às compras. |
| RF06 | Permitir confirmar o recebimento de uma compra. |
| RF07 | Atualizar automaticamente as quantidades em estoque após a confirmação do recebimento. |
| RF08 | Permitir consultar o histórico de movimentações de estoque. |

## 8. Regras gerais do sistema

- O CNPJ de um fornecedor deve ser único.
- Uma compra deve possuir pelo menos um item.
- As quantidades e os preços dos itens de compra devem ser maiores que zero.
- O estoque será atualizado somente após a confirmação do recebimento da compra.
- O recebimento de uma compra será realizado integralmente, sem recebimentos parciais.
- Uma compra não poderá ter seu recebimento processado mais de uma vez.
- As movimentações de estoque deverão manter um histórico dos registros realizados.

## 9. Arquitetura da aplicação

O sistema utiliza uma arquitetura em camadas, organizando as responsabilidades da aplicação:

- **Controller:** recebe e responde às requisições HTTP.
- **DTO:** organiza os dados recebidos e enviados pela API.
- **Service:** concentra as regras de negócio.
- **Repository:** realiza o acesso e a persistência dos dados.
- **Entity:** representa as entidades do domínio e seu mapeamento para o banco de dados.

A aplicação utiliza Spring Boot, Spring Data JPA e Hibernate para integração com o banco de dados MySQL.

## 10. Escopo do projeto

O sistema contempla o gerenciamento de:

- Fornecedores;
- Produtos;
- Compras;
- Itens de compra;
- Movimentações de estoque.

O controle de estoque está integrado ao processo de recebimento das compras, permitindo manter o registro das entradas de mercadorias.

## 11. Execução do projeto

O projeto utiliza Maven Wrapper para gerenciamento e execução.

Com o MySQL em funcionamento e o banco de dados configurado, defina a variável de ambiente `DB_PASSWORD` com a senha do usuário do banco.

Na raiz do projeto, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

A aplicação será disponibilizada localmente na porta `8080`.

---

**EstoqueCerto — Organização de compras e controle de estoque para pequenos comércios.**
