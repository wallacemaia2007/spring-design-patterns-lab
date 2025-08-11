# Lab - Padrões de Projeto com Spring Boot

Este projeto é um laboratório de estudos desenvolvido para aplicar e demonstrar na prática alguns Padrões de Projeto (Design Patterns) e conceitos essenciais do ecossistema Spring, utilizando Java. O projeto consiste em uma API REST para o cadastro de clientes, onde o endereço do cliente é obtido através da integração com a API externa [ViaCEP](https://viacep.com.br/).

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.2.0**
* **Spring Data JPA**: Para persistência de dados e abstração da camada de acesso a dados (Repository Pattern).
* **Spring Web**: Para a construção da API REST e dos controllers.
* **Spring Security**: Para controle de autenticação e autorização baseado em Roles (funções).
* **Spring Cloud OpenFeign**: Para a criação de um cliente HTTP declarativo e consumo da API ViaCEP (Facade Pattern).
* **H2 Database**: Banco de dados em memória para facilitar o ambiente de desenvolvimento e testes.
* **Maven**: Para gerenciamento de dependências e build do projeto.
* **SpringDoc OpenAPI (Swagger)**: Para documentação interativa e visualização dos endpoints da API.

---

## 🏛️ Arquitetura e Padrões de Projeto

A arquitetura do projeto segue o princípio de separação de camadas (Layered Architecture), um padrão fundamental para a organização e manutenibilidade de software:

* **`Controller`**: Camada responsável por expor a API REST e receber as requisições HTTP. Ela delega a lógica de negócio para a camada de Serviço.
* **`Service`**: Camada onde reside a lógica de negócio da aplicação. Ela orquestra as operações, utilizando os repositórios para acessar os dados.
* **`Repository`**: Camada de acesso a dados, cuja implementação é fornecida pelo Spring Data JPA.
* **`Entity`**: Objetos que representam as tabelas do banco de dados.

### Padrões de Projeto Aplicados

1.  **Singleton**: As classes de serviço do Spring (`@Service`, `@RestController`, etc.) são, por padrão, gerenciadas como Singletons pelo contêiner de Injeção de Dependência do Spring. Isso garante que exista apenas uma instância desses componentes na aplicação, otimizando o uso de memória.

2.  **Strategy**: Implementado na classe `ClienteServiceImpl`. A lógica para salvar um cliente (`salvarClienteComCep`) define uma estratégia clara:
    * Verificar se o `Endereco` (através do CEP) já existe no banco de dados local.
    * Caso não exista, uma busca é feita na API externa do ViaCEP. O resultado é então persistido no banco local.
    * Caso já exista, ele é apenas recuperado e associado ao `Cliente`.
    * Finalmente, o `Cliente` é salvo com seu `Endereco` associado.

3.  **Facade**: O `ViaCepService` atua como uma fachada (Facade) para a API do ViaCEP. Ele provê uma interface simples e coesa (`consultarCep(String cep)`) que oculta toda a complexidade da comunicação HTTP com o serviço externo. Isso torna o código na camada de serviço mais limpo e desacoplado.

4.  **Repository Pattern**: O Spring Data JPA implementa o Repository Pattern por meio de interfaces como `JpaRepository` e `CrudRepository`. Isso abstrai completamente a implementação do acesso a dados, permitindo que a camada de serviço interaja com o banco de dados de forma simples e agnóstica à tecnologia subjacente (neste caso, o H2).

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos

* Java 21 ou superior instalado.
* Maven configurado no seu ambiente (ou pode usar o Maven Wrapper).

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone https://seu-usuario/lab-padroes-projeto-spring.git
    cd lab-padroes-projeto-spring
    ```

2.  **Execute a aplicação usando o Maven Wrapper:**
    * No Linux ou macOS:
        ```bash
        ./mvnw spring-boot:run
        ```
    * No Windows:
        ```bash
        ./mvnw.cmd spring-boot:run
        ```

3.  A aplicação estará disponível em `http://localhost:8080`.

---

## 📝 Endpoints da API

Após iniciar a aplicação, você pode interagir com os seguintes recursos:

### Documentação (Swagger)

A documentação interativa da API está disponível no Swagger UI. Acesse pelo navegador:
* **URL:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Console do Banco H2

Você pode acessar o console do banco de dados em memória para visualizar as tabelas e dados:
* **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **Username:** `sa`
* **Password:** (deixe em branco)

### Endpoints de `Cliente`

* `GET /clientes`: Retorna todos os clientes cadastrados.
* `GET /clientes/{id}`: Busca um cliente por ID.
* `POST /clientes`: Insere um novo cliente.
* `PUT /clientes/{id}`: Atualiza um cliente existente.
* `DELETE /clientes/{id}`: Deleta um cliente por ID.

### Autenticação

Para testar os endpoints, a aplicação inicializa com um usuário padrão. Você pode usar as credenciais abaixo para se autenticar através do formulário de login do Spring Security ou no Swagger UI.

* **Username**: `Wallace`
* **Password**: `1234`
* **Role**: `MANAGER`