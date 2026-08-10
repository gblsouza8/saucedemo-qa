import { Page, Locator, expect } from '@playwright/test';

export class InventoryPage
{
    readonly page: Page;
    readonly filtro: Locator;
    readonly nomeItens: Locator;
    readonly valoresItens: Locator;
    readonly iconeCarrinho: Locator;
    readonly botaoAdicionar1: Locator;
    readonly botaoAdicionar2: Locator;
    readonly botaoRemover1: Locator;


    constructor(page: Page)
    {
        this.page = page;
        this.filtro = page.getByTestId('product-sort-container');
        this.nomeItens = page.getByTestId('inventory-item-name');
        this.valoresItens = page.getByTestId('inventory-item-price');
        this.iconeCarrinho = page.getByTestId('shopping-cart-link');
        this.botaoAdicionar1 = page.getByTestId('add-to-cart-sauce-labs-backpack');
        this.botaoAdicionar2 = page.getByTestId('add-to-cart-sauce-labs-bike-light');
        this.botaoRemover1 = page.getByTestId('remove-sauce-labs-backpack');
    }

    async adicionarItem()
    {
        await this.botaoAdicionar1.click();
    }

    async adicionarDoisItens()
    {
        await this.botaoAdicionar1.click();
        await this.botaoAdicionar2.click();
    }

    async navegarCarrinho()
    {
        await this.iconeCarrinho.click();
    }

    async selecionarSlot(filtro: string)
    {
        await this.filtro.selectOption({label: filtro});
    }

    async obter_nomes()
    {
        return await this.nomeItens.allInnerTexts();
    }

    async validarAlfabetica()
    {
        const nomes = await this.obter_nomes()
        const nomesOrdenados = [...nomes].sort((a, b) => a.localeCompare(b));
        return nomes.every((nome,index) => nome === nomesOrdenados[index]);

    }

    async validarAlfabeticaInversa()
    {
        const nomes = await this.obter_nomes()
        const nomesOrdenados = [...nomes].sort((a, b) => a.localeCompare(b));
        return nomes.every((nome,index) => nome === nomesOrdenados[index]);
    }

    async obter_valores()
    {
        const textos = await this.valoresItens.allInnerTexts();
        return textos.map(texto => parseFloat(texto.replace('$', '').trim()));
    }


    async estaEmOrdemCrescente() {
        const valores = await this.obter_valores();
        const valoresOrdenados = [...valores].sort((a, b) => a - b);

        return valores.every((valor, index) => valor === valoresOrdenados[index]);
    }

    async estaEmOrdemDecrescente() {
        const valores = await this.obter_valores();
        const valoresOrdenados = [...valores].sort((b, a) => a - b);

        return valores.every((valor, index) => valor === valoresOrdenados[index]);
    }

    async removerItem()
    {
        await this.botaoRemover1.click();
    }
}