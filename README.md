# 📊 Desafio Itau - API de Transações

Este projeto é uma implementação de estudo de um **desafio técnico**
proposto em processos seletivos do Itaú.\
Não participei do processo, desenvolvi apenas como forma de **prática
com Spring Boot** e boas práticas de APIs REST.

------------------------------------------------------------------------

## 🚀 Tecnologias utilizadas

-   Java 24
-   Spring Boot 
-   Jakarta Validation
-   Maven

------------------------------------------------------------------------

## 📌 Objetivo

Criar uma API que registre transações em memória e
disponibilize **estatísticas agregadas** (soma, média, mínimo, máximo e
quantidade) das transações ocorridas nos últimos **60 segundos**.

------------------------------------------------------------------------

## 📂 Estrutura da API

### 🔹 Endpoints

#### ➤ Criar transação

    POST /transacao

**Request Body (JSON):**

``` json
{
  "valor": 120.50,
  "dataHora": "2025-08-17T18:00:00Z"
}
```

**Respostas:** - `201 Created` → transação registrada -
`422 Unprocessable Entity` → data no futuro ou valor inválido -
`400 Bad Request` → JSON mal formatado

------------------------------------------------------------------------

#### ➤ Estatísticas

    GET /estatistica

**Response Body (JSON):**

``` json
{
  "count": 3,
  "sum": 350.75,
  "avg": 116.91,
  "min": 50.25,
  "max": 200.50
}
```

------------------------------------------------------------------------

#### ➤ Limpar transações

    DELETE /transacao

**Resposta:** - `204 No Content` → todas as transações removidas

------------------------------------------------------------------------

## 🛠️ Como rodar o projeto

### Pré-requisitos

-   Java 17+
-   Maven

### Executando

``` bash
# Clonar o repositório
git clone https://github.com/seu-usuario/desafio-itau.git

# Entrar na pasta
cd desafio-itau

# Rodar aplicação
mvn spring-boot:run
```

A API estará disponível em:

    http://localhost:8080

------------------------------------------------------------------------

## 📝 Observações

-   Todas as transações são mantidas **em memória**
    (`ConcurrentLinkedQueue`), sem persistência em banco de dados.\
-   Foco do estudo: **uso de validações, controllers bem estruturados,
    DTOs e cálculo eficiente com `DoubleSummaryStatistics`**.\
-   O projeto foi feito apenas para **prática pessoal**.

------------------------------------------------------------------------
