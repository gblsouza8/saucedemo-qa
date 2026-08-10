# language: pt
Funcionalidade: Carrinho

    Cenário: Adicionar primeiro produto ao carrinho
        Dado que o usuário esteja logado
        Quando o usuário apertar em "Add to cart"
        Então o produto deve estar no carrinho

    Cenário: Adicionar vários produtos ao carrinho
        Dado que o usuário esteja logado 
        Quando o usuário apertar em "Add to cart" em dois produtos
        Então os produtos devem estar no carrinho

    Cenário: Remover produto do carrinho pela página inventory
        Dado que o usuário esteja logado
        E já tenha um produto no carrinho 
        Quando o usuário apertar em "Remove"
        Então o produto deve sumir do carrinho


    Cenário: Remover produto do carrinho pelo carrinho
        Dado que o usuário esteja na página cart com um produto adicionado
        Quando o usuário apertar em "Remove" no carrinho
        Então o produto escolhido deve desaparecer da página