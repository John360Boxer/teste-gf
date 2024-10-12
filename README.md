# Aplicação Back-end para requisições de BD com Digimons

### Este projeto foi desenvolvido como teste para GF Innovation, onde uma aplicação back-end deve permitir fazer requisições GET para acessar um banco de dados contendo informações sobre diversos Digimons, onde o BD é alimentado de uma API na inicialização.

<img src="https://static.wikia.nocookie.net/logopedia/images/3/36/Digimon_Adventure_logo.png/revision/latest/scale-to-width-down/250?cb=20240212221721">

## Tecnologias

O código foi desenvolvido em Java com Spring Boot, juntamente de Docker para virtualização do banco de dados PostgreSQL e Swagger para realização das requisições.

Os seguintes passos iniciam o projeto:

1. Inicialize o docker e configure o banco de dados PostgreSQL. Nome: digimon, Usuário: admin, Senha: admin;
2. Configure as variáveis de ambiente para usar o Java na linha de comando;
3. Execute o programa Java que se encontra em ``` teste-gf\src\main\java\com\digimon\teste_gf\DigimonApplication.java ```.

Finalizado as preparações, utilize o Swagger para realizar as requisições GET. Ele pode ser acessado por meio do seguinte link:
```
http://localhost:8080/swagger-ui/index.html#/

Uma vez acessado a página, as requisições GET podem ser feitas através do digimon-controller:

| Nome | Parâmetros | Descrição |
| --- | --- | --- |
| / | Nenhum | Retorna todos os Digimons presentes no BD |
| /name | Nome | Retorna o Digimon baseado no nome, caso exista |
| /level | Nível | Retorna todos os Digimons que tenham o mesmo nível mencionado |