# 🌐 Landing Page Web Studio – Plataforma de Captura de Leads

Sistema fullstack para agência de tecnologia que oferece criação de sites institucionais, sistemas web sob medida e e-commerces. O projeto consiste em uma landing page de vendas com formulário de contato que persiste os dados diretamente no banco de dados PostgreSQL via API REST, no backend é utilizado Java com Spring Boot e JPA para capturar leads e o Front End em React com formulário responsivo.

## 🎯 Funcionalidades

### Frontend (React)
- Menu hambúrguer responsivo
- Seções: Hero, Serviços (com preços), Portfólio, Diferenciais, Depoimentos
- Formulário de captura com campos: nome, e-mail, telefone, tipo de serviço, mensagem e orçamento previsto
- Envio dos dados para API REST via fetch/axios
- Feedback visual de sucesso/erro

### Backend (Java Spring Boot)
- API REST para recebimento de leads (`POST /api/leads`)
- Endpoint para listagem de leads (`GET /api/leads`) - protegido futuramente
- Validação de campos (nome, e-mail válido, telefone)
- Integração com Spring Data JPA
- Persistência em PostgreSQL
- Tratamento de exceções e logs

## 🛠️ Tecnologias

### Front-end
- React 18 + Vite
- CSS Modules (ou Styled Components)
- Axios (requisições HTTP)
- React Router DOM (se houver múltiplas páginas)

### Back-end
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Maven
- Lombok (opcional)

## 📦 Estrutura do Projeto

