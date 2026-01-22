# PetAt

## Descrição
PetAt é um projeto backend para uma pet store fictícia. Foi desenvolvido utilizando Kotlin com Spring Boot e MongoDB, simulando o consumo de uma API por um aplicativo mobile.

## Objetivo
Desenvolver e aprimorar habilidades em desenvolvimento backend com Kotlin, explorando as diferenças e o comportamento das tecnologias em comparação com Java, considerando o crescimento do uso de Kotlin no mercado.

## Tipo de Projeto
API REST

## Tecnologias Utilizadas
- Kotlin  
- Spring Boot  
- MongoDB  
- JWT  
- Verificação de e-mail (SMTP)  
- OAuth2  
- MapStruct  

## Pré-requisitos
- Java JDK 21 ou superior  
- Docker  
- Conta SMTP válida para envio de e-mails  

O banco de dados é criado automaticamente ao executar o projeto.

## Instalação
1. Clonar o repositório:
   ```bash
   git clone <url-do-repositorio>

Configurar as informações SMTP no arquivo application.properties.

Execução

Após a configuração, execute a aplicação.
A API ficará disponível em:

http://localhost:8080/api/**

Exemplo de Uso
Cadastro de Usuário

curl --request POST \
  --url http://localhost:8080/api/register \
  --header 'Content-Type: application/json' \
  --data '{
    "name": "John",
    "lastName": "Doe",
    "email": "john.doe2@example.com",
    "documentType": "CPF",
    "documentNumber": "2",
    "contact": "+1234567890",
    "pet": []
  }'

Estrutura de Pastas

src/
├── main/
│   ├── kotlin/
│   │   └── <pacotes>
│   │       ├── controllers/
│   │       ├── services/
│   │       ├── models/
│   │       └── repository/
│   └── resources/
│       ├── application.properties
│       └── outros arquivos de configuração
└── test/
    └── kotlin/
        └── <pacotes de teste>

Variáveis de Ambiente

EMAIL_USER=email
EMAIL_PASSWORD=senha

Banco de Dados

MongoDB
Configuração automática ao iniciar a aplicação.

Testes

Ainda não possui testes automatizados.
Status: em desenvolvimento.

Status do Projeto

Em desenvolvimento.

Licença

Livre para todos.

Autor

Projeto desenvolvido por um único autor.
