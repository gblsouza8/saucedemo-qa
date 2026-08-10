from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class LoginPage:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(self.driver, 10)  
        self.USERNAME_INPUT = (By.CSS_SELECTOR, '[data-test="username"]')
        self.PASSWORD_INPUT = (By.CSS_SELECTOR, '[data-test="password"]')
        self.LOGIN_BUTTON = (By.CSS_SELECTOR, '[data-test="login-button"]')
        self.ERROR_MESSAGE = (By.CSS_SELECTOR, '[data-test="error"]')

    def open_page(self, url):
        self.driver.get(url)

    def enter_username(self, username):
        self.driver.find_element(*self.USERNAME_INPUT).send_keys(username)

    def enter_password(self, password):
        self.driver.find_element(*self.PASSWORD_INPUT).send_keys(password)

    def click_login(self):
        self.driver.find_element(*self.LOGIN_BUTTON).click()

    def get_current_pathname(self):
        from urllib.parse import urlparse
        return urlparse(self.driver.current_url).path

    def get_error(self):
        # Espera até que o elemento esteja visível
        element = WebDriverWait(self.driver, 5).until(
            EC.visibility_of_element_located(self.ERROR_MESSAGE)
        )
        # Usa innerText ou textContent para pegar o texto puro do DOM sem interferência de CSS
        WebDriverWait(self.driver, 5).until(lambda d: element.text.strip() != "")
        return element.get_attribute("textContent").strip()
