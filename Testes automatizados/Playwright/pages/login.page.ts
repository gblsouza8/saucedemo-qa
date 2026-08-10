import { Page, Locator, expect } from '@playwright/test';

export class LoginPage {
  readonly page: Page;
  readonly usuarioInput: Locator;
  readonly senhaInput: Locator;
  readonly botaoLogin: Locator;
  readonly errorMsg: Locator;


  constructor(page: Page) {
    this.page = page;
    // Usa locators com getByTestId ajustados ao data-test da aplicação
    this.usuarioInput = page.getByTestId('username');
    this.senhaInput = page.getByTestId('password');
    this.botaoLogin = page.getByTestId('login-button');
    this.errorMsg = page.getByTestId('error')
  }

  async abrir_pagina()
  {
    await this.page.goto('/');
  }

  async preencherUsername(usuario: string)
  {
    await this.usuarioInput.fill(usuario);
  }

  async preencherSenha(senha = process.env.PASSWORD)
  {
    if (!senha)
    {
        throw new Error('Credenciais não foram configuradas no arquivo .env')
    }
    await this.senhaInput.fill(senha);
  }

  async clicarBotaoEntrar()
  {
    await this.botaoLogin.click();
  }

  async validarErro(trechoEsperado: string)
  {
    await expect(this.errorMsg).toContainText(trechoEsperado);
  }

  async validarUrl(caminhoEsperado: string)
  {
    await expect(this.page).toHaveURL(new RegExp(caminhoEsperado));
  }
}