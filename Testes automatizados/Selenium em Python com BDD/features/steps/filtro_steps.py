import os
import sys
from behave import given, when, then
from pages.login_page import LoginPage
from pages.inventory_page import InventoryPage



@given(u'que o usuário esteja na página inventory')
def realizarLogin(context):
    context.login_page = LoginPage(context.driver)
    url = os.getenv("BASE_URL")
    context.login_page.open_page(url)
    context.login_page.enter_username("standard_user")
    password = os.getenv("PASSWORD")
    context.login_page.enter_password(password)
    context.login_page.click_login()


@given(u'que o usuário esteja na página inventoryy')
def realizarLogin(context):
    context.login_page = LoginPage(context.driver)
    url = os.getenv("BASE_URL")
    context.login_page.open_page(url)
    context.login_page.enter_username("problem_user")
    password = os.getenv("PASSWORD")
    context.login_page.enter_password(password)
    context.login_page.click_login()


@when(u'selecionar o filtro "{filtro}"')
def selecionarFiltro(context, filtro):
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.selecionarSort(filtro)


@then(u'os produtos devem ser ordenados do menor preço para o maior preço')
def verificarOrdem_01(context):
    context.inventory_page = InventoryPage(context.driver)
    esta_ordenado = context.inventory_page.esta_em_ordem_crescente()
    precos_atuais = context.inventory_page.obter_valores()

    assert esta_ordenado, f"Os itens não estão em ordem crescente. Preços encontrados: {precos_atuais}"



@then(u'os produtos devem ser ordenados do maior preço para o menor preço')
def verificarOrdem_10(context):
    context.inventory_page = InventoryPage(context.driver)
    esta_ordenado = context.inventory_page.esta_em_ordem_decrescente()
    precos_atuais = context.inventory_page.obter_valores()

    assert esta_ordenado, f"Os itens não estão em ordem decrescente. Preços encontrados: {precos_atuais}"



@then(u'os produtos devem ser ordenados em ordem alfabética')
def verificarOrdem_az(context):
    context.inventory_page = InventoryPage(context.driver)
    esta_ordenado = context.inventory_page.esta_em_ordem_alfabetica()
    nomes_atuais = context.inventory_page.obter_nomes_dos_itens()

    assert esta_ordenado, f"Os itens não estão em ordem alfabética. Nomes encontrados: {nomes_atuais}"


@then(u'os produtos devem ser ordenados em ordem alfabética inversa')
def verificarOrdem_za(context):
    context.inventory_page = InventoryPage(context.driver)
    esta_ordenado = context.inventory_page.esta_em_ordem_alfabetica_inversa()
    nomes_atuais = context.inventory_page.obter_nomes_dos_itens()

    assert esta_ordenado, f"Os itens não estão em ordem alfabética inversa. Nomes encontrados: {nomes_atuais}"