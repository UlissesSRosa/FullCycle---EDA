# Full Cycle Monolito - Invoice Module



## 🧱 Funcionalidades

- ✅ Geração de Invoice (`/checkout`)
- ✅ Consulta de Invoice por ID (`/invoice/:id`)
- ✅ Cadastro mockado de `products` e `clients`
- ✅ Testes e2e com cobertura acima de 90%

## 📂 Estrutura do Projeto

src/
├── api/ # Camada de rotas e servidor Express
│ ├── routes/
│ └── server.ts
├── config/ # Facade e repositório compartilhado
├── domain/ # Entidades e Value Objects
├── facade/ # Padrão Facade
├── factory/ # Factory de fachada
├── infra/db/ # Repositório em memória
├── usecase/ # Casos de uso
└── tests/ # Testes e2e e unitários


---

## Como rodar o projeto

Baixe o repositório

git clone https://github.com/juhsouza122/full-cycle-sistemas-monoliticos.git

Acesse a pasta raíz
cd SistemasMonolíticosAPI

# Instale as dependências
npm install


🧪 Rodar os Testes
npm test

Você verá algo como:
PASS  src/tests/e2e/invoice.e2e.spec.ts
  ✓ should return 404 for non-existent invoice
  ✓ should create and retrieve an invoice


🔗 Endpoints da API

🔹 Criar Produto (mock)
POST /products
🔹 Criar Cliente (mock)
POST /clients
🔹 Criar Invoice
POST /checkout

{
  "name": "Cliente Teste",
  "document": "99999999999",
  "street": "Rua XPTO",
  "number": "123",
  "complement": "Apto 2",
  "city": "SP",
  "state": "SP",
  "zipCode": "00000-000",
  "items": [
    { "id": "1", "name": "Produto A", "price": 100 },
    { "id": "2", "name": "Produto B", "price": 200 }
  ]
}
🔹 Buscar Invoice por ID
GET /invoice/:id