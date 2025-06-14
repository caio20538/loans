# 💸 Customer Loans API | API de Empréstimos

API desenvolvida em **Java 21 + Spring Boot** para análise de elegibilidade de clientes em diferentes modalidades de empréstimos.

API built with **Java 21 + Spring Boot** to evaluate customers' eligibility for different loan types.

🔗 [Desafio Backend - Loans](https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md)

---

## 🚀 Tecnologias | Technologies

- ✅ Java 21
- ✅ Spring Boot
- ✅ Maven
- ✅ JUnit 5
- ✅ Mockito
- ✅ Spring Web
- ✅ Spring Validation

---

## 📜 Descrição | Description

O objetivo é criar uma API que determina quais modalidades de empréstimos um cliente tem acesso, baseado em:

The goal is to create an API that determines which loan types a customer is eligible for, based on:

- ✅ **Idade | Age**
- ✅ **Salário | Income**
- ✅ **Localização | Location**

---

## 🔥 Modalidades | Loan Types

| Tipo | Type           | Taxa de Juros | Interest Rate (%) |
|------|----------------|----------------|-------------------|
| PESSOAL | PERSONAL     | 4              | 4                 |
| GARANTIDO | GUARANTEED | 3              | 3                 |
| CONSIGNADO | CONSIGNMENT | 2            | 2                 |

---

## 📊 Regras de negócio | Business Rules

### 🇧🇷 Regras (Português)

- **Empréstimo Pessoal (PERSONAL)**  
  ➡️ Salário ≤ R$ 3000  
  ➡️ Ou salário entre R$ 3000 e R$ 5000, se tiver **menos de 30 anos e residir em SP**

- **Empréstimo Consignado (CONSIGNMENT)**  
  ➡️ Salário ≥ R$ 5000

- **Empréstimo com Garantia (GUARANTEED)**  
  ➡️ Salário ≤ R$ 3000  
  ➡️ Ou salário entre R$ 3000 e R$ 5000, se tiver **menos de 30 anos e residir em SP**

---

### 🇺🇸 Rules (English)

- **Personal Loan (`PERSONAL`)**  
  ➡️ Income ≤ R$ 3000  
  ➡️ Or income between R$ 3000 and R$ 5000 **if under 30 years old and living in SP**

- **Consignment Loan (`CONSIGNMENT`)**  
  ➡️ Income ≥ R$ 5000

- **Guaranteed Loan (`GUARANTEED`)**  
  ➡️ Income ≤ R$ 3000  
  ➡️ Or income between R$ 3000 and R$ 5000 **if under 30 years old and living in SP**

---

## 📑 Endpoints

### 🔸 [POST] `/customer-loans`

#### Request Body

```json
{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 7000.00,
  "location": "SP"
}
````

#### Response Body

```json
{
  "customer": "Vuxaywua Zukiagou",
  "loans": [
    {
      "type": "PERSONAL",
      "interest_rate": 4
    },
    {
      "type": "GUARANTEED",
      "interest_rate": 3
    },
    {
      "type": "CONSIGNMENT",
      "interest_rate": 2
    }
  ]
}
```

---

## ✅ Como executar | How to run

### 🔧 Pré-requisitos | Prerequisites

* Java 21
* Maven

### 🚀 Executar localmente | Run locally

```bash
# Clone o repositório | Clone the repository
git clone https://github.com/seu-usuario/customer-loans-api.git

# Acesse o diretório | Go to project folder
cd customer-loans-api

# Execute o projeto | Run the project
./mvnw spring-boot:run
```

➡️ API disponível em | API available at:
`http://localhost:8080/customer-loans`

---

## 🧪 Testes | Testing

O projeto possui testes unitários utilizando **JUnit 5** e **Mockito**.
The project includes unit tests using **JUnit 5** and **Mockito**.

### Rodar testes | Run tests:

```bash
./mvnw test
```

---

## 📂 Estrutura | Project Structure

```plaintext
src
└── main
    └── java
        └── com
            └── caio
                └── loans
                    ├── controller
                      └── dto
                        ├── response
                        └── request
                    ├── domain
                    ├── service
                    └── LoansApplication.java
└── test
    └── java
        └── com
            └── caio
                └── loans
                    └── domain
                      └── factory
```
---

## 🧑‍💻 Autor | Author

Desenvolvido por | Developed by **Caio Vinícius Batista da Silva** 🚀
🔗 [LinkedIn](https://www.linkedin.com/in/caio-silva-397301254/)
💻 [GitHub](https://github.com/caio20538)

---

## 🏛️ Licença | License

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
This project is under the MIT license. See the [LICENSE](LICENSE) file for more details.

