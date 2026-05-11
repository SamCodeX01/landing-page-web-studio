# 🌐 Web Studio – Plataforma de Captura de Leads

Sistema fullstack para agência de tecnologia que oferece criação de sites institucionais, sistemas web sob medida e e-commerces. O projeto consiste em uma landing page de vendas com formulário de contato que persiste os dados diretamente no banco de dados PostgreSQL via API REST. No backend é utilizado Java com JPA puro + Hibernate (persistence.xml e EntityManager manual) e no frontend React com formulário responsivo.

## 🎯 Funcionalidades

### Frontend (React)
- Menu hambúrguer responsivo
- Seções: Hero, Serviços (com preços), Portfólio, Diferenciais, Depoimentos
- Formulário de captura com campos: nome, e-mail, telefone, tipo de serviço, mensagem e orçamento previsto
- Envio dos dados para API REST via fetch/axios
- Feedback visual de sucesso/erro

### Backend (Java + JPA puro)
- API REST para recebimento de leads (`POST /api/leads`)
- Endpoint para listagem de leads (`GET /api/leads`)
- Validação de campos (nome, e-mail válido, telefone)
- Persistência com JPA + Hibernate via EntityManagerFactory
- Configuração via persistence.xml
- Gerenciamento manual de transações
- Banco de dados PostgreSQL

## 🛠️ Tecnologias

### Front-end
- React 18 + Vite
- CSS Modules
- Axios (requisições HTTP)
- React Router DOM

### Back-end
- Java 17+
- JPA (Jakarta Persistence 3.x)
- Hibernate (provedor JPA)
- Spark Java (Framework REST leve)
- PostgreSQL
- Gson (serialização JSON)
- Maven

## 📦 Estrutura do Projeto

```text
backend/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── agencia/
│   │   │           ├── MainApplication.java
│   │   │           ├── controller/
│   │   │           │   └── LeadController.java
│   │   │           ├── service/
│   │   │           │   └── LeadService.java
│   │   │           ├── dao/
│   │   │           │   └── LeadDAO.java
│   │   │           ├── model/
│   │   │           │   └── Lead.java
│   │   │           ├── dto/
│   │   │           │   └── LeadRequestDTO.java
│   │   │           └── util/
│   │   │               └── JPAUtil.java
│   │   └── resources/
│   │       └── META-INF/
│   │           └── persistence.xml
│   └── test/
│       └── java/
│           └── com/
│               └── agencia/
│                   └── LeadDAOTest.java
│
frontend/
├── package.json
├── index.html
├── src/
│   ├── App.jsx
│   ├── main.jsx
│   ├── components/
│   │   ├── Header.jsx
│   │   ├── Footer.jsx
│   │   ├── Hero.jsx
│   │   ├── Services.jsx
│   │   ├── Portfolio.jsx
│   │   ├── Testimonials.jsx
│   │   └── LeadForm.jsx
│   ├── services/
│   │   └── api.js
│   ├── styles/
│   │   └── global.css
│   └── utils/
│       └── validators.js
└── public/
    ├── images/
    └── favicon.ico

### Pré-requisitos
- Node.js 18+
- Java 17+
- PostgreSQL 15+ (local ou Docker)
- Maven

