Encurtador de Links

Projeto simples de encurtamento de URLs, criado com o objetivo de praticar desenvolvimento de APIs REST, aplicar boas práticas e explorar tecnologias modernas do ecossistema Java.

Tecnologias Utilizadas
Java 17 – Linguagem principal do projeto
Spring Web – Framework para desenvolvimento de APIs REST
Spring Data JPA – Facilita a integração com banco de dados
H2 Database – Banco de dados em memória para testes locais
Lombok – Reduz código boilerplate com anotações
Swagger / Springdoc – Documentação automática da API
Docker – Containerização da aplicação

Rotas da API
Método	Endpoint	Descrição
POST	/links	Cadastrar uma nova URL
GET	/{shortLink}	Acessar o link encurtado
GET	/links	Listar todos os links criados

Observação: A aplicação roda na porta 9999 por padrão.

Como Rodar o Projeto
1. Clonar o repositório
git clone https://github.com/DenisLindner/Encurtador-de-URL.git
cd Encurtador-de-URL

2. Rodar a aplicação
Opção 1 – Com IDE
Abra o projeto em IntelliJ, Eclipse ou VS Code.
Execute a classe principal Application.java.

Opção 2 – Com Docker
docker build -t link-shortener .
docker run -p 9999:8080 link-shortener


O container expõe a aplicação na porta 8080 dentro do container, mapeada para 9999 no host.

3. Acessar a documentação da API
Após iniciar a aplicação, abra o navegador:

http://localhost:9999/docs


A interface do Swagger será exibida, permitindo testar todas as rotas da API.
