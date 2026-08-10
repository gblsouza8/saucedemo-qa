import allure
from selenium import webdriver
from dotenv import load_dotenv
import os

# Executado uma única vez antes de toda a suíte de testes
def before_all(context):
    load_dotenv()

def before_scenario(context, scenario):
    options = webdriver.ChromeOptions()
    
    if os.getenv("HEADLESS", "false").lower() == "true":
        options.add_argument("--headless=new")
        options.add_argument("--window-size=1920,1080")

    context.driver = webdriver.Chrome(options=options)
    
    if os.getenv("HEADLESS", "false").lower() != "true":
        context.driver.maximize_window()

def after_scenario(context, scenario):
    if hasattr(context, "driver"):
        try:
            # Anexa screenshot no Allure (mesmo se o cenário falhar)
            screenshot = context.driver.get_screenshot_as_png()
            allure.attach(
                screenshot,
                name=f"Resultado_{scenario.name}",
                attachment_type=allure.attachment_type.PNG
            )
        except Exception as e:
            print(f"Erro ao anexar screenshot no Allure: {e}")
        finally:
            # Garante que o navegador SEMPRE será fechado, mesmo em caso de erro
            context.driver.quit()