# Exemplos API REST

### Exemplo CRUD API REST 
* Utilizando: Padrões de Projetos + Spring Boot + JPA + JPQL

### Objetivo
disponibilizar um exemplo de CRUD Api Rest de exemplo para ser reutilizável.

### Por onde começar?
* Instale: <br />
* Escolha uma IDE de sua preferência Exemplo: STS, Eclipse, Inteligin ou qualquer outra.<br />
* Git<br />
* Escolha um banco de dados de sua preferencia para simular os testes localmente em sua maquina.<br />
* Clone o projeto em seu ambiente local <br />

1. clone o repositório `git https://github.com/renatoredes/exemplo_crud_jpa_api_padroes.git` <br />
2. Maven - UPDATE - Project - Force Update <br />

- Click no link para acessar a 👉👉 [Documentação](https://github.com/renatoredes/exemplo_crud_jpa_api_padroes/wiki).

* Modelagem de dados inicial - este modelo pode ser evoluído.
- Estamos evoluindo este exemplo 😀

![cat](https://github.com/renatoredes/exemplo_crud_jpa_api_padroes/blob/main/screenshot/entidade_medico_consulta.png)


### Hierarquia de package 

* domain: Domain Model Patterns são padrões de desenvolvimento e estruturação de aplicações cujo domínio é o principal.

* model: (Modelos) fazem parte da arquitetura MVC. Eles representam os dados, as regras e a lógica de negócio.

* repository: Os Repositórios possuem acesso direto a camada de dados podendo persistir dados e realizar as consultas. 
Um repositório também pode consultar diretamente serviços externos.

* service: Os Serviços de Domínio implementam a lógica de negócios além das tarefas de negócio ficam todas validações 
tratamento de exceção antes de persistir os dados no banco de dados da aplicação.

* controller: As classes de Controller é semelhante ao controlador MVC elas lidam com solicitações HTTP
de entrada e envia uma resposta de volta ao chamador.

### Contribuir para projeto 
### Projeto open source qualquer pessoal pode contribuir com este projeto 
* para contribuir entre no grupo do whatsapp através do link abaixo: <br />
* Grupo foi criado para quem quiser contribuir com o projeto API REST Sistema de Clinica medica <br />

* https://chat.whatsapp.com/JvxUyEw1b73EdFM1pTYglP

## License
MIT © [Renato Ferreira](https://github.com/renatoredes)
