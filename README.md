# App Aluguel de Veículos 🚗

Sistema completo de gerenciamento de aluguel de veículos, desenvolvido com **Spring Boot** no backend e **Angular 16** no frontend. Permite o cadastro de clientes e veículos, além da realização de aluguéis com controle de disponibilidade e regras de negócio específicas.

---

## 📦 Tecnologias Utilizadas

### Backend (Java 21 + Spring Boot)
- Spring Web
- Spring Data JPA
- Hibernate
- H2

---

## 🔧 Funcionalidades

### 📄 Clientes
- Cadastro, listagem, edição e remoção
- Validação de maioridade (mínimo 18 anos)

### 🚗 Veículos
- Cadastro, listagem, edição e remoção
- Controle de disponibilidade

### 📆 Aluguel
- Aluguel de veículos disponíveis
- Cálculo de valor total com base nos dias (R$100/dia)
- Após o aluguel, o veículo fica indisponível

---

## ▶️ Como rodar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/app-aluguel-veiculos.git
   cd app-aluguel-veiculos
   
2. Compile e rode a aplicação:
   ```bash
   ./mvnw spring-boot:run

4. Acesse o backend em:
    ```bash
   http://localhost:8080/api

Banco em memória H2:
  
  Console: http://localhost:8080/h2-console

---

## ⚠️ Regras de Negócio
- Veículo só pode ser alugado se estiver disponível
- Cliente deve ter pelo menos 18 anos
- Valor do aluguel = dias alugados * R$100
- Veículo fica indisponível após o aluguel

## ✅ Melhorias Futuras
- Retorno e liberação do veículo
- Relatórios e histórico de aluguéis
- Autenticação e autorização com Spring Security / JWT
- Integração com pagamentos


## 🙋‍♂️ Autor
Desenvolvido por [Luan Fonseca]

