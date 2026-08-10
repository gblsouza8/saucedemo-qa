import { test as base, createBdd } from 'playwright-bdd';
import { LoginPage } from '../pages/login.page';
import { InventoryPage } from '../pages/inventory_page';
import { CartPage } from "../pages/cart_page";

type MinhasFixtures = {
  loginPage: LoginPage;
  inventoryPage: InventoryPage;
  cartPage: CartPage;
};

export const test = base.extend<MinhasFixtures>({
  loginPage: async ({ page }, use) => {
    await use(new LoginPage(page));
  },

  inventoryPage: async ({page}, use) => {
    await use(new InventoryPage(page));
  },

  cartPage: async({page}, use) => {
    await use(new CartPage(page));
  },
});

export const { Given, When, Then } = createBdd(test);