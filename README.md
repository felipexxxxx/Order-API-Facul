# Microserviço de Gestão de Pedidos 🛒

## **Descrição do Projeto**  
Este projeto foi desenvolvido na disciplina de **Projeto de Arquitetura de Sistema** com o objetivo de criar um **microserviço de pedidos** utilizando **Spring Boot**. O microserviço permite a criação, consulta e confirmação de pedidos, além de expor endpoints REST para que outros microserviços possam interagir com ele. O banco de dados utilizado foi **MySQL**, hospedado na plataforma **Railway**.

---

## **Funcionalidades Principais**  
- **Criar Pedidos:** permite a criação de novos pedidos com informações como ID do usuário, ID do produto e valor total.  
- **Consultar Todos os Pedidos:** retorna uma lista com todos os pedidos cadastrados.  
- **Consultar Pedidos por ID do Usuário:** retorna os pedidos de um usuário específico.  
- **Consultar Detalhes de um Pedido:** exibe os detalhes de um pedido específico por ID.  
- **Confirmar Pedido:** permite alterar o status de um pedido de `PENDENTE` para `PAGO`.

---

## **Arquitetura do Projeto**  
O projeto segue uma arquitetura baseada em camadas:  
1. **Controller:** camada responsável por expor os endpoints REST.  
2. **Service:** camada de regras de negócio e processamento dos pedidos.  
3. **Repository:** camada de acesso ao banco de dados, utilizando `JpaRepository` para operações CRUD.  

---

## **Modelo de Dados**  

### **Tabela Pedido**  
| Campo        | Tipo     | Descrição                    |
|---------------|----------|------------------------------|
| `id`          | Integer  | Identificador único do pedido |
| `idUsuario`   | Integer  | Identificador do usuário que realizou o pedido |
| `idProduto`   | Integer  | Identificador do produto adquirido |
| `valorTotal`  | Double   | Valor total do pedido |
| `dataCompra`  | DateTime | Data e hora da realização do pedido |
| `status`      | Enum     | Status do pedido (`PENDENTE` ou `PAGO`) |

---

## **Endpoints da API REST**  

### **1. Criar Pedido**  
- **Rota:** `POST /pedido`  
- **Descrição:** Cria um novo pedido.  
- **Request Body:** contém as informações do pedido, como `idUsuario`, `idProduto`, `valorTotal` e `status`.  
- **Resposta:** retorna os dados completos do pedido criado, incluindo `id`, `dataCompra` e `status`.

---

### **2. Consultar Todos os Pedidos**  
- **Rota:** `GET /pedido/todos`  
- **Descrição:** Retorna uma lista com todos os pedidos cadastrados.  
- **Resposta:** lista de todos os pedidos com suas informações detalhadas.

---

### **3. Consultar Pedidos por Usuário**  
- **Rota:** `GET /pedido/usuario/{idUsuario}`  
- **Descrição:** Retorna os pedidos de um usuário específico pelo seu ID.  
- **Resposta:** lista de pedidos realizados pelo usuário.

---

### **4. Consultar Pedido por ID**  
- **Rota:** `GET /pedido/{id}`  
- **Descrição:** Retorna os detalhes de um pedido específico pelo seu ID.  
- **Resposta:** informações detalhadas do pedido, como `id`, `idProduto`, `valorTotal`, `dataCompra` e `status`.

---

### **5. Confirmar Pedido**  
- **Rota:** `PUT /pedido/{id}/confirmar`  
- **Descrição:** Atualiza o status do pedido de `PENDENTE` para `PAGO`.  
- **Resposta:** retorna as informações do pedido com o `status` atualizado.

---

## **Configuração do Banco de Dados**  
Para conectar ao banco de dados MySQL no Railway, as seguintes propriedades foram configuradas no arquivo `application.properties`:  
```properties
spring.datasource.url=jdbc:mysql://<host>:<port>/<database_name>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```
---

## **Como Executar o Projeto**  
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/microservico-pedidos.git
2. Abra o projeto em uma IDE Java (como IntelliJ ou Eclipse).
3. Configure as credenciais do banco de dados no arquivo application.properties.
4. Certifique-se de que o serviço MySQL no Railway esteja ativo.
5. Execute a aplicação Spring Boot (PedidoApplication.java).
6. A API estará disponível em http://localhost:8080.

---

## **Conclusão**  
Este projeto demonstra a implementação de um microserviço em **Spring Boot** com integração a um banco de dados **MySQL** hospedado na **Railway**. A aplicação expõe endpoints RESTful que permitem a criação, consulta e confirmação de pedidos, seguindo os princípios de uma arquitetura modular baseada em camadas.  

Com o uso de `JpaRepository` para o gerenciamento das operações no banco de dados e a exposição de APIs REST, o projeto está pronto para ser consumido por outros microserviços ou aplicações.  

---




