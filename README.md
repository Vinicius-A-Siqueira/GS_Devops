
# Projeto FloodTech - API REST com Oracle e Docker

Este projeto consiste em uma API RESTful desenvolvida em Java Spring Boot que realiza operações CRUD na tabela `tbl_usuario` em um banco de dados Oracle executado via container Docker.

---

## Pré-requisitos

- Docker e Docker Compose instalados  
- Java 17 (para build local, opcional)  
- Maven (para build local, opcional)

---

## Containers utilizados

- **custom-oracle**: Container do banco Oracle XE 11g customizado.  
- **floodtech-api**: Container da API REST em Java, que consome o banco Oracle.

---

## Instruções para executar

### 1. Build da API

```bash
docker build -t floodtech-api .
```

### 2. Build do Oracle customizado

```bash
docker build -t custom-oracle ./oracle-db
```

### 3. Executar os containers em background

```bash
docker run -d --name oracle-db -e ORACLE_PWD=senha123 -v oracle_data:/opt/oracle/oradata -p 1521:1521 custom-oracle

docker run -d --name floodtech-api -p 8080:8080 --link oracle-db:oracle floodtech-api
```

---

## Testes CRUD na tabela `tbl_usuario`

Os testes podem ser realizados utilizando os arquivos JSON e comandos curl abaixo:

### Arquivos JSON para testes

- `create_usuario.json`

```json
{
  "email": "usuario1@floodtech.com",
  "senha": "senha123",
  "tipo_usuario": "cidadão"
}
```

- `update_usuario.json`

```json
{
  "email": "usuario1atualizado@floodtech.com",
  "senha": "novaSenha456",
  "tipo_usuario": "operador"
}
```

### Comandos curl para o CRUD

- **Create (POST)**

```bash
curl -X POST http://localhost:8080/usuarios \
 -H "Content-Type: application/json" \
 -d @create_usuario.json
```

- **Read all (GET)**

```bash
curl -X GET http://localhost:8080/usuarios
```

- **Read by id (GET)**

```bash
curl -X GET http://localhost:8080/usuarios/1
```

- **Update (PUT)**

```bash
curl -X PUT http://localhost:8080/usuarios/1 \
 -H "Content-Type: application/json" \
 -d @update_usuario.json
```

- **Delete (DELETE)**

```bash
curl -X DELETE http://localhost:8080/usuarios/1
```

---

## Persistência

- Os dados estão persistidos no volume nomeado `oracle_data` que armazena os dados do banco Oracle.  
- Após cada operação CRUD, a persistência é garantida no banco.

---

## Vídeo Demonstrativo

Veja o vídeo que mostra o funcionamento completo da aplicação, incluindo todas as operações do CRUD e persistência dos dados:

▶️ [Vídeo Demonstrativo - Funcionamento Completo](https://youtu.be/2FGC28Tupp4?si=K1ByvAURs3UCE_uF)

---

## Arquivos Importantes

- `Dockerfile` da API  
- `Dockerfile` do Oracle customizado  
- Scripts SQL para criação da tabela `tbl_usuario` e demais tabelas necessárias  
- Arquivos JSON para testes CRUD (`create_usuario.json`, `update_usuario.json`)  
- Código-fonte Java completo da API (entidades, controllers, repositórios)

---

## Contatos

Qualquer dúvida ou sugestão, entre em contato com a equipe FloodTech.

---

*Projeto desenvolvido para a Global Solution - Eventos Extremos*
