import { Given, When, Then } from '../fixtures/fixtures';
import { LoginPage } from '../pages/login.page';
import { InventoryPage } from '../pages/inventory_page'
import { expect } from '@playwright/test';
import { CartPage } from '../pages/cart_page';

Given('que o usuário esteja logado', async ({loginPage}) => {
    await loginPage.abrir_pagina();
    await loginPage.preencherUsername('standard_user');
    await loginPage.preencherSenha();
    await loginPage.clicarBotaoEntrar();
});

When('o usuário apertar em Add to cart', async ({inventoryPage}) => {
    await inventoryPage.adicionarItem();
});

Then('o produto deve estar no carrinho', async ({inventoryPage, cartPage}) => {
    await inventoryPage.navegarCarrinho();
    expect (await cartPage.itemNoCarrinho()).toBe(true);
});

When('o usuário apertar em Add to cart em dois produtos', async ({inventoryPage}) => {
    await inventoryPage.adicionarDoisItens();
});

Then('os produtos devem estar no carrinho', async ({inventoryPage, cartPage}) => {
    await inventoryPage.navegarCarrinho();
    expect (await cartPage.doisItensCarrinho()).toBe(true);
});

Given('já tenha um produto no carrinho', async ({inventoryPage}) => {
    await inventoryPage.adicionarItem();
});

When('o usuário apertar em Remove', async ({inventoryPage}) => {
    await inventoryPage.removerItem();
});

Then('o produto deve sumir do carrinho', async ({inventoryPage, cartPage}) => {
    await inventoryPage.navegarCarrinho();
    expect (await cartPage.itemNoCarrinho()).toBe(false);
});

Given('que o usuário esteja na página cart com um produto adicionado', async ({loginPage, inventoryPage}) => {
    await loginPage.abrir_pagina();
    await loginPage.preencherUsername('standard_user');
    await loginPage.preencherSenha();
    await loginPage.clicarBotaoEntrar();

    await inventoryPage.adicionarItem();
    await inventoryPage.navegarCarrinho();
});

When('o usuário apertar em Remove no carrinho', async ({cartPage}) => {
    await cartPage.clicarRemover();
});

Then('o produto escolhido deve desaparecer da página', async ({cartPage}) => {
    expect (await cartPage.itemNoCarrinho()).toBe(false);
});