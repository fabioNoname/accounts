accounts
Passo 1: Preparando o ambiente de desenvolvimento.

1. Baixe a versão do eclipse com Spring em https://spring.io/tools de acordo com seu sistema operacional.
2. instale o git https://git-scm.com/downloads, e faço um git clone do projeto.
3. Após baixar o projeto, importe o projeto.
4. Baixe o banco de dados mysql, instale e para o usário root configure a senha "root", mantenha a configuração na porta 3306 e crie um DATABASE com nome "pismo".
5. Em ferramenta Boot Dashboard você já pode iniciar o projeto.
6. Faça os inserts na tabele operation_type, com o script abaixo. 
   1. insert into pismo.operation_type (description) values ('COMPRA A VISTA');
   2. insert into pismo.operation_type (description) values ('COMPRA PARCELADA');
   3. insert into pismo.operation_type (description) values ('SAQUE');
   4. insert into pismo.operation_type (description) values ('PAGAMENTO'); 
  
7. execute as classes de testes para validar se está tudo funcionando corretamente.

Se você conseguiu executar todos esses passos sem erro, o seu ambiente de desenvolvimento está configurado e pronto para desenvolver.

Passo 2: Preparando o ambeinte docker.

1. Installe o docker. https://www.docker.com/get-started
2. crie um sua rede network: $ docker network create --driver bridge pismo
3. crie um container do mysql: $ docker run --network pismo --name mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:latest
4. crie um DATABASE com nome "pismo".
5. Abra o arquivo application.yml do projeto e na URL do datasource substitua localhost por mysql e salve.
6. Na pasta do projeto contrua a imagem do projeto: $ docker build -t accounts .
7. Inicie seu container: docker run --network pismo -p 8080:8080 accounts
8. Faça os inserts na tabele operation_type, com o script abaixo.
   1. insert into pismo.operation_type (description) values ('COMPRA A VISTA');
   2. insert into pismo.operation_type (description) values ('COMPRA PARCELADA');
   3. insert into pismo.operation_type (description) values ('SAQUE');
   4. insert into pismo.operation_type (description) values ('PAGAMENTO'); 
9. use o postman para testar as requisições.
   


