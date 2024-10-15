### 3.3.5 Processo 5 – COMPRAR PRODUTOS

_Comprar Produtos. Algumas oportunidades de melhorias seria otimizar uma forma de pagamento propria do site alem de adicionar um carrinho que faz o usuario colocar no mesmo os produtos desejados assim tendo uma compra só em vez de varias "mini comprinhas" ._

![Compra de Produtos Diagrama](https://github.com/ICEI-PUC-Minas-PMGES-TI/pmg-es-2024-1-ti2-3740100-uihub/assets/6132658/8e19a954-54b5-45eb-9de2-55b7a35e679a)

#### Detalhamento das atividades

_Detalhamento das atividades do processo de pesquisa de projetos na UiHub.._

_Os tipos de dados a serem utilizados são:_

 **Imagem** - O produto será mostrado para o user em forma de imagem

 **Endereço** - O cliente preenche as informações sobre o endereçõ

 **Pagamento** - O cliente escolhe a forma do pagamento

 **Finalizar Compra** - O cliente finaliza a compra.

 **Preencher infomações**
 | **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
 | ---             | ---              | ---            | ---               |
 |Pagamento | Input Select| Escolher forma valida |- |
 |Nome                    | Input Text    | Obrigatório                    |  -     |          
 |Email                   | Input Email   | Formato de email válido          |  -        |      
 |Endereço                | Input Text    | Obrigatório                     |  -|
 |Complemento             | Input Text    | Opcional                                       | -       |          
 |Estado                  | Input Select  | Escolher estado válido                         | Escolha…    |      
 |CEP                     | Input Text    | Obrigatório                                    | -      |           
 |Pagamento               | Input Select  | Escolher forma válida                          | Cartão de crédito |
 |Código promocional      | Input Text    | Opcional                                       | -    |             

| **Comandos**  | **Destino**                                                     | **Tipo** |
| ------------- | --------------------------------------------------------------- | -------- |
| Finalizar compra | Página principal da loja | button  |


 **Preencher infomações sobre o cartão**
 | **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
 | ---             | ---              | ---            | ---               |
 |Nome no cartão          | Input Text    | Obrigatório se “Cartão de crédito” for selecionado | -    |         
 |Número do cartão de crédito | Input Text | Obrigatório se “Cartão de crédito” for selecionado | -  |           
 |Validade                | Input Text    | Obrigatório se “Cartão de crédito” for selecionado | -   |          
 |CVV                     | Input Text    | Obrigatório se “Cartão de crédito” for selecionado | -   |          

| **Comandos**  | **Destino**                                                     | **Tipo** |
| ------------- | --------------------------------------------------------------- | -------- |
| Finalizar compra | Página principal da loja | button  |
