describe('Filtro de busca', () => {
    beforeEach( () => {
        const testTitle = Cypress.currentTest.title;
        //arrange
        cy.visit('/')

        if (testTitle === 'Filtrar por nome (Z a A)') {
            cy.get('[data-test="username"]').type('error_user')
        }
        else {
            cy.get('[data-test="username"]').type('standard_user')
        }
        cy.env(['password']).then((env) => {
            cy.get('[data-test="password"]').type(env.password)
        })
        cy.get('[data-test="login-button"]').click()
    })

    
    it('Filtrar do menor para o maior preço', () => {
        cy.get('[data-test="product-sort-container"]').select('lohi')

        cy.get('[data-test="inventory-item-price"]').then(($prices) => {
            const prices = [...$prices].map((e1) => 
            parseFloat(e1.innerText.replace('$', ''))
        )

        const sortedPrices = [...prices].sort((a,b) => a - b)
        expect(prices).to.deep.equal(sortedPrices)
        })
    })






    it('Filtrar do maior para o menor preço', () => {
        cy.get('[data-test="product-sort-container"]').select('hilo')

        cy.get('[data-test="inventory-item-price"]').then(($prices) => {
            const prices = [...$prices].map((e1) => 
            parseFloat(e1.innerText.replace('$', ''))
        )

        const sortedPrices = [...prices].sort((a,b) => b - a)
        expect(prices).to.deep.equal(sortedPrices)
        })
    })

    it('Filtrar por nome (A a Z)', () => {
        cy.get('[data-test="product-sort-container"]').select('az')

        cy.get('[data-test="inventory-item-name"]').then(($items) => {
            const names = [...$items].map((el) => el.innerText.trim())

            const sortedNames = [...names].sort((a, b) => a.localeCompare(b)
        )

        expect(names).to.deep.equal(sortedNames)
        })
    })

        it('Filtrar por nome (Z a A)', () => {
        cy.get('[data-test="product-sort-container"]').select('za')

        cy.get('[data-test="inventory-item-name"]').then(($items) => {
            const names = [...$items].map((el) => el.innerText.trim())
            const sortedNames = [...names].sort((a, b) => b.localeCompare(a)
        )

        expect(names).to.deep.equal(sortedNames)
        })
    })

    





})
