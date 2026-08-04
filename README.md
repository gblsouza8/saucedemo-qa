# SauceDemo QA

<p align="center">

![GitHub last commit](https://img.shields.io/github/last-commit/gblsouza8/saucedemo-qa?style=for-the-badge)
![GitHub repo size](https://img.shields.io/github/repo-size/gblsouza8/saucedemo-qa?style=for-the-badge)
![Status](https://img.shields.io/badge/status-Em%20Desenvolvimento-success?style=for-the-badge)
![Cypress](https://img.shields.io/badge/Cypress-v15.19-brightgreen?style=for-the-badge&logo=cypress)
![Node.js](https://img.shields.io/badge/Node.js-v24.13.1-green?style=for-the-badge&logo=nodedotjs)

</p>

---

# 📖 Sobre o projeto

Este repositório simula um **fluxo completo de trabalho de um Analista de QA**, utilizando o sistema **SauceDemo** como aplicação de testes.

O objetivo é demonstrar, através de um projeto prático, conhecimentos em:

- Planejamento de testes;
- Escrita de Casos de Teste (BDD e Tradicional);
- Execução Manual;
- Evidências de Teste;
- Relatórios de Execução;
- Automação de Testes utilizando Cypress;
- Organização de documentação seguindo boas práticas de QA.

O projeto foi estruturado para servir como portfólio profissional e evoluir continuamente com novas funcionalidades e automações.

---

# 🎯 Objetivos

- Demonstrar conhecimentos em QA Manual
- Demonstrar conhecimentos em QA Automation
- Aplicar boas práticas de documentação
- Organizar um projeto semelhante ao encontrado em empresas
- Utilizar Git/GitHub para versionamento

---

# 🛠 Tecnologias utilizadas

## QA

- Test Design
- Test Execution
- Bug Reporting
- BDD
- Test Reports

## Automação

- Cypress 15
- JavaScript
- Node.js
- Mochawesome Reporter
- Mocha JUnit Reporter

## Ferramentas

- Git
- GitHub
- Visual Studio Code
- Excel
- PDF

---

# 📂 Estrutura do Projeto

```text
.
├── Casos de Teste - BDD.xlsx
│
├── Testes manuais
│   ├── CT001_Login
│   │   ├── Casos de Teste - Login.xlsx
│   │   └── Relatório CT001.pdf
│   │
│   ├── CT002_Carrinho
│   │   ├── Casos de Teste - Carrinho.xlsx
│   │   └── Relatório CT002.pdf
│   │
│   └── CT003_Filtro
│       ├── Casos de Teste - Filtro.xlsx
│       └── Relatório CT003.pdf
│
└── Testes automatizados
    └── Cypress
        ├── cypress/
        │   └── e2e
        │       ├── login.cy.js
        │       ├── carrinho.cy.js
        │       └── filtro.cy.js
        │
        ├── package.json
        ├── cypress.config.js
        └── config-qa.js
```

---

# 📋 Casos de Teste

Atualmente o projeto contempla três funcionalidades principais da aplicação.

| ID | Funcionalidade |
|-----|----------------|
| CT001 | Login |
| CT002 | Carrinho |
| CT003 | Filtro de Produtos |

Cada funcionalidade contém:

- Casos de teste
- Relatório de execução
- Evidências
- Resultado dos testes

---

# 🤖 Automação

Os testes automatizados foram desenvolvidos utilizando **Cypress**, buscando reproduzir os cenários previamente executados manualmente.

Atualmente existem automações para:

- Login
- Carrinho
- Filtro

---

# 📊 Relatórios

Os testes manuais possuem relatórios individuais contendo:

- Objetivo
- Ambiente
- Cenários executados
- Resultado da execução
- Evidências
- Conclusão

A automação está preparada para geração de relatórios através do:

- Mochawesome
- JUnit XML

---

# ⚙️ Como executar

## Pré-requisitos

- Node.js instalado
- Git
- Visual Studio Code

---

## Clonar o projeto

```bash
git clone https://github.com/gblsouza8/saucedemo-qa
```

---

## Instalar dependências

```bash
cd "Testes automatizados/Cypress"

npm install
```

---

## Executar no Chrome

```bash
npm run run:chrome
```

---

## Executar no Firefox

```bash
npm run run:firefox
```

---

## Abrir interface do Cypress

```bash
npm run open:qa
```

---

# 🔒 Variáveis de Ambiente

O projeto utiliza arquivo `.env` para armazenar informações sensíveis.

Exemplo:

```env
BASE_URL=https://www.saucedemo.com

PASSWORD=secret_sauce
```

O arquivo `.env` não deve ser versionado.

---

# 📈 Roadmap

## QA Manual

- [x] Casos de Teste
- [x] Relatórios
- [x] Execução Manual
- [x] BDD

## Automação

- [x] Cypress
- [ ] Selenium


---

# 📚 Boas práticas utilizadas

- Organização por funcionalidade
- Separação entre testes manuais e automatizados
- Versionamento com Git
- Estrutura modular
- Casos de teste reutilizáveis
- Documentação centralizada

---

# 👨‍💻 Autor

**Gabriel Souza**

QA Engineer em desenvolvimento.

Atualmente estudando:

- QA Manual
- Automação de Testes
- Cypress
- Selenium
- Playwright
- Testes de API

---