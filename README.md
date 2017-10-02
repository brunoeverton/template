# Projeto Exemplo
Projeto exemplo, com frameworks utilizados nos projetos Marph

## Configuração inicial
### Banco de dados 
Foi utilizado o banco de dados MySQL e a estrutura deve ser mantinda utilizando liquibase. O liquibase está configurado para subir e atualizar a estrutura do BD automaticamente.
Os arquivos do liquibase com a estrutura do banco estão na pasta: src/main/resources/db

### Aplicação
A configuração da aplicação está disponível em: src/main/resources/application.yml

## Iniciando pela IDE
A utilização do springboot permite que o projeto seja iniciado como uma aplicação java simples a partir da classe:
  template/src/main/java/br/com/bes/template/App.java

## Acessando a aplicação
A página inicial pode ser acessada em: http://{server}:{port}
```
exemplo: http://localhost:8080/
```

## Documentação 
Com a aplicação em execução a documentação pode ser acessada em: http://{server}:{port}/swagger-ui.html
```
exemplo: http://localhost:8080/swagger-ui.html
```

## Para a construção da aplicação foi utilizado:
* [SpringBoot](https://projects.spring.io/spring-boot/) - Iniciar e configurar a aplicação
* [SpringData](http://projects.spring.io/spring-data/) - Gerenciamento das entidades em banco
* [Swagger](https://swagger.io/) - Documentação de API
* [Liquibase](http://www.liquibase.org) - Mantém a estrutura do banco de dados


## Autor
* **Bruno Everton**
