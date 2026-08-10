# language: pt
Funcionalidade: Filtro de busca

    Cenário: Filtrar do menor para o maior preço
        Dado que o usuário esteja na página inventory 
        Quando selecionar o filtro "Price (low to high)" 
        Então os produtos devem ser ordenados do menor preço para o maior preço


    Cenário: filtrar do maior para o menor preço
        Dado que o usuário esteja na página inventory
        Quando selecionar o filtro "Price (high to low)" 
        Então os produtos devem ser ordenados do maior preço para o menor preço


    Cenário: filtrar em ordem alfabética
        Dado que o usuário esteja na página inventory
        Quando selecionar o filtro "Name (A to Z)"
        Então os produtos devem ser ordenados em ordem alfabética


    Cenário: filtrar em ordem alfabétia inversa
        Dado que o usuário esteja na página inventoryy
        Quando selecionar o filtro "Name (Z to A)" 
        Então os produtos devem ser ordenados em ordem alfabética inversa