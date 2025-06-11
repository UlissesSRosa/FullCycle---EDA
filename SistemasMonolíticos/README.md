Módulo de Invoice (Nota Fiscal)

Este módulo implementa o domínio de geração e consulta de notas fiscais no padrão DDD conforme o desafio da FullCycle.

Estrutura src/ ├── domain/ │ ├── entity/ │ ├── value-object/ │ └── repository/ ├── usecase/ │ ├── generate-invoice/ │ └── find-invoice/ ├── facade/ ├── factory/ └── infra/ └── db/ └── invoice-repository.memory.ts tests/