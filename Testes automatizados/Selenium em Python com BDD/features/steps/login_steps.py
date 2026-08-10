import os
import sys
from behave import given, when, then
from pages.login_page import LoginPage

@given('que o usuário navega até a página de login')
def step_open_login(context):
    context.login_page = LoginPage(context.driver)
    url = os.getenv("BASE_URL")
    context.login_page.open_page(url)

@when('insere o usuário "{username}" e a senha do ambiente')
def step_fill_credentials(context, username):
    password = os.getenv("PASSWORD")
    context.login_page.enter_username(username)
    context.login_page.enter_password(password)

@when('clica no botão entrar')
def step_click_login(context):
    context.login_page.click_login()

@then('deve ser direcionado para a página "{expected_path}"')
def step_verify_redirect(context, expected_path):
    actual_path = context.login_page.get_current_pathname()
    assert actual_path == expected_path, f"Esperava '{expected_path}', mas foi para '{actual_path}'"


@then('exibir mensagem de erro "{expected_msg}"')
def step_verify_error(context, expected_msg):
    actual_msg = context.login_page.get_error()
    assert expected_msg in actual_msg, f"Esperado {expected_msg}, mas obteve {actual_msg}"


@when('inserir o usuário "{username}" e apertar em login')
def login_sem_senha(context, username):
    context.login_page.enter_username(username)
    context.login_page.click_login()


@when('inserir a senha do ambiente')
def Inserirsenha(context):
    password = os.getenv("PASSWORD")
    context.login_page.enter_password(password)


@when('inserir o usuário "{username}" e a senha "{password}"')
def inserirUsuarioEsenhaInexistentes(context, username, password):
    context.login_page.enter_username(username)
    context.login_page.enter_password(password)
