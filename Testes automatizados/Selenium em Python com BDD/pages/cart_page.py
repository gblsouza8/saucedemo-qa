from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select

class CartPage:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(self.driver, 10)
        self.BOTAO_REMOVER = (By.CSS_SELECTOR, '[data-test="remove-sauce-labs-backpack"]')
        self.ITEM_CARRINHO = (By.CSS_SELECTOR, '[data-test="inventory-item-name"]')


    def clicarRemover(self):
        self.driver.find_element(*self.BOTAO_REMOVER).click()

    def verificarItem(self):
        elementos = self.driver.find_elements(*self.ITEM_CARRINHO)
        return len(elementos) > 0

    def verificarDoisItens(self):
        elementos = self.driver.find_elements(*self.ITEM_CARRINHO)
        return len(elementos) > 1


    