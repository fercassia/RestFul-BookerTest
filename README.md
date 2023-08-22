## Testes automatizados de API Booker

____________________________________________

Estudo de testes automatizados da API Restful-booker utilizando REST Assured e Java 17, com o
objetivo de aprender algumas técnicas de automatização de api, utilizando a biblioteca.

Documentação da api utilizada nesse estudo, [clique aqui](https://restful-booker.herokuapp.com/apidoc/index.html#api-Auth-CreateToken)

Esses testes que foram criados foram baseados em um artigo, onde explica o básico que foi feito, seguindo algumas boas práticas.

Para ler sobre esse artigo, [clique aqui](https://medium.com/@iamfaisalkhatri/end-to-end-api-testing-using-rest-assured-a58c4ea80255). 

Lembrando que, os testes foram baseados nesse artigo, contudo a forma que foi organizado e desenvolvido foi diferente de como é demonstrado no artigo.

____________________________________________
### Tecnologias utilizadas nos testes:

- Java JDK 17 - [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- IDE de desenvolvimento (Sugestão) - [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/)
- Framework de testes automatizados de API - [RestAssured](https://rest-assured.io/)
- Orquestrador de testes - [TestNG](https://testng.org/doc/)
- Biblioteca de geração de dados falsos e randômicos - [Java Faker](https://github.com/DiUS/java-faker)
- Facilitador de criação de objetos Java - [Lombok](https://projectlombok.org/)

____________________________________________
### Abrindo o projeto (Baseado no uso do IntelliJ):

1. Clonar o repositório para uma pasta desejada
    ```
    git clone https://github.com/fercassia/RestFul-BookerTest.git
    ```
2. Abrir o IntelliJ
3. Clicar em "File"
4. Clicar em "Open"
5. Selecionar a pasta em que o projeto foi clonado
6. Clicar em "Ok"
7. O projeto será carregado e as dependencias serão baixadas automaticamente. 
Deverá aguardar até o fim do carregamento

____________________________________________
### Arquitetura:

A arquitetura padrão é composta por:

```bases```: Pacote que contem a classe base, no qual contem as configurações para 
os testes rodarem, por exemplo o metadados no header, base path ou conhecido como uri.
Devem ser herdadas de toda classe "Test".

```objects```: Pacote que contem as classes que representam os objetos que serão utilizados
para serializar os contratos (body) das requisições

```buildData```: Pacote que contém as classes que irão serializar os contratos dos objetos 
nas requisições.

```generate```: Pacote que contem as classes "factory" que irão gerar informações necessárias 
para as requisições, por exemplo o token.

```tests```: Pacote de classes que contém os métodos de testes

```pom.xml```: Arquivo de configuração do Maven, utilizando para incluir bibliotecas no projeto
e definir os procedimentos de build

____________________________________________
### Mais informações:

Para adicionar mais bibliotecas no projeto ou adicionar as bibliotecas no projeto, deve ser utilizado
o repositório do Maven para adiquirir as informações das bibliotecas e realizar as alterações no arquivo 
pom.xml.
- Repositório do Maven - [MVN Repository](https://mvnrepository.com/)