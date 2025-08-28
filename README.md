# CUIDAR MAIS ⚕🩺
A API Cuidar Mais foi desenvolvida com o intuito de organizar o agendamento, cancelamento e monitoramento de consultas em um consultório médico. O projeto foi construído utilizando Java 17 e o framework Spring Boot. Para o banco de dados, foi adotado o MySQL, e a documentação da API foi gerada com SpringDoc integrado ao Swagger, facilitando a visualização e teste dos endpoints.

## DESCRIÇÃO 📜
A Cuidar Mais é uma clínica médica fictícia que necessita de um sistema para gerenciar o cadastro de médicos, pacientes e o agendamento de consultas. Trata-se de uma API RESTful que permite operações CRUD (Create, Read, Update, Delete) para médicos e pacientes, além de funcionalidades específicas para agendamento e cancelamento de consultas. O foco é na simplicidade e eficiência, garantindo que usuários autorizados possam gerenciar os dados de forma segura e intuitiva.

### PRINCIPAIS RECURSOS 📍
- CRIAR: Permite adicionar novos médicos, pacientes e agendamentos de consultas.
- BUSCAR: Permite consultar médicos, pacientes e consultas cadastrados, com opções de filtro por ID ou outros critérios.
- EDITAR: Permite atualizar informações de médicos, pacientes e detalhes de consultas existentes.
- DELETAR: Permite remover médicos, pacientes ou cancelar consultas de forma permanente.
- AGENDAMENTO E CANCELAMENTO: Funcionalidades dedicadas para marcar e cancelar consultas, com validações para evitar conflitos de horários.
- DOCUMENTAÇÃO: Acesse a interface Swagger para explorar todos os endpoints e testar a API interativamente.
  
### TECNOLOGIAS UTILIZADAS 🛠️
Linguagem: Java 17
Framework: Spring Boot (para API REST, injeção de dependências e configuração automática)
Banco de Dados: MySQL (para armazenamento persistente)
Documentação: SpringDoc com OpenAPI/Swagger (para geração automática de docs)
Gerenciador de Dependências: Maven (assumindo configuração padrão do Spring Boot)
Outros: Spring Data JPA para ORM, Spring Security (opcional para autenticação, se implementado)

### PRÉ-REQUISITOS 📋
Antes de executar o projeto, certifique-se de ter os seguintes itens instalados:

- Java JDK 17 ou superior (recomendado: OpenJDK ou Oracle JDK)
- Maven 3.6+ (para build e gerenciamento de dependências)
- MySQL 8.0+ (com um servidor local ou remoto configurado)
- Git (para clonar o repositório, se aplicável)
- Uma IDE como IntelliJ IDEA, Eclipse ou VS Code com suporte a Java.

### COMO EXECUTAR ⚙️

Clone o Repositório (se não tiver o código local):
git clone https://seu-repositorio.git](https://github.com/talitassousa/cuidarmais.git)
cd cuidar-mais

Compile e Instale Dependências:
Use o Maven para baixar as dependências e compilar o projeto:
mvn clean install

Execute a Aplicação:
Via Maven (recomendado para desenvolvimento):
mvn spring-boot:run

Ou gere o JAR executável e rode diretamente:
mvn package
java "-Dspring.profiles.active=prod" "-DDATASOURCE_URL=jdbc:mysql://localhost/cuidarmais_api" "-DDATASOURCE_USERNAME=ROOT" "-DDATASOURCE_PASSWORD=db_pass" -jar .\target\api-0.0.1-SNAPSHOT.jar

Acesse a API:
A aplicação roda por padrão na porta 8080. Acesse: http://localhost:8080.
Para documentação e testes: Abra o Swagger em http://localhost:8080/swagger-ui.html.

Parar a Aplicação:
Pressione Ctrl + C no terminal ou finalize o processo na IDE.

### ENDPOINTS PRINCIPAIS 🔗
Médicos: /api/medicos (GET/POST/PUT/DELETE)
Pacientes: /api/pacientes (GET/POST/PUT/DELETE)
Consultas: /api/consultas (POST para agendamento; DELETE para cancelamento)
