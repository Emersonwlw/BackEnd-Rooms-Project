
# Rooms BackEnd

* *Projeto de Estudos Rooms com Spring*

Projeto desenvolvido para estudos com Spring-Boot no back-end e Angular para o front end, 

Link para Repositório do Front End:


Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Editor de codigo (Intellij)](https://www.jetbrains.com/pt-br/idea/download/#section=windows), [Java JDK > 18](https://www.oracle.com/java/technologies/downloads/)


### 🎲 Rodando o Back End (API)
```bash

# Clone este repositório
$ git clone git@github.com:Emersonwlw/BackEnd-Rooms-Project.git

#Abra o projeto em seu intellij e execute

# o Server vai inicar em  <http://localhost:8080>

```



## Documentação da API


```

#### Cadastra uma sala

```http
  POST /api/v1/rooms

```
Body
{

    "name": "String",
    "date": "String",
    "starHour":"String",
    "endHour":"String"
}

#### Retorna todas as salas

```http 
  GET /api/v1/rooms
```
#### Retorna uma sala pelo Id

```http
  GET /api/v1/rooms/${id}
```

#### Altera uma sala pelo Id

```http
  PUT /api/v1/rooms/${id}
```
Body
{

    "name": "String",
    "date": "String",
    "starHour":"String",
    "endHour":"String"

}

#### Deleta uma sala pelo Id

```http
  DELETE /api/v1/rooms/${id}
```
## Stack utilizada

**Front-end:** Angular 

**Back-end:** Java, Spring-Boot

