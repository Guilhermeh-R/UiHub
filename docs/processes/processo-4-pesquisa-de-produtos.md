### 3.3.4 Processo 4 – PESQUISA DE PRODUTOS
_Pesquisa de produtos. As possíveis oportunidades de melhoria estão relacionadas com a velocidade com que a pesquisa acontece e com a interface amigável e de fácil
acesso._

![nova_img_bpmn](https://github.com/ICEI-PUC-Minas-PMGES-TI/pmg-es-2024-1-ti2-3740100-uihub/assets/67321539/388a7f5f-ea2f-48b8-8edd-0609c4fef8fb)


#### Detalhamento das atividades

_Detalhamento das atividades do processo de pesquisa de protudos na UiHub._

_Os tipos de dados a serem utilizados são:_

_* **Caixa de texto** - O usuário insere o nome do produto na barra de pesquisa_

_* **Verificação da existência do produto** - O sistema busca no banco de dados se o texto inserido existe_

_* **Verificação de estoque** - O sistema busca no banco de dados se o produto existente está disponível para venda_

_* **Mensagem final* - O sistema retorna ao usuario se o produto existe/está disponivel/não existe_


| Comandos          | Destino                       | Tipo          |
|------------------|------------------------------|---------------|
| [Pesquisar]      | Verificação da existência do produto | default       |

**Verificação da existência do produto**

| Campo            | Tipo           | Restrições                       | Valor default |
|------------------|----------------|-----------------------------------|--------------|
| Texto inserido   | Caixa de texto | Texto sem caracteres especiais   |               |

| Comandos          | Destino                       | Tipo          |
|------------------|------------------------------|---------------|
| [Verificar]     | Imagem do Produto | default       |
| [Cancelar]      | Retorno ao estado anterior | cancel        |
| [Produto não encontrado]      | Notificação de produto não encontrado | default     |


**Verificação de estoque**

| Campo            | Tipo           | Restrições                       | Valor default |
|------------------|----------------|-----------------------------------|--------------|
| Produto existente | Caixa de texto |                                   |              |

| Comandos          | Destino                       | Tipo          |
|------------------|------------------------------|---------------|
| [Enviar resposta] | Enviar resposta ao usuário | default       |
| [Cancelar]      | Retorno ao estado anterior | cancel        |

**Enviar resposta ao usuário**
| Campo            | Tipo           | Restrições                       | Valor default |
|------------------|----------------|-----------------------------------|--------------|
| Resposta ao usuário | Texto        |                                   |              |

| Comandos          | Destino                       | Tipo          |
|------------------|------------------------------|---------------|
| [OK]            | Retorno ao estado inicial   | default       |
