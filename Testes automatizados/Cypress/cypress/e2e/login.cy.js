describe('Login', () => {

    beforeEach( () => {
        // Arrange
        cy.visit('/')
    })

    it('Login com usuário não cadastrado', () => {


        // Act  
        cy.get('[data-test="username"]').type('usuarioquenaoexiste')

        cy.env(['password']).then((env) => {
            cy.get('[data-test="password"]').type(env.password)
        })

        cy.get('[data-test="login-button"]').click()

        // Assert
        cy.get('[data-test="error"]').should('contain.text', 'Username and password do not match any user in this service')
        cy.location('pathname').should('eq', '/')
        cy.screenshot('Tela final na tentativa de login com usuário não cadastrado')
    })


    it('Login com campo senha em branco', () => {

        // Act
        cy.get('[data-test="username"]').type('standard_user')

        cy.get('[data-test="login-button"]').click()

        // Assert
        cy.get('[data-test="error"]').should('contain.text', 'Password is required')
        cy.location('pathname').should('eq', '/')
        cy.screenshot('Tela final na tentativa de login com senha em branco')
    })

        it('Login com campo usuário em branco', () => {

        // Act
        cy.env(['password']).then((env) => {
            cy.get('[data-test="password"]').type(env.password)
        })
        cy.get('[data-test="login-button"]').click()

        // Assert
        cy.get('[data-test="error"]').should('contain.text', 'Username is required')
        cy.location('pathname').should('eq', '/')
        cy.screenshot('Tela final na tentativa de login com usuário em branco')
    })

        it('Login com usuário cadastrado e senha incorreta', () => {
        // Act
        cy.get('[data-test="username"]').type('standard_user')

        cy.get('[data-test="password"]').type('senhaquecertamentenaoexiste')

        cy.get('[data-test="login-button"]').click()

        // Assert
        cy.get('[data-test="error"]').should('contain.text', 'Username and password do not match any user in this service')
        cy.location('pathname').should('eq', '/')
        cy.screenshot('Tela final na tentativa de login com usuário válido e senha errada')
    })

        it('Login com ambos os campos em branco', () => {

        // Act
        cy.get('[data-test="login-button"]').click()

        // Assert
        cy.get('[data-test="error"]').should('contain.text', 'Username is required')
        cy.location('pathname').should('eq', '/')
        cy.screenshot('Tela final na tentativa de login com ambos os campos em branco')
    })

        it('Login válido', () => {

        // Act
        cy.get('[data-test="username"]').type('standard_user')
        cy.env(['password']).then((env) => {
            cy.get('[data-test="password"]').type(env.password)
        })
        cy.get('[data-test="login-button"]').click()

        // Assert
        cy.location('pathname').should('eq', '/inventory.html')
        cy.screenshot('Tela final na tentativa de login válida')
    })


})