# Lab: Padrões de Projeto com Spring Boot

Este projeto é um laboratório de estudos desenvolvido para aplicar e demonstrar na prática alguns Padrões de Projeto (Design Patterns) e conceitos essenciais do ecossistema Spring, utilizando Java. O projeto consiste em uma API REST para o cadastro de clientes, onde o endereço do cliente é obtido através da integração com a API externa [ViaCEP](https://viacep.com.br/).

## 🎨 Interface Web (Página Inicial)

O projeto possui uma interface de boas-vindas desenvolvida com **Thymeleaf**, apresentando um tema noturno moderno. Esta página serve como um guia rápido para a utilização da API, detalhando os endpoints disponíveis e destacando a funcionalidade de preenchimento automático de endereço.

<!-- 
    SUGESTÃO: Tire um print da sua tela com a aplicação rodando e adicione aqui!
    1. Suba a imagem para o seu repositório GitHub.
    2. Pegue o link da imagem e substitua no comando abaixo.
-->
![Preview da Interface](https://i.imgur.com/link-para-sua-imagem.png)

## 🚀 Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.2.2**
* **Spring Web**: Para a construção da API REST e da interface web.
* **Spring Data JPA**: Para persistência de dados (Repository Pattern).
* **Spring Security**: Para controle de autenticação e autorização baseado em papéis (Roles).
* **Thymeleaf**: Para a criação da página de apresentação da API.
* **Spring Cloud OpenFeign**: Para o consumo declarativo da API ViaCEP (Facade Pattern).
* **H2 Database**: Banco de dados em memória para desenvolvimento.
* **Maven**: Para gerenciamento de dependências e build.
* **SpringDoc OpenAPI (Swagger)**: Para documentação interativa da API.

---

## 🏛️ Arquitetura e Padrões de Projeto

A arquitetura segue o princípio de **Layered Architecture**, dividindo o projeto nas seguintes camadas:

* **`Controller`**: Expõe a API REST e a página web, delegando a lógica para a camada de Serviço.
* **`Service`**: Contém a lógica de negócio da aplicação.
* **`Repository`**: Camada de acesso a dados, implementada pelo Spring Data JPA.
* **`Entity`**: Objetos que representam as tabelas do banco de dados.

### Padrões de Projeto Aplicados

1.  **Singleton**: As classes de serviço do Spring (`@Service`, `@RestController`, etc.) são gerenciadas como Singletons pelo contêiner de Injeção de Dependência.
2.  **Strategy**: Implementado em `ClienteServiceImpl`, a lógica para salvar um cliente (`salvarClienteComCep`) define uma estratégia clara para buscar o endereço no banco de dados local antes de consultar o serviço externo.
3.  **Facade**: A interface `ViaCepService` atua como uma fachada, simplificando o consumo da API do ViaCEP.
4.  **Repository Pattern**: O Spring Data JPA abstrai o acesso a dados por meio de interfaces como `JpaRepository`.

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos

* Java 21 ou superior.
* Maven configurado (ou pode usar o Maven Wrapper incluso).

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/spring-design-patterns-lab.git](https://github.com/seu-usuario/spring-design-patterns-lab.git)
    cd spring-design-patterns-lab
    ```

2.  **Execute a aplicação com o Maven Wrapper:**
    * No Windows:
        ```bash
        ./mvnw.cmd spring-boot:run
        ```
    * No Linux ou macOS:
        ```bash
        ./mvnw spring-boot:run
        ```

3.  A aplicação estará disponível em `http://localhost:8080`.

---

## 📝 Recursos e Autenticação

### Acesso Público
As seguintes rotas são acessíveis por qualquer pessoa, sem necessidade de login:
* **Página Inicial:** [http://localhost:8080/](http://localhost:8080/)

### Acesso de Administrador (MANAGER)
O usuário **`fulano`** tem o papel de `MANAGER` e pode acessar todos os recursos da aplicação, incluindo:
* **Documentação (Swagger UI):** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* **API de Clientes:** `http://localhost:8080/clientes`
* **Console do Banco H2:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    * **JDBC URL:** `jdbc:h2:mem:testdb`
    * **Username:** `sa`
    * **Password:** (deixe em branco)

### Acesso de Usuário Comum (USER)
O usuário **`ciclano`** tem o papel de `USER`. Ele pode se autenticar, mas seu acesso é limitado à página inicial.

### Credenciais de Teste
* **Administrador:**
    * **Username**: `fulano`
    * **Password**: `1234`
* **Usuário Comum:**
    * **Username**: `ciclano`
    * **Password**: `1234`
