const {defineConfig} = require('cypress')
const baseConfig = require('./cypress.config')
const dotenv = require('dotenv')
const path = require('path')

dotenv.config({
    path: path.resolve(__dirname, './.env.dev')
})


module.exports = defineConfig({
    ...baseConfig, 
    e2e: {
        ...baseConfig.e2e,
        baseUrl: process.env.BASE_URL,
        env: {
            ...baseConfig.e2e?.env,
            password: process.env.PASSWORD
        }

    }
})