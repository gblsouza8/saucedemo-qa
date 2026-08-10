import { Given, When, Then } from '../fixtures/fixtures';
import { LoginPage } from '../pages/login.page';
import { InventoryPage } from '../pages/inventory_page'
import { expect } from '@playwright/test';

Given('que o usuário esteja na página inventory', async ({loginPage}) => {
    await loginPage.abrir_pagina();
    await loginPage.preencherUsername('standard_user');
    await loginPage.preencherSenha();
    await loginPage.clicarBotaoEntrar();
});

When('selecionar o filtro {string}', async ({inventoryPage}, filtro: string) => {
    await inventoryPage.selecionarSlot(filtro);
});

Then('os produtos devem ser ordenados do menor preço para o maior preço', async ({inventoryPage}) => {
    const estaOrdenado = await inventoryPage.estaEmOrdemCrescente();
    expect(estaOrdenado).toBe(true);
});

Then('os produtos devem ser ordenados do maior preço para o menor preço', async ({inventoryPage}) => {
    const estaOrdenado = await inventoryPage.estaEmOrdemDecrescente();
    expect(estaOrdenado).toBe(true);
});

Then('os produtos devem ser ordenados em ordem alfabética', async ({inventoryPage}) => {
    const estaOrdenado = await inventoryPage.validarAlfabetica();
    expect(estaOrdenado).toBe(true);
});

Given('que o usuário esteja na página inventoryy', async ({loginPage}) => {
    await loginPage.abrir_pagina();
    await loginPage.preencherUsername('problem_user');
    await loginPage.preencherSenha();
    await loginPage.clicarBotaoEntrar();
});

Then('os produtos devem ser ordenados em ordem alfabética inversa', async ({inventoryPage}) => {
    const estaOrdenado = await inventoryPage.validarAlfabeticaInversa();
    expect(estaOrdenado).toBe(false);
});