# 🧪 SauceDemo QA

<p align="center">

![GitHub last commit](https://img.shields.io/github/last-commit/gblsouza8/saucedemo-qa?style=for-the-badge)
![GitHub repo size](https://img.shields.io/github/repo-size/gblsouza8/saucedemo-qa?style=for-the-badge)
![Status](https://img.shields.io/badge/status-Finalizado-success?style=for-the-badge)

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

Utilizando o [SauceDemo](https://www.saucedemo.com/) como aplicação sob teste, o projeto reúne **testes manuais, documentação, evidências, reporte de bugs e múltiplas abordagens de automação**, permitindo comparar diferentes ferramentas, linguagens e arquiteturas de testes.

O projeto foi construído de forma incremental, reaproveitando os mesmos fluxos funcionais em diferentes estratégias de automação:

* 🔐 Login
* 🛒 Carrinho
* 🔎 Filtros e ordenação de produtos

A proposta é demonstrar não apenas a execução de testes, mas também a **organização, manutenção, documentação, geração de evidências e análise dos resultados**.

---

## 🎯 Objetivos

* Demonstrar conhecimentos em **Quality Assurance**.
* Aplicar técnicas de **test design** e planejamento de testes.
* Criar e executar **casos de teste manuais**.
* Documentar cenários utilizando **BDD/Gherkin**.
* Registrar e documentar **bugs encontrados**.
* Automatizar cenários utilizando diferentes ferramentas.
* Aplicar **Page Object Model (POM)**.
* Trabalhar com **variáveis de ambiente** e separação de configurações.
* Gerar **relatórios automatizados**.
* Capturar evidências de execução.
* Demonstrar tratamento de cenários de sucesso e falha.
* Utilizar **Git e GitHub** para versionamento e organização do projeto.

---

# 🧪 Testes Manuais

A primeira camada do projeto é composta pelos testes manuais, organizados por funcionalidade e identificados por casos de teste.

```text
Testes manuais/
├── CT001_Login/
├── CT002_Carrinho/
└── CT003_Filtro/
```

Cada módulo possui sua própria documentação, evidências e relatório de execução.

### 🔐 CT001 — Login

Inclui cenários relacionados a:

* Login válido;
* Usuário não cadastrado;
* Senha incorreta;
* Usuário em branco;
* Senha em branco;
* Usuário e senha em branco.

As execuções possuem evidências em **Chrome e Firefox**, permitindo registrar o comportamento da aplicação em diferentes navegadores.

### 🛒 CT002 — Carrinho

Os cenários contemplam:

* Adição de um produto;
* Adição de múltiplos produtos;
* Remoção de produto pela página de inventário;
* Remoção de produto diretamente pelo carrinho.

### 🔎 CT003 — Filtros

São avaliadas diferentes formas de ordenação:

* Menor para maior preço;
* Maior para menor preço;
* A → Z;
* Z → A.

Além das evidências de execução, essa funcionalidade também possui um **bug documentado**.

---

# 🐞 Bug Report

Durante a execução dos testes manuais foi identificado o:

### BUG-001 — Ordenação de produtos Z para A não funciona

O bug está documentado em:

```text
Testes manuais/
└── CT003_Filtro/
    └── Bugs/
        └── BUG-001.md
```

O relatório contém:

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

O problema ocorre ao selecionar o filtro **"Name (Z to A)"**, no qual a aplicação apresenta comportamento inesperado em vez de realizar a ordenação alfabética inversa.

Esse mesmo comportamento foi posteriormente utilizado como referência para demonstrar o tratamento de **falhas na automação**.

---

# 📋 Casos de Teste e BDD

O projeto possui documentação de casos de teste em formato tradicional e também cenários estruturados utilizando **BDD (Behavior Driven Development)**.

Os cenários BDD utilizam a sintaxe **Gherkin**, permitindo descrever o comportamento esperado da aplicação de forma estruturada e próxima da linguagem natural.

O arquivo:

```text
Casos de Teste - BDD.xlsx
```

centraliza os cenários BDD utilizados como base para a evolução das automações.

A utilização de BDD também foi incorporada diretamente às automações com **Selenium + Python** e **Playwright**, permitindo manter a descrição dos comportamentos separada da implementação técnica dos passos.

---

# 🤖 Automação de Testes

A pasta `Testes automatizados` concentra diferentes implementações dos mesmos fluxos funcionais.

```text
Testes automatizados/
├── Cypress/
├── Playwright/
├── Selenium/
└── Selenium em Python com BDD/
```

Essa organização permite demonstrar conhecimento em diferentes ferramentas, linguagens e arquiteturas de automação.

---

# 🟢 Cypress

A implementação com Cypress utiliza **JavaScript + Node.js** e possui uma estrutura organizada por responsabilidade.

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

### Estrutura dos testes

Os testes estão separados por funcionalidade:

* `login.cy.js`
* `carrinho.cy.js`
* `filtro.cy.js`

Cada arquivo contém os cenários relacionados à sua respectiva funcionalidade.

Os testes utilizam comandos do Cypress, assertions e seletores baseados nos atributos `data-test` disponibilizados pela aplicação.

### Evidências

O Cypress realiza captura automática de screenshots durante a execução dos cenários, permitindo preservar o estado final do teste como evidência.

As evidências incluem cenários de sucesso e também cenários que apresentam falha.

---

# 📊 Relatórios com Cypress

A automação com Cypress utiliza múltiplos reporters:

* **Mochawesome**
* **Mocha JUnit Reporter**

O Mochawesome permite gerar um relatório HTML mais visual, incluindo gráficos e screenshots incorporados.

O JUnit gera arquivos XML adequados para integração com ferramentas de CI/CD e pipelines automatizados.

Configuração utilizada:

```text
cypress-multi-reporters
├── cypress-mochawesome-reporter
└── mocha-junit-reporter
```

Essa abordagem demonstra a utilização de diferentes formatos de relatório para diferentes necessidades de análise e integração.

---

# 🔵 Playwright

A implementação com Playwright utiliza:

* **TypeScript**
* **Playwright Test**
* **playwright-bdd**
* **dotenv**

A estrutura foi organizada para separar claramente os cenários BDD, steps, Page Objects e fixtures.

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

Os cenários são escritos em arquivos `.feature` utilizando Gherkin:

```text
Funcionalidade
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

A biblioteca `playwright-bdd` é responsável por conectar os cenários BDD às implementações TypeScript.

Isso permite separar:

* **O que deve ser testado** → `.feature`
* **Como o cenário é executado** → `steps`
* **Como a aplicação é manipulada** → `pages`
* **Como os objetos são disponibilizados aos testes** → `fixtures`

### Fixtures

O arquivo:

```text
fixtures/fixtures.ts
```

centraliza os Page Objects utilizados pelos testes, disponibilizando instâncias de:

* `LoginPage`
* `InventoryPage`
* `CartPage`

Essa abordagem reduz repetição e facilita a manutenção dos testes.

### Relatórios e evidências

O Playwright está configurado para gerar **HTML Reports**.

Além disso, a configuração contempla:

* Screenshots;
* Vídeos em caso de falha;
* Traces em caso de falha.

Configuração:

```text
screenshot: 'on'
video: 'retain-on-failure'
trace: 'retain-on-failure'
```

Isso permite investigar uma execução malsucedida utilizando diferentes níveis de evidência.

---

# 🟡 Selenium com Java

A implementação com Selenium utiliza:

* **Java 17**
* **Selenium WebDriver 4.18.1**
* **JUnit 5**
* **Maven**
* **WebDriverManager**
* **ExtentReports**

A estrutura segue uma organização baseada em **Page Object Model**:

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

As páginas possuem classes próprias responsáveis pela interação com seus respectivos elementos.

Por exemplo:

```text
LoginPage
InventoryPage
CartPage
```

Essa separação evita que os testes concentrem simultaneamente:

* localização dos elementos;
* interação com a aplicação;
* regras de validação.

Como consequência, alterações nos elementos da aplicação podem ser tratadas de forma mais localizada.

### Testes

Os cenários estão separados em:

```text
LoginTest
CartTest
FiltroTest
```

A estrutura utiliza JUnit 5 para organização do ciclo de vida dos testes, incluindo:

* `@BeforeEach`
* `@AfterEach`
* `@BeforeAll`
* `@AfterAll`
* `@Test`

---

# 📊 Relatórios com Selenium Java

A automação Selenium + Java utiliza **ExtentReports** para gerar relatórios HTML.

A classe:

```text
ReportManager.java
```

centraliza a criação e gerenciamento do relatório.

Já:

```text
ScreenshotUtils.java
```

é responsável pela captura das evidências utilizando Selenium WebDriver e conversão para **Base64**, permitindo incorporar as imagens diretamente ao relatório.

Dessa forma, o relatório consegue apresentar:

* Nome do teste;
* Resultado;
* Mensagem de execução;
* Screenshot;
* Evidência associada ao cenário.

---

# ❌ Falha intencional — Z → A

Um dos destaques da automação Selenium com Java é o tratamento de uma **falha intencional**.

No cenário:

```text
filtroZA()
```

o teste utiliza propositalmente o usuário:

```text
error_user
```

disponibilizado pelo SauceDemo.

O objetivo não é fazer o teste "passar a qualquer custo", mas demonstrar como uma automação deve se comportar quando encontra um resultado inesperado.

O fluxo implementado:

```text
Execução do cenário
        ↓
Seleção do filtro Z → A
        ↓
Validação da ordenação
        ↓
Assertion falha
        ↓
Screenshot é capturado
        ↓
ExtentReports registra o teste como FAIL
        ↓
A exceção é lançada novamente
```

O tratamento `try/catch` permite registrar a falha e anexar a evidência ao relatório antes de propagar a exceção.

Isso torna o comportamento da falha **observável, documentado e rastreável**.

---

# 🐍 Selenium com Python + BDD

O projeto também possui uma implementação utilizando:

* **Python**
* **Selenium WebDriver**
* **Behave**
* **BDD/Gherkin**
* **python-dotenv**
* **Allure**

A estrutura é dividida entre cenários BDD, steps e Page Objects:

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

### BDD

Os arquivos `.feature` descrevem os comportamentos esperados utilizando:

* `Dado`
* `Quando`
* `Então`

Os arquivos `*_steps.py` fazem a ligação entre os cenários Gherkin e a implementação Selenium.

Essa abordagem reforça a separação entre **especificação do comportamento** e **implementação técnica**.

### Page Objects

As classes:

```text
LoginPage
InventoryPage
CartPage
```

encapsulam as interações com a aplicação, seguindo o mesmo princípio de separação utilizado na implementação Selenium com Java.

---

# 📸 Evidências com Selenium Python

O arquivo:

```text
features/environment.py
```

centraliza o ciclo de vida do WebDriver.

Além de criar e configurar o navegador, o `after_scenario` captura automaticamente uma screenshot ao final do cenário e a anexa ao **Allure Report**.

O navegador também é encerrado em um bloco `finally`, garantindo o fechamento do WebDriver mesmo quando ocorre uma exceção.

A configuração também permite executar o navegador em modo:

```text
HEADLESS=true
```

ou com interface gráfica.

---

# 🔐 Configuração e variáveis de ambiente

O projeto utiliza arquivos `.env` e arquivos de configuração separados para evitar que credenciais e configurações específicas do ambiente sejam diretamente inseridas nos testes.

Exemplos utilizados:

```text
Cypress/
└── .env.dev

Playwright/
└── .env

Selenium em Python com BDD/
└── .env
```

As configurações são carregadas pelas respectivas ferramentas, mantendo informações como URL e senha fora do código de teste.

O `.gitignore` também possui regras para impedir o versionamento de:

* `.env`;
* arquivos de ambiente;
* `node_modules`;
* `target`;
* relatórios locais;
* screenshots gerados;
* vídeos;
* caches;
* arquivos temporários;
* artefatos de IDE.

Essa separação contribui para uma estrutura mais segura e adequada ao versionamento.

> **Importante:** os arquivos `.env` não devem ser enviados ao repositório. Para executar o projeto, crie seus próprios arquivos de ambiente localmente.

---

# 🗂️ Arquitetura geral

A organização atual do projeto pode ser resumida da seguinte forma:

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

A separação por ferramenta permite manter cada stack independente, enquanto os mesmos fluxos funcionais servem como base para comparação entre as diferentes abordagens.

---

# 🛠️ Tecnologias e ferramentas

### Testes e Automação

* Cypress
* Playwright
* Selenium WebDriver
* JUnit 5
* Behave
* BDD / Gherkin

### Linguagens

* Java
* Python
* JavaScript
* TypeScript

### Relatórios

* Mochawesome
* JUnit XML
* ExtentReports
* Playwright HTML Report
* Allure

### Build e gerenciamento

* Node.js / npm
* Maven
* WebDriverManager

### Organização e versionamento

* Git
* GitHub
* Visual Studio Code
* IntelliJ IDEA
* Microsoft Excel
* PDF

---

# ▶️ Como executar

## Cypress

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

---

## Playwright

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

Visualize o relatório HTML:

```bash
npm run report
```

---

## Selenium + Java

Entre no diretório Maven:

```bash
cd "Testes automatizados/Selenium/Selenium"
```

Execute os testes:

```bash
mvn test
```

As dependências são gerenciadas pelo `pom.xml`, incluindo Selenium, JUnit, WebDriverManager e ExtentReports.

O WebDriverManager auxilia no gerenciamento do driver do navegador.

---

## Selenium + Python + BDD

Entre no diretório:

```bash
cd "Testes automatizados/Selenium em Python com BDD"
```

Configure as variáveis de ambiente no `.env` antes da execução.

A suíte utiliza **Behave** para execução dos cenários BDD e **Selenium WebDriver** para interação com o navegador.

---

# 📊 Estratégia de evidências e relatórios

Um dos principais objetivos do projeto é não limitar a automação à simples execução de `PASS` ou `FAIL`.

Cada stack utiliza diferentes mecanismos de observabilidade:

| Stack           | Relatório               | Evidências                           |
| --------------- | ----------------------- | ------------------------------------ |
| Cypress         | Mochawesome + JUnit XML | Screenshots                          |
| Playwright      | HTML Report             | Screenshots, vídeo e trace em falhas |
| Selenium Java   | ExtentReports           | Screenshots incorporadas em Base64   |
| Selenium Python | Allure                  | Screenshots anexadas aos cenários    |
| Testes Manuais  | PDFs                    | GIFs e documentação                  |

Essa abordagem permite analisar não apenas **se o teste passou ou falhou**, mas também **o que aconteceu durante a execução**.

---

# 🧠 Práticas aplicadas

O projeto busca aplicar princípios comuns em projetos profissionais de QA:

* Organização dos testes por funcionalidade;
* Separação entre testes manuais e automatizados;
* Page Object Model;
* BDD/Gherkin;
* Separação entre cenário e implementação;
* Reutilização de componentes;
* Fixtures;
* Centralização de configurações;
* Variáveis de ambiente;
* Assertions;
* Evidências automatizadas;
* Relatórios de execução;
* Tratamento de falhas;
* Versionamento com Git;
* Documentação de bugs;
* Separação de artefatos gerados e código-fonte;
* Estrutura preparada para evolução e manutenção.

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

# 🚀 Próximos passos

O projeto continua em evolução e poderá receber novas funcionalidades, cenários e ferramentas.

Algumas possibilidades futuras incluem:

* [ ] Testes de API
* [ ] Integração com CI/CD
* [ ] Execução automatizada via GitHub Actions
* [ ] Expansão da cobertura funcional
* [ ] Testes cross-browser mais amplos
* [ ] Melhorias nos relatórios
* [ ] Novos cenários negativos e de regressão
* [ ] Integração de diferentes suítes em pipelines automatizados

---

# 👨‍💻 Autor

**Gabriel Souza**

Projeto desenvolvido como portfólio prático de **Quality Assurance**, reunindo testes manuais, automação, BDD, documentação, evidências, relatórios e diferentes tecnologias de automação.

---

⭐ Se este projeto foi útil ou interessante, considere deixar uma estrela no repositório.
