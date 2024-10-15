### 3.3.6 Processo 6 – Suporte ao usuário vendedor

_Solicita;ão de suporte pelo usuário vendedor. Algumas melhorias podem incluir inclusão de dados a solicitação como imagens, tempo de resposta de solicitação, personalização da resposta a cada usuário e segurança no compartilhamento de informações_

![Modelo BPMN do PROCESSO 6](https://github.com/ICEI-PUC-Minas-PMGES-TI/pmg-es-2024-1-ti2-3740100-uihub/blob/d577347e89bda29e659d165f3e73a729e04f8d93/docs/images/Processo%206%20-%20Suporte%20ao%20usu%C3%A1rio%20vendedor.png)


#### Detalhamento das atividades

_Detalhamento das atividade sobre as atividades do processo de solicitação de suporte._

_* **Entrar na plataforma** - o usuário deve realizar login para solicitar suporte._

_* **Cadastro de usuário** - caso usuário não possua cadastro indica o processo de cadastro de usuários_

_* **Validar dados** - confere os dados do usuário no banco de dados de usuários._

_* **Requisitar suporte** - indica o tipo de suporte necessário._

_* **Auxiliar na peronalização** - indica tutoriais sobre como realizar personalização._

_* **Auxiliar na interface** - indica tutoriais sobre como interagir com a interface._

_* **Auxiliar no envio dos produtos** - indica tutoriais sobre como realizar o envio dos produtos aos usuários compradores._

_* **Auxiliar na segurança** - indica tutoriais sobre como ter segurança utilizando a plataforma._

_* **Encaminhar auxílio requisitado** - mostra ao usuário as informações de suporte requisitadas._

_* **Criar novas regras** - gerencia nova solução personalizada ao problema requisitado._  

_* **Registrar novas regras** - registra as novas regras no banco de dados de suporte ao usuário vendedor._

_* **Avaliar o serviço** - usuário indica satisfação com o suporte fornecido._

_* **Registrar solicitação** - sistema registra informações so processo de suporte._

_* **Suporte não fornecido** - envia mensagem ao usuário informando que o suporte não é coberto._

_Os tipos de dados a serem utilizados são:_

_* **Área de texto** - campo texto de múltiplas linhas_

_* **Caixa de texto** - campo texto de uma linha_

_* **Data e Hora** - campo do tipo data e hora (dd-mm-aaaa, hh:mm:ss)_

_* **Seleção múltipla** - campo com várias opções que podem ser selecionadas mutuamente (tradicional checkbox ou listbox)_

**Enviar solicitação de suporte**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| login           | Caixa de Texto   | formato de e-mail |                |
| senha           | Caixa de Texto   | mínimo de 8 caracteres |           |
| solicitação de suporte | Caixa de Texto | formato de texto |            |
| tipo de suporte | Caixa de seleção | escolha única |                    |
| solicitação de suporte | Caixa de Texto | formato de texto |            |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| entrar               | Login               | default           |
| enviar solicitação   | Início do processo suporte  |                   |
| avaliar | Banco de dados suporte |                   |
| enviar nova solicitação | Novo processo suporte  |                   |


**Conclusão da solicitação de suporte**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| mensagem de resposta | Caixa de Texto  |                |                   |
| indicar sucesso ou falha | Botão  | opção sim e não |                         |
| nova requisição do usuário | Caixa de Texto |                |                   |
| avaliar         | Botão            | formato 5 estrelas |                         |
| registrar        | Caixa de texto  | formato de banco de dados |                         |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| solicitação não concluída | enviar solicitação de suporte  | (default/cancel/  ) |
| avaliar             | finalizar processo  |                          |
| registro         | Banco de dados de suporte  |                                |
| solicitação concluída | finalizar processo            |                   |

