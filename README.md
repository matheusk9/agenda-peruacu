# Agenda Peruaçu

O projeto "Agenda Peruaçu" é uma aplicação desktop desenvolvida em Java com o framework Spring, utilizando o padrão DAO e JPA para acesso ao banco de dados MySQL. O objetivo do projeto é permitir o agendamento e acompanhamento de visitas a pontos turísticos por parte de grupos e guias turísticos de forma organizada e eficiente.

## Sistema

O sistema permite o cadastro de guias turísticos, grupos de turistas, responsável pelo grupo, atrativos turísticos e as visitas realizadas por cada grupo aos atrativos.
Os guias são cadastrados no sistema com suas informações pessoais, e são responsáveis por conduzir os grupos nos atrativos turísticos. Os grupos são formados pelos visitantes, incluindo o seu responsável.

Os atrativos turísticos são os locais a serem visitados pelos grupos, e cada atrativo possui um conjunto de informações como nome, descrição, horários de visitação, entre outros. As visitas são registradas no sistema, indicando o grupo que realizou a visita, o atrativo visitado e o período em que a visita ocorreu.
Com esse sistema, é possível ter um controle eficiente das visitas turísticas realizadas na região, além de gerenciar os guias turísticos e suas respectivas responsabilidades.

## Desenvolvimento
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)


A aplicação foi desenvolvida utilizando a linguagem Java e o framework Spring para gerenciar as dependências e prover injeção de dependências.

Foi utilizada a especificação JPA (Java Persistence API) para persistência de dados em um banco MySQL,realizando consultas usando a linguagem JPQL (Java Persistence Query Language), que permite consultas orientadas a objetos e mapeamento de entidades, proporcionando uma camada de abstração entre o código Java e o banco de dados.

Além disso, foi seguido o padrão DAO (Data Access Object) que é utilizado para a implementação das classes de acesso aos dados, que encapsulam as operações de CRUD (Create, Read, Update, Delete) para cada entidade do sistema.

A interface gráfica da aplicação foi desenvolvida utilizando o JavaFX em conjunto ao SceneBuilder, que permite a criação de interfaces modernas e interativas.
