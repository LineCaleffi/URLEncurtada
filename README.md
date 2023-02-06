## Encurtador de URL

## SOBRE O PROJETO

Seu serviço irá receber inicialmente como parâmetro uma URL que deverá ser encurtada.

Como material de estudo é possível consultar
1 - Internet
2 - Apostila
3 - Colegas de Equipe (De forma consultiva)

------------------------------
Exemplo:
url:" https://www.backendbrasil.com.br/ "

Seu sistema recebe uma chamada para encurtar a url backendbrasil.com.br e retorna o seguinte json:
newUrl: "xn54xsndbm"

Mandando esse código na URL do navegador: localhost:8080/url/xn54xsndbm - Você é redirecionado automáticamente para o link https://www.backendbrasil.com.br/

------------------------------

## Tecnologias utilizadas:
* Java
* JPA
* Hibernate
* Lombok
* MySQL
* Postman

## Formas de testar o projeto:
1. Faça o clone do repositório: https://github.com/LineCaleffi/URLEncurtada
2. Configure o arquivo application.properties alterando o usuario e senha (Utilize o seu usuário e senha do Mysql), quando o projeto for executado ele se encarregará de criar a tabela e suas colunas no banco de dados
3. Na IDE execute o arquivo UrlApplication
4. Para salvar, deletar e buscar uma URL é necessário usar o Postman.

--------------------------------------------------------------------

…ou crie um novo repositório na linha de comando
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/LineCaleffi/URLEncurtada.git
git push -u origin main





…ou envie um repositório existente a partir da linha de comando
git remote add origin https://github.com/LineCaleffi/URLEncurtada.git
git branch -M main
git push -u origin main