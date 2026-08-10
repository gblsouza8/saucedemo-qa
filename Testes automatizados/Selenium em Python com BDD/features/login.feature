# language: pt
Funcionalidade: Login no sistema

    Cenário: Login com usuário não cadastrado
        Dado que o usuário navega até a página de login
        Quando insere o usuário "usuarioquenaoexiste123" e a senha do ambiente
        E clica no botão entrar
        Então exibir mensagem de erro "Username and password do not match any user in this service"


    Cenário: Login com campo senha em branco
        Dado que o usuário navega até a página de login
        Quando inserir o usuário "standard_user" e apertar em login
        Então exibir mensagem de erro "Password is required"

    Cenário: Login com campo usuário em branco
        Dado que o usuário navega até a página de login
        Quando inserir a senha do ambiente
        E clica no botão entrar
        Então exibir mensagem de erro "Username is required"


    Cenário: Login com usuário cadastrado e senha errada
        Dado que o usuário navega até a página de login
        Quando inserir o usuário "usuarioaleatorio" e a senha "senhaaleatoria"
        E clica no botão entrar
        Então exibir mensagem de erro "Username and password do not match any user in this service"

    Cenário: Login com ambos os campos em branco
        Dado que o usuário navega até a página de login
        Quando clica no botão entrar
        Então exibir mensagem de erro "Username is required"

    Cenário: Login com sucesso
        Dado que o usuário navega até a página de login
        Quando insere o usuário "standard_user" e a senha do ambiente
        E clica no botão entrar
        Então deve ser direcionado para a página "/inventory.html"
