# Study API 

API de estudo de Spring Bott

### Instruções de Uso
````
mvn spring-boot:run
````

## Métodos Http para Rest

| Anotação          | Função            | Descrição                                                                 |
|------------------|------------------|---------------------------------------------------------------------------|
| `@RestController` | Criar API        | Define a classe como um controller REST que retorna dados (JSON/String)  |
| `@RequestMapping` | Rota base        | Define o caminho principal da API (ex: `/produtos`)                      |
| `@PostMapping`    | Criar recurso    | Usado para enviar dados e criar um novo registro                         |
| `@GetMapping`     | Buscar dados     | Recupera informações (um ou vários registros)                            |
| `@PutMapping`     | Atualizar        | Atualiza um recurso existente                                            |
| `@DeleteMapping`  | Deletar          | Remove um recurso existente 

## 📌 Principais Status HTTP para REST

| Código | Constante            | Significado                          | Exemplo de Uso                  |
|--------|---------------------|--------------------------------------|---------------------------------|
| 200    | OK                  | Requisição bem-sucedida              | GET /produtos                   |
| 201    | Created             | Recurso criado com sucesso           | POST /produtos                  |
| 204    | No Content          | Sem conteúdo na resposta             | DELETE /produtos/{id}           |
| 400    | Bad Request         | Dados inválidos enviados pelo cliente| POST com JSON inválido          |
| 404    | Not Found           | Recurso não encontrado               | GET /produtos/{id} inexistente  |
| 409    | Conflict            | Conflito ao processar a requisição   | Criar recurso duplicado         |
| 500    | Internal Server Error | Erro inesperado no servidor        | Exceção não tratada             |

## 🐋 Docker

* Menu Iniciar (pesquisar por Docker)
  - Iniciar *Start Docker Service*
  - Clicar em *Docker Desktop*

6 - Subir MySQL

- https://hub.docker.com/_/mysql

```sh
docker run -d \
    --name mysql \
    --rm \
    -e MYSQL_ROOT_PASSWORD=root_pwd \
    -e MYSQL_USER=new_user \
    -e MYSQL_PASSWORD=my_pwd \
    -p 3306:3306 \
    mysql
```

### Boas práticas em Commit - Mensagens

| Tipo             | Exemplo de Mensagem                                        |
|------------------|------------------------------------------------------------|
| **Adição de Funcionalidade** | `feat: add user authentication with JWT`                  |
| **Correção de Bug**         | `fix: correct bug in the email validation logic`            |
| **Refatoração de Código**   | `refactor: simplify user registration logic`                |
| **Documentação**            | `docs: update README with installation instructions`         |
| **Melhoria de Performance** | `perf: optimize image loading on homepage`                  |
| **Testes**                  | `test: add unit tests for user registration module`         |
| **Atualização de Dependências** | `chore: update lodash to version 4.17.21`             |
| **Remoção de Funcionalidade** | `remove: delete deprecated user profile API endpoint`   |
| **Configuração**            | `config: add ESLint configuration for React projects`      |