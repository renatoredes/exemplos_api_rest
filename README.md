# Exemplo CRUD API Spring Boot + Padrões de Projetos.

1. clone o repositório `git https://github.com/renatoredes/exemplo_crud_jpa_api_padroes.git` <br />
2. Maven - UPDATE - Project - Force Update <br />
### Hierarquia de package 

* domain: Domain Model Patterns são padrões de desenvolvimento e estruturação de aplicações cujo domínio é o principal.

* model: (Modelos) fazem parte da arquitetura MVC. Eles representam os dados, as regras e a lógica de negócio.

* repository: Os Repositórios possuem acesso direto a camada de dados podendo persistir dados e realizar as consultas. 
Um repositório também pode consultar diretamente serviços externos.

* service: Os Serviços de Domínio implementam a lógica de negócios além das tarefas de negócio ficam todas validações 
tratamento de exceção antes de persistir os dados no banco de dados da aplicação.

* controller: As classes de Controller é semelhante ao controlador MVC elas lidam com solicitações HTTP
de entrada e envia uma resposta de volta ao chamador.



## License
MIT © [Renato Ferreira](https://github.com/renatoredes)