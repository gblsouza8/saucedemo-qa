import { Given, When, Then } from '../fixtures/fixtures';
import { LoginPage } from '../pages/login.page';

Given('que o usuário navega até a página de login', async ({loginPage}) => {
    await loginPage.abrir_pagina();
});

When('insere o usuário {string} e a senha do ambiente', async ({ loginPage }, usuarioInvalido: string) => {
    await loginPage.preencherUsername(usuarioInvalido);
    await loginPage.preencherSenha();
});

When('clica no botão entrar', async ({loginPage}) => 
{
    await loginPage.clicarBotaoEntrar();
});

Then('exibir mensagem de erro {string}', async ({loginPage}, mensagem: string) => {
    await loginPage.validarErro(mensagem);
});

When('inserir o usuário {string} e apertar em login', async ({loginPage}, usuario: string) => {
    await loginPage.preencherUsername(usuario);
    await loginPage.clicarBotaoEntrar();
});

When('inserir a senha do ambiente', async ({loginPage}) => {
    await loginPage.preencherSenha();
})

When('inserir o usuário {string} e a senha {string}', async ({loginPage}, usuario: string, senha: string) => {
    await loginPage.preencherUsername(usuario);
    await loginPage.preencherSenha(senha);
})

Then('deve ser direcionado para a página {string}', async ({loginPage}, url: string) => {
    await loginPage.validarUrl(url);
})