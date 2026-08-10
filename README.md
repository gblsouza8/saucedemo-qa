# 🧪 SauceDemo QA

<p align="center">

![Cypress](https://img.shields.io/badge/Cypress-15.19-17202C?style=for-the-badge\&logo=cypress\&logoColor=white)
![Playwright](https://img.shields.io/badge/Playwright-1.62.1-2EAD33?style=for-the-badge\&logo=playwright\&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.18.1-43B02A?style=for-the-badge\&logo=selenium\&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Python](https://img.shields.io/badge/Python-3.x-3776AB?style=for-the-badge\&logo=python\&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-ES2022-F7DF1E?style=for-the-badge\&logo=javascript\&logoColor=black)
![TypeScript](https://img.shields.io/badge/TypeScript-7.0.2-3178C6?style=for-the-badge\&logo=typescript\&logoColor=white)

</p>

---

## 📖 Sobre o projeto

O **SauceDemo QA** é um projeto de portfólio desenvolvido para demonstrar, de forma prática e estruturada, diferentes etapas e estratégias presentes no processo de **Quality Assurance**.

Utilizando o **SauceDemo** como aplicação sob teste, o projeto reúne **testes manuais, documentação, evidências, reporte de bugs e múltiplas abordagens de automação**, permitindo aplicar e comparar diferentes ferramentas, linguagens e arquiteturas de testes.

O projeto foi desenvolvido de forma incremental, utilizando os mesmos fluxos funcionais como base para diferentes estratégias de automação:

* 🔐 Login
* 🛒 Carrinho
* 🔎 Filtros e ordenação de produtos

A proposta é demonstrar não apenas a execução dos testes, mas também aspectos importantes do processo de QA, como **organização, documentação, manutenção, evidências, relatórios, tratamento de falhas e versionamento**.

---

## 🎯 Objetivos

* Demonstrar conhecimentos em **Quality Assurance**.
* Aplicar técnicas de planejamento e design de testes.
* Criar e executar **casos de teste manuais**.
* Documentar cenários utilizando **BDD/Gherkin**.
* Identificar, registrar e documentar **bugs**.
* Automatizar cenários utilizando diferentes ferramentas e linguagens.
* Aplicar **Page Object Model (POM)**.
* Utilizar **fixtures** para organização e reutilização.
* Trabalhar com **variáveis de ambiente**.
* Gerar **relatórios automatizados**.
* Capturar evidências de execução.
* Demonstrar o tratamento de cenários de sucesso e falha.
* Utilizar **Git e GitHub** para versionamento e organização do projeto.

---

# 🧪 Testes Manuais

A primeira camada do projeto é composta pelos testes manuais, organizados por funcionalidade e documentados por meio de casos de teste, evidências e relatórios.

```text
Testes manuais/
├── CT001_Login/
├── CT002_Carrinho/
└── CT003_Filtro/
```

Cada módulo possui sua própria documentação, evidências de execução e relatório.

### 🔐 CT001 — Login

Os testes de login contemplam diferentes cenários, incluindo:

* Login válido;
* Usuário não cadastrado;
* Senha incorreta;
* Usuário em branco;
* Senha em branco;
* Usuário e senha em branco.

As execuções possuem evidências em **Chrome e Firefox**, permitindo documentar o comportamento da aplicação em diferentes navegadores.

### 🛒 CT002 — Carrinho

Os cenários contemplam:

* Adição de um produto;
* Adição de múltiplos produtos;
* Remoção de produto pela página de inventário;
* Remoção de produto diretamente pelo carrinho.

### 🔎 CT003 — Filtros

São avaliadas diferentes formas de ordenação dos produtos:

* Menor para maior preço;
* Maior para menor preço;
* A → Z;
* Z → A.

Além das evidências de execução, essa funcionalidade possui um **bug documentado**, utilizado posteriormente como referência para os cenários de falha das automações.

---

# 🐞 Bug Report

Durante a execução dos testes manuais foi identificado o:

### BUG-001 — Ordenação de produtos Z para A

O bug está documentado em:

```text
Testes manuais/
└── CT003_Filtro/
    └── Bugs/
        └── BUG-001.md
```

A documentação do bug contempla informações como:

* Caso de teste relacionado;
* Tipo do bug;
* Severidade;
* Prioridade;
* Ambiente;
* Passos para reprodução;
* Resultado esperado;
* Resultado atual;
* Evidências;
* Status;
* Data de abertura.

O problema está relacionado ao comportamento da aplicação ao selecionar o filtro **"Name (Z to A)"**.

Esse cenário foi utilizado como referência para demonstrar, nas automações, como uma falha pode ser **detectada, registrada e evidenciada automaticamente**.

---

# 📋 Casos de Teste e BDD

O projeto possui casos de teste em formato convencional e também cenários estruturados utilizando **BDD (Behavior Driven Development)**.

Os cenários BDD utilizam a sintaxe **Gherkin**, permitindo descrever o comportamento esperado da aplicação de maneira estruturada e próxima da linguagem natural.

O arquivo:

```text
Casos de Teste - BDD.xlsx
```

centraliza os cenários BDD utilizados como referência para as automações.

A abordagem BDD também foi incorporada diretamente às implementações com:

* **Playwright + TypeScript**
* **Selenium + Python + Behave**

Dessa forma, os cenários descritos durante a documentação manual também podem ser utilizados como base para a implementação automatizada.

---

# 🤖 Testes Automatizados

A pasta `Testes automatizados` concentra diferentes implementações dos mesmos fluxos funcionais.

```text
Testes automatizados/
├── Cypress/
├── Playwright/
├── Selenium/
└── Selenium em Python com BDD/
```

Essa estrutura permite demonstrar diferentes abordagens de automação utilizando diferentes linguagens, frameworks e arquiteturas.

Os mesmos fluxos funcionais são utilizados como referência para facilitar a comparação entre as implementações.

---

# 🟢 Cypress

A implementação com Cypress utiliza **JavaScript + Node.js**.

```text
Cypress/
├── cypress/
│   ├── e2e/
│   │   ├── login.cy.js
│   │   ├── carrinho.cy.js
│   │   └── filtro.cy.js
│   │
│   ├── fixtures/
│   ├── reports/
│   ├── screenshots/
│   └── support/
│
├── config-qa.js
├── cypress.config.js
├── package.json
└── jsconfig.json
```

Os testes estão separados por funcionalidade:

* `login.cy.js`
* `carrinho.cy.js`
* `filtro.cy.js`

A organização permite localizar e manter os cenários de forma independente.

A estrutura também utiliza:

* Fixtures;
* Configurações específicas;
* Support;
* Variáveis de ambiente;
* Screenshots;
* Reports.

---

## 📊 Relatórios com Cypress

A automação Cypress utiliza diferentes reporters para gerar resultados em formatos distintos:

* **Mochawesome**
* **JUnit XML**

O **Mochawesome** fornece um relatório HTML mais visual, facilitando a análise dos resultados da execução.

O **JUnit XML** gera um formato amplamente utilizado para integração com ferramentas de CI/CD.

As execuções também podem gerar **screenshots automaticamente**, permitindo utilizar as imagens como evidências dos testes.

---

# 🔵 Playwright

A implementação com Playwright utiliza:

* **TypeScript**
* **Playwright Test**
* **playwright-bdd**
* **dotenv**

Sua estrutura separa os cenários BDD, steps, Page Objects e fixtures:

```text
Playwright/
├── features/
│   ├── login.feature
│   ├── cart.feature
│   └── filtro.feature
│
├── steps/
│   ├── login.steps.ts
│   ├── cart.steps.ts
│   └── filtro.steps.ts
│
├── pages/
│   ├── login.page.ts
│   ├── cart_page.ts
│   └── inventory_page.ts
│
├── fixtures/
│   └── fixtures.ts
│
├── playwright.config.ts
├── package.json
└── tsconfig.json
```

### BDD com Playwright

Os arquivos `.feature` descrevem os comportamentos esperados utilizando Gherkin.

A arquitetura segue o fluxo:

```text
Feature
   ↓
Cenário
   ↓
Dado / Quando / Então
   ↓
Step Definition
   ↓
Page Object
   ↓
Playwright
```

A biblioteca `playwright-bdd` conecta os cenários BDD às implementações em TypeScript.

Isso permite separar:

* **O que deve ser testado** → `features`
* **Como o cenário é executado** → `steps`
* **Como a aplicação é manipulada** → `pages`
* **Como os objetos são disponibilizados** → `fixtures`

### Fixtures

O arquivo:

```text
fixtures/fixtures.ts
```

centraliza os Page Objects utilizados nos testes.

Entre eles:

* `LoginPage`
* `InventoryPage`
* `CartPage`

Essa abordagem reduz duplicação e facilita a manutenção dos testes.

### Relatórios e evidências

O Playwright está configurado para gerar **HTML Reports**.

A execução também pode gerar:

* Screenshots;
* Vídeos em caso de falha;
* Traces em caso de falha.

Essa combinação permite investigar uma execução malsucedida utilizando diferentes tipos de evidência.

---

# 🟡 Selenium com Java

A implementação com Selenium utiliza:

* **Java 17**
* **Selenium WebDriver 4.18.1**
* **JUnit 5**
* **Maven**
* **WebDriverManager**
* **ExtentReports**

A estrutura utiliza o conceito de **Page Object Model**:

```text
Selenium/
└── src/
    └── test/
        ├── java/
        │   ├── pages/
        │   │   ├── LoginPage.java
        │   │   ├── InventoryPage.java
        │   │   └── CartPage.java
        │   │
        │   ├── tests/
        │   │   ├── LoginTest.java
        │   │   ├── CartTest.java
        │   │   └── FiltroTest.java
        │   │
        │   └── utils/
        │       ├── ConfigManager.java
        │       ├── ReportManager.java
        │       └── ScreenshotUtils.java
        │
        └── resources/
            └── config.properties
```

### Page Object Model

As páginas possuem classes próprias para encapsular as interações com seus respectivos elementos:

```text
LoginPage
InventoryPage
CartPage
```

Essa separação evita concentrar localização de elementos, interações e validações dentro dos mesmos métodos de teste.

Como consequência, alterações na aplicação podem ser tratadas de maneira mais localizada.

### JUnit 5

Os testes estão organizados por funcionalidade:

```text
LoginTest
CartTest
FiltroTest
```

A implementação utiliza recursos do JUnit 5, incluindo:

* `@BeforeEach`
* `@AfterEach`
* `@BeforeAll`
* `@AfterAll`
* `@Test`

---

# 📊 Relatórios com Selenium Java

A implementação utiliza **ExtentReports** para geração de relatórios HTML.

A classe:

```text
ReportManager.java
```

centraliza a criação e gerenciamento dos relatórios.

Já:

```text
ScreenshotUtils.java
```

é responsável pela captura das evidências utilizando Selenium WebDriver.

As screenshots podem ser incorporadas ao relatório, permitindo relacionar diretamente uma falha ou resultado de teste à sua evidência visual.

---

# 🐍 Selenium com Python + BDD

A implementação com Python utiliza:

* **Python**
* **Selenium WebDriver**
* **Behave**
* **BDD/Gherkin**
* **python-dotenv**
* **Allure**

A estrutura separa cenários, steps e Page Objects:

```text
Selenium em Python com BDD/
├── features/
│   ├── login.feature
│   ├── cart.feature
│   ├── filtro.feature
│   ├── environment.py
│   │
│   └── steps/
│       ├── login_steps.py
│       ├── cart_steps.py
│       └── filtro_steps.py
│
├── pages/
│   ├── login_page.py
│   ├── inventory_page.py
│   └── cart_page.py
│
└── .env
```

### BDD com Behave

Os arquivos `.feature` descrevem os comportamentos esperados utilizando:

* `Given / Dado`
* `When / Quando`
* `Then / Então`

Os arquivos `*_steps.py` conectam os cenários Gherkin às ações executadas pelo Selenium.

Os Page Objects encapsulam as interações com a aplicação.

Essa estrutura mantém uma separação clara entre:

**Comportamento → Implementação → Elementos da aplicação**

---

# 📸 Evidências com Selenium Python

O arquivo:

```text
features/environment.py
```

centraliza o ciclo de vida do WebDriver.

Além de configurar o navegador, o `after_scenario` pode capturar automaticamente uma screenshot ao final do cenário e anexá-la ao **Allure Report**.

O encerramento do navegador também é tratado no ciclo de vida do teste, evitando que processos do WebDriver permaneçam abertos após a execução.

A configuração permite ainda executar o navegador em modo headless:

```text
HEADLESS=true
```

---

# ❌ Cenário de falha intencional

Um dos principais elementos demonstrativos do projeto é a utilização de um **cenário de falha intencional** nas diferentes implementações de automação.

O objetivo é demonstrar que uma suíte de testes não deve apenas validar cenários positivos, mas também ser capaz de **identificar, registrar e apresentar claramente uma condição inesperada**.

O cenário utilizado está relacionado ao filtro:

```text
Name (Z to A)
```

e ao comportamento identificado durante os testes manuais.

O usuário:

```text
error_user
```

disponibilizado pelo próprio SauceDemo, é utilizado nas implementações para reproduzir o comportamento associado ao cenário negativo.

### O cenário é reproduzido nas automações

A falha intencional é buscada nas diferentes implementações presentes no projeto:

```text
Cypress
   ↓
Playwright
   ↓
Selenium + Java
   ↓
Selenium + Python + BDD
```

Dessa maneira, o projeto permite observar como diferentes ferramentas lidam com **um mesmo comportamento inesperado**.

### O objetivo não é "quebrar" a suíte

A falha proposital existe para demonstrar o processo completo:

```text
Execução do teste
       ↓
Interação com a aplicação
       ↓
Validação do resultado esperado
       ↓
Resultado inesperado
       ↓
Assertion / validação falha
       ↓
Evidência é capturada
       ↓
Falha é registrada no relatório
```

Dependendo da ferramenta, são disponibilizados diferentes tipos de evidência, como:

* Screenshots;
* HTML Reports;
* JUnit XML;
* ExtentReports;
* Allure;
* Vídeos;
* Traces.

Esse cenário permite demonstrar, na prática, não apenas **como escrever uma automação**, mas também **como analisar o resultado de uma execução malsucedida**.

---

# 🔐 Variáveis de ambiente e configuração

As automações utilizam **variáveis de ambiente** para armazenar informações de configuração utilizadas durante a execução.

Por isso, após clonar o projeto, **é necessário criar o arquivo `.env` antes de executar os scripts que dependem dessas variáveis**.

> ⚠️ **Os arquivos `.env` não são versionados no GitHub e devem ser criados localmente.**

A estrutura utiliza arquivos de configuração diferentes dependendo da tecnologia:

```text
Cypress/
└── .env.dev

Playwright/
└── .env

Selenium em Python com BDD/
└── .env
```

Os arquivos devem ser preenchidos de acordo com as variáveis utilizadas por cada implementação.

### Exemplo

Crie o arquivo `.env` dentro da pasta correspondente à automação e informe as configurações necessárias:

```env
BASE_URL=https://www.saucedemo.com
USERNAME=standard_user
PASSWORD=sua_senha
HEADLESS=false
```

> **Importante:** os nomes das variáveis devem corresponder aos utilizados na configuração de cada stack.

### Por que utilizar `.env`?

Essa abordagem evita inserir diretamente no código:

* URLs de ambiente;
* credenciais;
* senhas;
* configurações específicas de execução.

Além disso, o `.gitignore` impede que arquivos `.env` sejam enviados acidentalmente ao repositório.

---

# 🗂️ Estrutura geral do projeto

```text
SauceDemo QA
│
├── Casos de Teste - BDD.xlsx
│
├── Testes manuais/
│   ├── CT001_Login/
│   ├── CT002_Carrinho/
│   └── CT003_Filtro/
│
└── Testes automatizados/
    │
    ├── Cypress/
    │   ├── e2e/
    │   ├── fixtures/
    │   ├── reports/
    │   ├── screenshots/
    │   └── support/
    │
    ├── Playwright/
    │   ├── features/
    │   ├── steps/
    │   ├── pages/
    │   └── fixtures/
    │
    ├── Selenium/
    │   └── Selenium/
    │       └── src/test/
    │           ├── java/pages/
    │           ├── java/tests/
    │           ├── java/utils/
    │           └── resources/
    │
    └── Selenium em Python com BDD/
        ├── features/
        │   └── steps/
        └── pages/
```

A organização separa claramente:

* Documentação;
* Testes manuais;
* Testes automatizados;
* Page Objects;
* Cenários BDD;
* Steps;
* Fixtures;
* Configurações;
* Evidências;
* Relatórios.

Essa separação facilita a navegação pelo projeto e permite que cada tecnologia mantenha sua própria estrutura sem interferir nas demais.

---

# 🛠️ Tecnologias e ferramentas

### 🧪 Testes e Automação

* Cypress
* Playwright
* Selenium WebDriver
* JUnit 5
* Behave
* BDD / Gherkin

### 💻 Linguagens

* Java
* Python
* JavaScript
* TypeScript

### 📊 Relatórios

* Mochawesome
* JUnit XML
* ExtentReports
* Playwright HTML Report
* Allure

### 📦 Build e gerenciamento

* Node.js
* npm
* Maven
* WebDriverManager

### 🔧 Configuração

* dotenv
* `.env`
* `config.properties`

### 🗃️ Versionamento

* Git
* GitHub

---

# ▶️ Configuração e execução

## 1. Clone o repositório

```bash
git clone https://github.com/gblsouza8/saucedemo-qa.git
```

Entre no diretório:

```bash
cd saucedemo-qa
```

---

## 2. Configure as variáveis de ambiente

Antes de executar as automações, crie os arquivos `.env` necessários dentro das respectivas pastas.

Exemplo:

```text
Testes automatizados/
├── Cypress/
│   └── .env.dev
│
├── Playwright/
│   └── .env
│
└── Selenium em Python com BDD/
    └── .env
```

Preencha os valores de acordo com a configuração de cada implementação.

**Não utilize ou publique credenciais reais no repositório.**

---

# 🟢 Executando o Cypress

Entre no diretório:

```bash
cd "Testes automatizados/Cypress"
```

Instale as dependências:

```bash
npm install
```

Execute no Chrome:

```bash
npm run run:chrome
```

Execute no Firefox:

```bash
npm run run:firefox
```

Abra a interface do Cypress:

```bash
npm run open:qa
```

Após a execução, consulte os relatórios e evidências gerados nos diretórios correspondentes.

---

# 🔵 Executando o Playwright

Entre no diretório:

```bash
cd "Testes automatizados/Playwright"
```

Instale as dependências:

```bash
npm install
```

Execute os testes:

```bash
npm test
```

Visualize o relatório:

```bash
npm run report
```

O Playwright pode gerar screenshots, vídeos e traces de acordo com a configuração do projeto.

---

# 🟡 Executando o Selenium + Java

Entre no diretório Maven:

```bash
cd "Testes automatizados/Selenium/Selenium"
```

Execute:

```bash
mvn test
```

As dependências são gerenciadas pelo `pom.xml`.

Entre elas estão:

* Selenium WebDriver;
* JUnit 5;
* WebDriverManager;
* ExtentReports.

---

# 🐍 Executando o Selenium + Python + BDD

Entre no diretório:

```bash
cd "Testes automatizados/Selenium em Python com BDD"
```

Certifique-se de criar e configurar o `.env` antes da execução.

A suíte utiliza:

* Behave para execução dos cenários BDD;
* Selenium WebDriver para interação com o navegador;
* Page Objects para organização;
* Allure para relatórios;
* Screenshots como evidências.

---

# 📊 Estratégia de relatórios e evidências

O projeto busca demonstrar que a automação não termina quando o navegador é fechado.

Cada stack possui uma estratégia própria para apresentar os resultados:

| Stack           | Relatório               | Evidências                 |
| --------------- | ----------------------- | -------------------------- |
| Cypress         | Mochawesome + JUnit XML | Screenshots                |
| Playwright      | HTML Report             | Screenshots, vídeo e trace |
| Selenium Java   | ExtentReports           | Screenshots                |
| Selenium Python | Allure                  | Screenshots                |
| Testes Manuais  | Relatórios em PDF       | Evidências e GIFs          |

Essa abordagem permite analisar:

**o que foi executado → qual foi o resultado → onde ocorreu a falha → qual evidência foi gerada.**

---

# 🧠 Práticas aplicadas

O projeto busca aplicar práticas comuns em ambientes profissionais de QA:

* Planejamento de testes;
* Organização por funcionalidade;
* Casos de teste convencionais;
* BDD/Gherkin;
* Page Object Model;
* Fixtures;
* Separação entre cenário e implementação;
* Reutilização de componentes;
* Centralização de configurações;
* Variáveis de ambiente;
* Assertions;
* Evidências automatizadas;
* Relatórios de execução;
* Tratamento de falhas;
* Documentação de bugs;
* Testes cross-browser;
* Versionamento com Git;
* Separação de código-fonte e artefatos gerados.

---

# 📈 Status do projeto

### QA Manual

* [x] Planejamento de testes
* [x] Casos de teste tradicionais
* [x] Casos de teste em BDD
* [x] Execução manual
* [x] Evidências
* [x] Relatórios de execução
* [x] Bug report
* [x] Testes em Chrome
* [x] Testes em Firefox

### Automação

* [x] Cypress
* [x] Playwright
* [x] Selenium + Java
* [x] Selenium + Python
* [x] BDD com Selenium Python
* [x] BDD com Playwright
* [x] Page Object Model
* [x] Fixtures
* [x] Screenshots
* [x] Relatórios HTML
* [x] JUnit XML
* [x] ExtentReports
* [x] Allure
* [x] Tratamento de falhas
* [x] Variáveis de ambiente

---

# 👨‍💻 Autor

**Gabriel Souza**

Projeto desenvolvido como portfólio prático de **Quality Assurance**, reunindo testes manuais, automação, BDD, documentação, evidências, relatórios e diferentes tecnologias de automação.

---

⭐ Se este projeto foi útil ou interessante, considere deixar uma estrela no repositório.
