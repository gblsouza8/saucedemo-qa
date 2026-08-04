describe('Carrinho', () => {

    beforeEach( () => {
        // Arrange
        cy.visit('/')
        cy.get('[data-test="username"]').type('standard_user')
        cy.env(['password']).then((env) => {
            cy.get('[data-test="password"]').type(env.password)
        })
        cy.get('[data-test="login-button"]').click()
    })


    it('Adicionar primeiro produto ao carrinho', () => {

        // ACT
        // adiciona backpack no carrinho
        cy.get('[data-test="add-to-cart-sauce-labs-backpack"]').click()
        // navega até o carrinho
        cy.get('[data-test="shopping-cart-link"]').click()

        // ASSERT
        // verifica se a backpack está no carrinho
        cy.get('[data-test="inventory-item-name"]').should('contain.text', 'Backpack')
        // verifica se a badge aparece no icone do carrinho
        cy.get('[data-test="shopping-cart-badge"]').should('exist')

        cy.screenshot('Tela final após adicionar um produto ao carrinho')
    })

    it('Adicionar vários produtos ao carrinho', () => {
        // act
        cy.get('[data-test="add-to-cart-sauce-labs-backpack"]').click()
        cy.get('[data-test="add-to-cart-sauce-labs-bike-light"]').click()

        cy.get('[data-test="shopping-cart-link"]').click()

        // assert
        cy.get('[data-test="inventory-item-name"]').should('contain.text', 'Backpack')
        cy.get('[data-test="inventory-item-name"]').should('contain.text', 'Light')
        cy.screenshot('Tela final após adicionar vários produtos ao carrinho')
    })


    it('Remover produto do carrinho pela página inventory', () => {

        //arrange
        cy.get('[data-test="add-to-cart-sauce-labs-backpack"]').click()

        //act
        cy.get('[data-test="remove-sauce-labs-backpack"]').click()
        cy.get('[data-test="shopping-cart-link"]').click()

        //assert
        cy.get('[data-test="inventory-item-name"]').should('not.exist')
        cy.screenshot('Tela final após remover o produto do carrinho pelo inventory')

    })

    it('Remover produto do carrinho pela página carrinho', () => {
        //arrange
        cy.get('[data-test="add-to-cart-sauce-labs-backpack"]').click()
        cy.get('[data-test="shopping-cart-link"]').click()

        //act
        cy.get('[data-test="remove-sauce-labs-backpack"]').click()

        //assert
        cy.get('[data-test="inventory-item-name"]').should('not.exist')
        cy.screenshot('Tela final após remover o produto do carrinho pelo próprio carrinho')

    })









} )