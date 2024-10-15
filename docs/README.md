# UiHUB


**Amanda Bicalho Silva, 1440377@sga.pucminas.br**

**Felipe Prudêncio da Costa, felipe.costa.1497077@sga.pucminas.br**

**Guilherme Rodrigues, 1493984@sga.pucminas.br**

**João Augusto Aquino Campelo, 1272596@sga.pucminas.br**

---

Professores:

**Cleiton Silva Tavares**

**Ivan Luiz Vieira de Araújo**

---

_Curso de Engenharia de Software_

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade Católica de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

_**Resumo**. A UiHub é uma ferramenta fácil de usar que ajuda pessoas e empresas a criarem suas próprias lojas online. A proposta consiste na implementação de um painel no qual qualquer indivíduo possa efetuar o registro e desenvolver uma página destinada à apresentação de seus produtos. É ótima para quem não é expert em tecnologia e usa o Instagram e o WhatsApp para vender produtos online. O principal objetivo da UiHub é facilitar a criação de lojas online com um visual personalizado e de fácil usabilidade._

---


## 1. Introdução

_Este projeto apresenta a UiHub, uma ferramenta online com a proposta de tornar a criação de lojas online uma tarefa simples e acessível a todos._

### 1.1 Contextualização

_A Era Digital não só transformou a maneira como nós comunicamos e interagimos como sociedade, mas também a forma como fazemos negócios e criamos empresas. O advento da internet na década de 1990[1.1], a popularização dos computadores pessoais e smartphones, e os avanços na tecnologia na década de 2000[1.2] permitiram que a navegação online, as redes sociais e aplicativos de mensagens como Instagram e Whatsapp se tornassem indispensáveis. Gigantes do varejo e pequenos empreendedores tiveram acesso a opção de vender seus serviços e produtos por meio da internet, e assim o comércio eletrônico ganhou força._ 

_No mundo digital de hoje, mais de 20 anos depois do lançamento dos primeiros sites online, a presença digital é crucial para o sucesso de qualquer negócio. Principalmente depois que o mundo foi impactado pela pandemia de Covid-19, em 2020. Em um cenário empresarial, milhares de empreendedores tiveram que fechar suas lojas em espaços físicos devido a mínima circulação de pessoas e tiveram que se reinventar, descobrindo novas formas de vender usando a Internet para manter seus negócios ativos[1.3]. Essa revolução nas vendas online aconteceu não somente em Marketplaces ou plataformas sofisticadas de vendas, mas também via redes sociais, como por WhatsApp, já que existem mais de 2 bilhões de contas ativas do aplicativo no mundo[1.4], e Instagram, que lançou vendas nativas no aplicativo em maio de 2020 e está presente em 80% dos smartphones brasileiros, de acordo com dados da plataforma SemRush[1.5]._

### 1.2 Problema

_No entanto, para muitos empreendedores, a criação de uma loja online pode parecer uma tarefa desafiadora, especialmente para aqueles empreendedores com conhecimento técnico limitado e que tiveram que migrar seus negócios para o meio digital. Muitos, dependem de plataformas como Instagram e Whatsapp para suas vendas, plataformas que não oferecem a mesma experiência de compra que uma loja online dedicada, o que consequentemente dificulta o crescimento e escalabilidade da empresa._

### 1.3 Objetivo geral

_Nesse contexto, o objetivo é desenvolver uma plataforma de software nomeada como UiHub. Uma solução inovadora, uma ferramenta acessível e intuitiva, projetada para permitir que qualquer pessoa, independentemente de sua expertise técnica, crie sua própria loja virtual personalizada.._

#### 1.3.1 Objetivos específicos

_1 - Promover aos aspirantes ao merchandising sua propria pagina de vendas_

_2 - Garantir o máximo de customizações para a loja virtual_

_3 - Criar login e cadastro de novos usuários._

### 1.4 Justificativas

_A necessidade de um sistema como a UiHub surge da demanda crescente por uma solução que torne a criação de lojas online não apenas viável, mas também acessível a todos. Para a criação deste projeto destaca-se importância de facilitar o acesso à economia digital, promovendo a inclusão e permitindo que um espectro mais amplo de empreendedores participe ativamente do comércio online. A experiência de usuário otimizada oferecida pela UiHub acrescenta ainda mais valor, garantindo que as lojas online criadas se destaquem no competitivo cenário virtual._

## 2. Participantes do processo

_> Cada um desses usuários desempenham um papel crucial no processo e a UiHub foi projetada para atender às necessidades de todos._
 
_- Empreendedores digitais: O público Alvo da UiHub, empreendedores que desejam criar suas próprias lojas online, podem ser indivíduos ou empresas de qualquer tamanho que queiram ter um ambiente exclusivo de vendas online._

_- Clientes: Estes são os usuários finais que visitarão as lojas online dos empreendedores criadas usando a ferramenta UiHub. Eles valorizam uma experiência de usuário personalizada e otimizada ao fazer compras online._

_- Plataformas Digitais (Instagram e Whatsapp): Estas plataformas desempenham um papel crucial no processo de divulgação e venda de produtos online. Muitos vendedores dependem dessas plataformas para suas vendas e a UiHub foi pensada para integrar-se perfeitamente com elas._

_> Público alvo da UiHub_

_- Embora todas as pessoas possam se beneficiar de soluções de vendas online, o foco deste trabalho está no público que vende através das redes sociais, mas não tem um ambiente virtual próprio para adicionar seus produtos e serviços de forma personalizada e otimizada._

_- Desta forma, estabeleceu-se como público-alvo desta solução homens e mulheres entre 20 e 45 anos que se encontram vendendo pela internet e desejam aprimorar suas vendas através de um site próprio, visando uma navegação mais intuitiva, personalizada e segura para agregar mais valor para seus clientes._


![persona 1](https://github.com/ICEI-PUC-Minas-PMGES-TI/pmg-es-2024-1-ti2-3740100-uihub/assets/130014057/83432b9c-71d9-47c8-8c40-7488bc9810a2)


![persona 2](https://github.com/ICEI-PUC-Minas-PMGES-TI/pmg-es-2024-1-ti2-3740100-uihub/assets/130014057/e4f89aad-3060-4921-bf7e-09e6b127bf38)

## 3. Modelagem do processo de negócio

### 3.1. Análise da situação atual

_Ja existem negócios atualmente no mundo digital que utilizam de modo semelhante para favilitar o acesso a loja virtual de maneira mais simples. A Bagy (https://bagy.com.br/) e a Wix Store (https://pt.wix.com/ecommerce/loja-virtual) apresentam uma solução semelhante possibilitando a criação de lojas em um processo mais simples para quem deseja. Atualmente durante o processo de criação de uma loja virtual, são demandados vários processos, desde a criação da documentação, até o funcionamento da plataforma. A plataforma costuma ter processos que abarcam cadastro de usuários e o proprio processo de criação. A interação com as plataformas de compra, é uma necessidade comum do cotidiano de quem realiza compras online, logo um requisito comum aos clientes._

_Desejamos implementar esses processos, de forma a tornar a criação ainda mais simples, com o próprio usuário selecionando e montando desde a base, como fontes, imagens personalizadas, disposição de cores e afins._

### 3.2. Descrição geral da proposta

_.Nossa proposta visa simplificar a criação de lojas virtuais, permitindo que os próprios usuários personalizem suas lojas de forma intuitiva e eficiente._

_> Os principais aspectos incluem:_

_- Personalização: Os usuários poderão selecionar fontes, imagens e cores para suas lojas diretamento pelo site._

 - Permitir a venda e compra de produtos


_Pretende-se utilizar da linguagem JAVA para a criação e modularização do sistema. O sistema deve funcionar em território nacional, e permitir que qualquer usuário possa ter acesso desde que arcando com o custos de produção e manutenção do serviço entregue._

_Com isso pretendemos auxiliar a criação de forma simplificada, intuitiva e acessível a qualquer pessoa. Serão coletados dados de feedback dos usuários sempre buscando o aprimoramento de acordo com as sugestões recebidas. O time de suporte será responsável em guiar de forma que sejam seguidos os modelos mais recentes sobre marketing, fornecendo ideia de cores, fontes, como tirar foto dos produtos, dentre outros._

### 3.3. Modelagem dos processos

[PROCESSO 1 - Realizar Login](processes/processo-1-realizar-login.md)

[PROCESSO 2 - Cadastro De Novos Produtos](processes/processo-2-cadastro-de-novos-produtos.md)

[PROCESSO 3 – Configuração Da Loja](processes/processo-3-configuracao-da-loja.md)

[PROCESSO 4 - Pesquisa de Produtos](processes/processo-4-pesquisa-de-produtos.md)

[PROCESSO 5 - Compra de Produtos](processes/processo-5-comprar-produtos.md)

[PROCESSO 6 - Suporte ao usuário vendedor](processes/processo-6-suporte-ao-usuario-vendedor.md)


## 4. Projeto da solução

O documento a seguir apresenta o detalhamento do projeto da solução. São apresentadas duas seções que descrevem, respectivamente: modelo relacional e tecnologias.

[Projeto da solução](solution-design.md "Detalhamento do projeto da solução: modelo relacional e tecnologias.")


## 5. Indicadores de desempenho

O documento a seguir apresenta os indicadores de desempenho dos processos.

[Indicadores de desempenho dos processos](performance-indicators.md)


## 6. Interface do sistema

A sessão a seguir apresenta a descrição do produto de software desenvolvido. 

[Documentação da interface do sistema](interface.md)

## 7. Conclusão

_A UIhub permite aos novos empreendedores a começarem com o pé direito no mercado de trabalho com sua própria loja virtual customizável sem custos adicionais. A plataforma é totalmente User friendly e garantindo ao usuário controle total sobre suas vendas e o aumento de usuários. Ainda é previsto aprimoramentos na programa como adicionar os itens em carrinhos, mehorias de segurança e mais opções de customização, tudo com foco contínuo no usuário. Dito isso, a Uihub possui enorme potencial de liderar o mercado financeiro no suporte aos pequenos e médio empreendedores e vendedores do globo._

# REFERÊNCIAS


**[1.1]** - _KLEINA, Nilton. A história da Internet: a década de 1990 [infográfico]. TecMundo, 12 maio 2011. Disponível em: [link do artigo](https://www.tecmundo.com.br/infografico/10054-a-historia-da-internet-a-decada-de-1990-infografico-.htm). Acesso em: 17 mar. 2024._

**[1.2]** - _BBC BRASIL. Internet móvel: a revolução tecnológica do smartphone. BBC News Brasil, 7 dezembro 2021. Disponível em: [link do artigo](https://www.bbc.com/portuguese/internacional-55973855). Acesso em: 17 mar. 2024._

**[1.3]** - _SEBRAE. Coronavírus: como a pandemia impactou as vendas on-line. Sebrae, 15 abril 2020. Atualizado em 14 outubro 2022. Disponível em: [link do artigo](https://sebrae.com.br/sites/PortalSebrae/artigos/coronavirus-o-impacto-nas-vendas-online,ed84f8e520f71710VgnVCM1000004c00210aRCRD). Acesso em: 17 mar. 2024._

**[1.4]** - _DEAN, Brian. Estatísticas do WhatsApp em 2022: quantos usuários tem o app. Semrush, 30 novembro 2022. Disponível em: [link do artigo](https://pt.semrush.com/blog/estatisticas-whatsapp/). Acesso em: 17 mar. 2024._

**[1.5]** - _DEAN, Brian. 13 estatísticas sobre o Instagram: usuários, crescimento e mais. Semrush, 20 janeiro 2023. Disponível em: [link do artigo](https://pt.semrush.com/blog/estatisticas-instagram/). Acesso em: 17 mar. 2024._


# APÊNDICES


_Atualizar os links e adicionar novos links para que a estrutura do código esteja corretamente documentada._


## Apêndice A - Código fonte

[Código do front-end](../src/front) -- repositório do código do front-end

[Código do back-end](../src/back)  -- repositório do código do back-end


## Apêndice B - Apresentação final


[Slides da apresentação final](https://www.canva.com/design/DAGJEW_TQbg/kRVTbswUQhxcswLpWDoi-w/edit?utm_content=DAGJEW_TQbg&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)


[Vídeo da apresentação final](video/)






