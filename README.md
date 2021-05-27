accounts
Passo 1: Preparando o ambiente de desenvolvimento.

1. Instale o JDK 1.8.
2. Baixe a versão do eclipse com Spring em https://spring.io/tools de acordo com seu sistema operacional.
3. instale o git branch, e faço um git clone do projeto.
4. Após baixar o projeto, importe o projeto.
5. Baixe o banco de dados mysql, instale e para o usário root configure a senha "root", mantenha a configuração na porta 3306 e crie o schama com nome "pismo".
7. Em ferramenta Boot Dashboard você já pode iniciar o projeto.
8. Faça os inserts na tabele operation_type, com o script abaixo.
  insert into operation_type (description) values ('COMPRA A VISTA');
  insert into operation_type (description) values ('COMPRA PARCELADA');
  insert into operation_type (description) values ('SAQUE');
  insert into operation_type (description) values ('PAGAMENTO');
  
  
10. execute as classes de testes para validar se está tudo funcionando corretamente.

Se você conseguiu executar todos esses passos sem erro, o seu ambiente de desenvolvimento está configurado e pronto para desenvolver.

