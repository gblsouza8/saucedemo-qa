import { defineConfig } from '@playwright/test';
import { defineBddConfig } from 'playwright-bdd';
import dotenv from 'dotenv';
import path from 'path';

dotenv.config({ path: path.resolve(__dirname, '.env') });

const testDir = defineBddConfig({
  features: 'features/*.feature',
  steps: ['steps/*.ts', 'fixtures/fixtures.ts'],
});

export default defineConfig({
  testDir,
  retries: 0,
  timeout: 10000,
  expect: {
    timeout: 2000,
  },
  reporter: [
    ['html', { open: 'never' }],
  ],

  use: {
    baseURL: process.env.BASE_URL,
    headless: true,
    screenshot: 'on',
    video: 'retain-on-failure',
    trace: 'retain-on-failure',
    testIdAttribute: 'data-test',
  },
});