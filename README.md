[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=14160745&assignment_repo_type=AssignmentRepo)
# UiHUB

A UiHUB emerge como uma solução inovadora, uma ferramenta acessível e intuitiva, projetada para permitir que qualquer pessoa, independentemente de sua expertise técnica, crie sua própria loja virtual personalizada. Como objetivos específicos, esta ferramenta é ideal para quem usa o Instagram e o Whatsapp como canais de venda, tornando a transição para uma loja online uma experiência suave e sem complicações. A meta é proporcionar uma solução que não apenas simplifica o processo, mas também economiza significativamente tempo e recursos financeiros, contribuindo para uma experiência mais acessível e eficaz na entrada para o comércio eletrônico. 

## Integrantes

* Amanda Bicalho Silva
* Felipe Prudêncio da Costa
* Guilherme Rodrigues
* João Augusto Aquino Campelo

## Professor

* Cleiton Silva Tavares
* Ivan Luiz Vieira de Araújo

## Instruções de utilização

Para executar este projeto, você precisará instalar e configurar as seguintes ferramentas:

1. **Git**
2. **Java JDK (versão LTS 17)**
3. **MySQL Community Server 8**
4. **Apache Maven (versão >= 3.8.6)**
5. **Visual Studio Code (VSCode) com extensões para Java, Spring Boot e Live Server**

### 1. Instalar Git

1. **Baixar o Git:**
   - Acesse [Git Downloads](https://git-scm.com/downloads) e baixe a versão mais recente para o seu sistema operacional.

2. **Instalar o Git:**
   - Siga as instruções do instalador.
   - Durante a instalação, selecione as opções padrão.

3. **Verificar a instalação:**
   - Abra o terminal ou prompt de comando e execute:
     ```sh
     git --version
     ```
   - Verifique se a versão instalada é a mais recente.

### 2. Instalar Java JDK 17

1. **Baixar o JDK 17:**
   - Acesse [Oracle JDK Downloads](https://www.oracle.com/java/technologies/javase-downloads.html) e baixe a versão LTS 17.

2. **Instalar o JDK:**
   - Siga as instruções do instalador.

3. **Configurar as variáveis de ambiente:**
   - Abra o Painel de Controle e vá em Sistema > Configurações avançadas do sistema > Variáveis de Ambiente.
   - Clique em "Nova" para adicionar uma nova variável de ambiente:
     - Nome da variável: `JAVA_HOME`
     - Valor da variável: `C:\Program Files\Java\jdk-17.0.2` (ajuste conforme o diretório onde o JDK foi instalado).
   - Encontre a variável `Path` na lista de variáveis do sistema, selecione-a e clique em "Editar".
   - Adicione uma nova entrada: `%JAVA_HOME%\bin`.
   - Clique em OK para salvar as alterações.

4. **Verificar a instalação:**
   - Abra o terminal ou prompt de comando e execute:
     ```sh
     java -version
     ```
   - Verifique se a versão instalada é a 17.

### 3. Instalar MySQL Community Server 8

1. **Baixar o MySQL:**
   - Acesse [MySQL Community Server](https://dev.mysql.com/downloads/mysql/) e baixe a versão 8.

2. **Instalar o MySQL:**
   - Siga as instruções do instalador, configurando o nome de usuário (por exemplo, `root`) e senha.

3. **Configurar o MySQL:**
   - Certifique-se de que o MySQL Server está rodando.
   - Você pode usar um cliente como o [HeidiSQL](https://www.heidisql.com/download.php) para gerenciar o banco de dados.

### 4. Instalar Apache Maven

1. **Baixar o Maven:**
   - Acesse [Apache Maven Downloads](https://maven.apache.org/download.cgi) e baixe a versão 3.8.6 ou superior.

2. **Instalar o Maven:**
   - Extraia o arquivo baixado em um diretório, por exemplo, `C:\Program Files\Maven\apache-maven-3.8.6`.

3. **Configurar as variáveis de ambiente:**
   - Abra o Painel de Controle e vá em Sistema > Configurações avançadas do sistema > Variáveis de Ambiente.
   - Clique em "Nova" para adicionar uma nova variável de ambiente:
     - Nome da variável: `MAVEN_HOME`
     - Valor da variável: `C:\Program Files\Maven\apache-maven-3.8.6` (ajuste conforme o diretório onde o Maven foi extraído).
   - Encontre a variável `Path` na lista de variáveis do sistema, selecione-a e clique em "Editar".
   - Adicione uma nova entrada: `%MAVEN_HOME%\bin`.
   - Clique em OK para salvar as alterações.

4. **Verificar a instalação:**
   - Abra o terminal ou prompt de comando e execute:
     ```sh
     mvn -version
     ```
   - Verifique se a versão instalada é a 3.8.6 ou superior.

### 5. Instalar Visual Studio Code (VSCode) e Extensões

1. **Baixar e instalar o VSCode:**
   - Acesse [Visual Studio Code](https://code.visualstudio.com/) e baixe a versão mais recente.
   - Siga as instruções do instalador.

2. **Instalar extensões para desenvolvimento Java e Spring Boot:**
   - Abra o VSCode.
   - Vá para a aba de extensões (ícone de quadrado no lado esquerdo ou `Ctrl+Shift+X`).
   - Pesquise e instale as seguintes extensões:
     - **Extension Pack for Java**:
       - [Link para a extensão](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
     - **Spring Boot Extension Pack**:
       - [Link para a extensão](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-spring-boot)
     - **Live Server**:
       - [Link para a extensão](https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer)

### 6. Executar o Projeto

1. **Clonar o repositório:**
   - Abra o terminal e execute:
     ```sh
     git clone https://github.com/ICEI-PUC-Minas-PMGES-TI/pmg-es-2024-1-ti2-3740100-uihub.git
     ```

2. **Navegar até o diretório do projeto:**
   - No terminal, execute:
     ```sh
     cd pmg-es-2024-1-ti2-3740100-uihub
     ```

3. **Configurar o banco de dados no arquivo `application.properties`:**
   - No diretório `src/main/resources`, abra o arquivo `application.properties` e configure as seguintes propriedades:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     spring.jpa.hibernate.ddl-auto=update
     ```

4. **Abrir o projeto no Visual Studio Code:**
   - No VSCode, vá em `Arquivo > Abrir Pasta` e selecione o diretório do projeto.

5. **Compilar e executar o projeto:**
   - No VSCode, clique na classe principal com a anotação `@SpringBootApplication`.
   - Clique no botão "Run Java" que aparece no canto superior direito da janela do VSCode.

6. **Rodar o Live Server:**
   - No VSCode, abra o arquivo `index.html` (ou equivalente).
   - Clique com o botão direito no arquivo e selecione "Open with Live Server" para iniciar o servidor e visualizar a aplicação no navegador.


## Histórico de versões

* 0.0.1
    * Trabalhando na modelagem do processo de negócio.
* 0.0.2
    * Atualização do processo 1 - Reformulação, de "Cadastro de usuários" para "Realizar login".
* 0.0.3
    * Atualização do processo 4 (BPMN retornada pra 3 mensagens finais + atualização do desenvolvimento)
* 0.0.4
    * Inicio da implementação do back-end e do banco de dados do processo 01, utilizando java spring boot e mysql. Atualização do diagrama de modelo de dados.
* 0.0.5
    * Finalização da implementação do processo 01.
* 0.0.6
    * Atualização do "Modelo De Dados" e nos códigos relacionados a entidade "Produto". 
