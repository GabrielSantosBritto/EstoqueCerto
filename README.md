# EstoqueCerto

## 1. Sobre o projeto

O **EstoqueCerto** é um sistema de gestão de compras e controle de estoque desenvolvido com o objetivo de auxiliar micro e pequenos comerciantes na organização de suas aquisições de mercadorias.

A aplicação busca centralizar informações sobre fornecedores, produtos e compras, permitindo acompanhar os itens adquiridos, registrar a entrada das mercadorias no estoque e manter o histórico das movimentações realizadas.

## 2. Problema e justificativa

Micro e pequenos comerciantes frequentemente enfrentam dificuldades para organizar suas compras, acompanhar os pedidos realizados e controlar a entrada de mercadorias.

A utilização de controles manuais ou ferramentas descentralizadas pode dificultar o acompanhamento das aquisições, gerar inconsistências nas quantidades disponíveis e comprometer a organização das informações.

O EstoqueCerto propõe uma solução para esse problema por meio de uma aplicação que centraliza o gerenciamento de fornecedores, produtos e compras, integrando o recebimento das mercadorias ao controle de estoque.

## 3. Objetivo do projeto

Desenvolver uma aplicação que permita aos pequenos comerciantes organizar suas compras de mercadorias, acompanhar os produtos adquiridos, atualizar o estoque a partir da confirmação do recebimento das compras e controlar as movimentações e devoluções de mercadorias.

## 4. Integrantes da equipe

- Agenor Santos Britto
- Gabriel Santos Britto
- Thailon Da Paixão Ferreira

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

A integração permitirá consultar informações cadastrais de uma empresa durante o processo de cadastro de fornecedores, auxiliando na validação dos dados informados.

**Endpoint previsto:**

`GET https://brasilapi.com.br/api/cnpj/v1/{cnpj}`

Documentação: https://brasilapi.com.br/docs

> A integração está prevista no projeto e será implementada por meio de um cliente responsável pela comunicação com a API externa.

## 7. Requisitos funcionais

| Código | Requisito |
|---|---|
| RF01 | Permitir cadastrar e consultar fornecedores. |
| RF02 | Permitir consultar informações de empresas por meio da BrasilAPI, utilizando o CNPJ. |
| RF03 | Permitir cadastrar e consultar produtos. |
| RF04 | Permitir registrar compras vinculadas a fornecedores. |
| RF05 | Permitir adicionar produtos e suas respectivas quantidades às compras. |
| RF06 | Permitir confirmar o recebimento integral de uma compra. |
| RF07 | Atualizar automaticamente o estoque após a confirmação do recebimento da compra, gerando lotes de estoque. |
| RF08 | Permitir consultar o histórico de movimentações de estoque. |
| RF09 | Permitir registrar devoluções de mercadorias ao fornecedor, vinculadas à compra e aos respectivos lotes de estoque. |
| RF10 | Permitir consultar e controlar os lotes de estoque, considerando suas quantidades disponíveis. |

## 8. Regras de negócio

### Fornecedores e produtos

- O CNPJ de um fornecedor deve ser único.
- Um fornecedor poderá comercializar vários produtos, e um produto poderá estar associado a vários fornecedores.
- Fornecedores e produtos com histórico de utilização não deverão ser excluídos fisicamente. Seu cadastro poderá ser desativado.
- Fornecedores inativos não poderão ser utilizados em novas compras.

### Compras e recebimento

- Uma compra deverá estar vinculada a um fornecedor.
- Uma compra deverá possuir pelo menos um item.
- As quantidades e os preços unitários dos itens de compra deverão ser maiores que zero.
- O valor total da compra será calculado considerando os subtotais dos itens, o frete e o desconto.
- O estoque será atualizado somente após a confirmação do recebimento da compra.
- O recebimento será integral, sem possibilidade de recebimentos parciais.
- Uma compra não poderá ter seu recebimento processado mais de uma vez.
- Cada item de compra recebido deverá gerar um lote de estoque correspondente.

### Controle de estoque

- Cada lote deverá manter sua quantidade inicial, quantidade disponível e data de entrada.
- A retirada de mercadorias deverá seguir o método FIFO (*First In, First Out*), priorizando os lotes mais antigos.
- As movimentações de estoque deverão manter um histórico dos registros realizados.
- As movimentações poderão representar entradas ou saídas e deverão identificar sua origem.
- Movimentações históricas não deverão ser apagadas; correções deverão ser registradas por meio de ajustes.

### Devoluções

- Uma devolução deverá estar vinculada a uma compra.
- Cada devolução deverá possuir pelo menos um item.
- Os itens devolvidos deverão estar vinculados aos lotes de estoque correspondentes.
- A quantidade devolvida não poderá ultrapassar a quantidade disponível no lote.
- A devolução deverá possuir um motivo e um status.
- A conclusão de uma devolução deverá gerar a movimentação de saída correspondente no estoque.
- Uma devolução cancelada não deverá gerar movimentação de saída.

## 9. Arquitetura da aplicação

O sistema utiliza uma arquitetura em camadas, organizando as responsabilidades da aplicação:

- **Controller:** recebe e responde às requisições HTTP.
- **DTO:** organiza os dados recebidos e enviados pela API.
- **Service:** concentra as regras de negócio e coordena as operações da aplicação.
- **Mapper:** realiza a conversão entre DTOs e entidades.
- **Repository:** realiza o acesso e a persistência dos dados.
- **Entity:** representa as entidades do domínio e seu mapeamento para o banco de dados.

A aplicação utiliza Spring Boot, Spring Data JPA e Hibernate para integração com o banco de dados MySQL.

## 10. Escopo do projeto

O sistema contempla o gerenciamento de:

- Fornecedores;
- Produtos;
- Associação entre fornecedores e produtos;
- Compras;
- Itens de compra;
- Lotes de estoque;
- Movimentações de estoque;
- Devoluções;
- Itens de devolução.

O controle de estoque está integrado ao processo de recebimento das compras. As mercadorias recebidas são organizadas em lotes, permitindo acompanhar suas quantidades disponíveis e registrar as movimentações realizadas.

O sistema também contempla o processo de devolução de mercadorias ao fornecedor, mantendo o vínculo com a compra de origem e os lotes correspondentes.

## 11. Documentação

Os diagramas do projeto estão disponíveis na pasta `docs`:

- `diagrama-classes.png`: representa as classes do domínio, seus atributos, métodos e relacionamentos.
- `der.png`: representa a estrutura do banco de dados e os relacionamentos entre as tabelas.
- `diagrama-componentes.png`: representa a organização dos componentes e suas dependências.

## 12. Execução do projeto

O projeto utiliza Maven Wrapper para gerenciamento e execução.

Com o MySQL em funcionamento e o banco de dados configurado, defina a variável de ambiente `DB_PASSWORD` com a senha do usuário do banco.

Na raiz do projeto, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

A aplicação será disponibilizada localmente na porta `8080`.

---

**EstoqueCerto — Organização de compras e controle de estoque para pequenos comércios.**