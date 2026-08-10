import os
import sys
from behave import given, when, then
from pages.login_page import LoginPage
from pages.inventory_page import InventoryPage
from pages.cart_page import CartPage


@given(u'que o usuário esteja logado')
def fazerLogin(context):
    context.login_page = LoginPage(context.driver)
    url = os.getenv("BASE_URL")
    context.login_page.open_page(url)
    context.login_page.enter_username("standard_user")
    password = os.getenv("PASSWORD")
    context.login_page.enter_password(password)
    context.login_page.click_login()


@when(u'o usuário apertar em "Add to cart"')
def adicionarItem(context):
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.adicionar_item()



@then(u'o produto deve estar no carrinho')
def produtoNoCarrinho(context):
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.clicar_carrinho()
    context.cart_page = CartPage(context.driver)
    assert context.cart_page.verificarItem(), f"Produto não está no carrinho"


@when(u'o usuário apertar em "Add to cart" em dois produtos')
def adicionarProdutos(context):
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.adicionar_2_itens()
            


@then(u'os produtos devem estar no carrinho')
def produtosNoCarrinho(context):
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.clicar_carrinho()

    context.cart_page = CartPage(context.driver)
    assert context.cart_page.verificarDoisItens(), f"Produtos não estão no carrinho"


@given(u'já tenha um produto no carrinho')
def jaTerProduto(context):
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.adicionar_item()


@when(u'o usuário apertar em "Remove"')
def apertarEmRemove(context):
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.removerItem()


@then(u'o produto deve sumir do carrinho')
def verificarProdutoNaoEsta(context):
    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.clicar_carrinho()
    context.cart_page = CartPage(context.driver)
    assert not context.cart_page.verificarItem(), f"Produto ainda está no carrinho"


@given(u'que o usuário esteja na página cart com um produto adicionado')
def CartComProduto(context):
    context.login_page = LoginPage(context.driver)
    url = os.getenv("BASE_URL")
    context.login_page.open_page(url)
    context.login_page.enter_username("standard_user")
    password = os.getenv("PASSWORD")
    context.login_page.enter_password(password)
    context.login_page.click_login()

    context.inventory_page = InventoryPage(context.driver)
    context.inventory_page.adicionar_item()
    context.inventory_page.clicar_carrinho()


@when(u'o usuário apertar em "Remove" no carrinho')
def removeCarrinho(context):
    context.cart_page = CartPage(context.driver)
    context.cart_page.clicarRemover()

@then(u'o produto escolhido deve desaparecer da página')
def verificarProdutoSumiu(context):
    context.cart_page = CartPage(context.driver)
    item = context.cart_page.verificarItem()
    assert not item, f'Produto ainda está na página'