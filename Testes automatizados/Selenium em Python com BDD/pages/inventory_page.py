from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import Select

class InventoryPage:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(self.driver, 10)
        self.FILTRO_SELECTOR = (By.CSS_SELECTOR, '[data-test="product-sort-container"]')
        self.NOMES_ITENS = (By.CSS_SELECTOR, '[data-test="inventory-item-name"]')
        self.VALORES_ITENS = (By.CSS_SELECTOR, '[data-test="inventory-item-price"]')
        self.ICONE_CARRINHO = (By.CSS_SELECTOR, '[data-test="shopping-cart-link"]')
        self.ADICIONAR_ITEM_1 = (By.CSS_SELECTOR, '[data-test="add-to-cart-sauce-labs-backpack"]')
        self.ADICIONAR_ITEM_2 = (By.CSS_SELECTOR, '[data-test="add-to-cart-sauce-labs-bike-light"]')
        self.REMOVER_ITEM_1 = (By.CSS_SELECTOR, '[data-test="remove-sauce-labs-backpack"]')
        

    def adicionar_item(self):
        self.driver.find_element(*self.ADICIONAR_ITEM_1).click()

    def adicionar_2_itens(self):
        self.driver.find_element(*self.ADICIONAR_ITEM_1).click()
        self.driver.find_element(*self.ADICIONAR_ITEM_2).click()

    def clicar_carrinho(self):
        self.driver.find_element(*self.ICONE_CARRINHO).click()


    def selecionarSort(self, filtro):
        select_element = self.wait.until(EC.visibility_of_element_located(self.FILTRO_SELECTOR))
        select_element = self.driver.find_element(*self.FILTRO_SELECTOR)
        dropdown = Select(select_element)
        dropdown.select_by_visible_text(filtro)

    def obter_nomes_dos_itens(self):
        elementos = self.driver.find_elements(*self.NOMES_ITENS)
        return [elemento.text for elemento in elementos]


    def esta_em_ordem_alfabetica(self):
        nomes = self.obter_nomes_dos_itens()
        return nomes == sorted(nomes)


    def esta_em_ordem_alfabetica_inversa(self):
        nomes = self.obter_nomes_dos_itens()
        return nomes == sorted(nomes, reverse=True)
    

    def obter_valores(self):
        elementos = self.driver.find_elements(*self.VALORES_ITENS)
        return [float(elemento.text.replace('$', '').strip()) for elemento in elementos]

    def esta_em_ordem_crescente(self):
        valores = self.obter_valores()
        return valores == sorted(valores)

    def esta_em_ordem_decrescente(self):
        valores = self.obter_valores()
        return valores == sorted(valores, reverse=True)

    def removerItem(self):
        self.driver.find_element(*self.REMOVER_ITEM_1).click()