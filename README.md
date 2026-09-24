# Desafio Técnico — Back-end | Lacrei Saúde

Desafio técnico para a vaga de **Back-end na Lacrei Saúde**.

## 🛠️ Tecnologias

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Docker / Docker Compose
* Lombok
* Bean Validation

## ⚙️ Configuração

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```env
DATABASE_URL=jdbc:postgresql://localhost:5432/estudos
DATABASE_NAME=estudos
DATABASE_USERNAME=Teste
DATABASE_PASSWORD=Teste
```

Essas variáveis são utilizadas para configurar a conexão com o banco de dados.

Também é necessário utilizar essas mesmas variáveis de ambiente na configuração de execução da aplicação.

Caso esteja utilizando o **IntelliJ IDEA**:

**Edit Configurations → Environment variables**

Adicione:

```text
DATABASE_URL=jdbc:postgresql://localhost:5432/estudos
DATABASE_NAME=estudos
DATABASE_USERNAME=Teste
DATABASE_PASSWORD=Teste
```

O projeto utiliza **Java 17**.

## 🐘 Banco de dados

Para iniciar o banco de dados através do Docker:

```bash
docker compose up -d
```
Caso não inicie tente.
```bash
docker compose down -v
docker compose up -d
```
Para que ele finalize o container e inicie novamente.

Após o banco estar em execução, a aplicação pode ser iniciada normalmente pela IDE ou através do Maven.

## 📁 Estrutura

O projeto está organizado em camadas:

* `Controller`
* `Service`
* `Repository`
* `Entity`
* `DTO`
* `Mapper`

Essa estrutura foi utilizada para manter uma separação de responsabilidades e facilitar a organização e manutenção do código.

## 🔐 Observação

As configurações do banco de dados são utilizadas através de **variáveis de ambiente**, evitando deixar as configurações diretamente no código.

O arquivo `.env` deve ser mantido fora do controle de versão quando utilizado com credenciais reais.

---

**Projeto em desenvolvimento.**
