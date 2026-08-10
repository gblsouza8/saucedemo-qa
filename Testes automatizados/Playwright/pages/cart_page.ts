import { Page, Locator, expect } from '@playwright/test';

export class CartPage
{
    readonly page: Page;
    readonly botaoRemover: Locator;
    readonly itemCarrinho: Locator;


    constructor(page: Page)
    {
        this.page = page;
        this.botaoRemover = page.getByTestId('remove-sauce-labs-backpack');
        this.itemCarrinho = page.getByTestId('inventory-item-name');
    }

    async clicarRemover()
    {
        await this.botaoRemover.click();
    }

    async itemNoCarrinho()
    {
        const qtd = await this.itemCarrinho.count();
        return qtd > 0;
    }

    async doisItensCarrinho()
    {
        const qtd = await this.itemCarrinho.count();
        return qtd > 1;
    }
};