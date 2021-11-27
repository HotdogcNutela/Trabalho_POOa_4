# Princípios SOLID
Por Marcus Vinícius Soares de Oliveira (RA 770026).

## Definição

Os princípios SOLID, estabelecidos pelo engenheiro de softwares Robert C. Martin (conhecido como "Uncle Bob"), consistem em princípios visando não só deixar o código mais orgazinado e enxuto como também facilitar para futuras expanções no código, tornando, assim, o trabalho do programador bem mais simples. Tais princípios são:

- **Princípio da Responsabilidade Única (SRP)**, o qual determina que cada classe tenha uma, e apenas uma, responsabilidade no projeto;
- **Princípio do Aberto/Fechado (OCP)**, o qual estabelece que os objetos de um programa devem ser abertos para expansão, mas fechados para alteração;
- **Princípio da Substituição de Liskov (LSP)**, o qual demanda que seja possível no projeto a substituição de quaisquer subtipos pelos seus tipos base;
- **Princípio da Segregação de Interface (ISP)**, o qual impõe que um grande conjunto de interfaces específicas é mais benéfico ao programa (contanto que tais interfaces sejam necessárias ao programa) do que um pequeno conjunto de interfaces generalizadas;
- **Princípio da Inversão de Dependências (DIP)**, o qual enfatiza que módulos de nível superior não devem depender de módulos de nível inferior, assim como os detalhes não devem ser dependentes de abstrações. Desse modo, as abstrações devem ser dependendes dos módulos e dos detalhes.

Pelas definições dos princípios acima, especialmente do LSP e do DIP, é possível perceber certas semelhanças dos princípios para com o método de encapsulamento, característico de linguagens orientadas a objeto e cujo objetivo visa também deixar o código mais organizado e enxuto, além de melhorar a estrutura do programa.

## Exemplo

Como exemplo, será utilizado o projeto de um programa Web de compra e venda de pacotes turísticos. Este sistema, apesar de ter sido feito para o curso de Desenvolvimento Web, possui detalhes importantes ao assunto desse trabalho, já que o projeto em questão obedece aos princípios SOLID. O exemplo tratará apenas dos esquemas arquiteturais DAO e Service para torná-lo mais coeso.
Começando pelo esquema DAO, percebe-se que tal esquema é formado, inicialmente, pelas classes do tipo entidade, localizadas [nesta pasta](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/domain) e pelas interfaces do tipo DAO, localizadas [nesta pasta](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/dao). As classes do tipo entidade dependem da classe abstrata [AbstractEntity](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/domain), o que impede cada classe entidade de ser dependente de outras classes entidade. A estrutura do projeto, até então, pode ser representado pelo diagrama abaixo.

![Diagrama1](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/Esquema%20DAO_2.png)

Enquanto isso, cada interface DAO é encarregada de administrar uma entidade diferente, como a interface [IClienteDAO](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/dao/IClienteDAO.java) que cuida de Cliente. Tais interfaces, em seguida, são utilizadas nas [classes do tipo Service](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/service/impl), as quais implementam as [interfaces Service](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/service/spec). A interface IClienteDAO, por exemplo, é utilizada por [ClienteService](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/service/impl/ClienteService.java), a qual implementa a interface [IClienteService](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/service/spec/IClienteService.java). Logo, o diagrama deve ficar assim:

![Diagrama2](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/Esquema%20DAO.png)

Após a implementação das classes Service, é possível fazer os [controladores](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/controller) para as classes de entidade, contanto que os controladores utilizem as classes Service necessárias. No caso da entidade Cliente, tanto [ClienteController](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/controller/ClienteController.java) quanto [PacoteController](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/controller/PacoteController.java) utilizam ClienteService, o qual é referenciado nos controladores como a interface IClienteControler. Por fim, a estrutura do projeto até aqui deve ser semelhante ao diagrama abaixo.

![Diagrama3](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/Esquema%20DAO_3.png)

Com o término da descrição de parte do projeto, é importante observar se o exemplo obedece aos princípios SOLID. Para isto, os códigos serão analisados com base em um princípio por vez:

- **SRP**: Com excessão de [AbstractEntity](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/domain), todas as classes e interfaces possuem uma única responsabilidade, cada uma restrita para uma única entidade, sendo que:
  - As interfaces do tipo DAO cuidam, de modo direto, do acesso de dados da entidade a qual são designadas;
  - As classes e consequentemente as interfaces do tipo Service tornam o acesso ao DAO de certa entidade mais seguro, além de poderem ser expandidos sem afetar a interface DAO;
  - Os Controllers são encarregados de controlar os serviços de uma entidade específica dependendo das ações realizadas na parte da Visão do projeto;
- **OCP**: Se for necessária a inclusão de uma nova classe do tipo entidade, basta criar as interfaces do tipo DAO e Service e as classes do tipo Service e Controller, específicas à nova classe e seguindo uma estrutura semelhante à de Cliente, sem a necessidade de alterar as outras classes e interfaces do projeto;
- **LSP**: Na pasta [domain](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/domain), quaisquer classes não-abstratas podem ser referenciadas como sua classe base AbstractEntity, embora não tenha sido necessário neste projeto. Todavia, as classes do tipo Service podem ser referenciadas como suas interfaces do tipo Service, o que acaba ocorrendo nas classes do tipo Controller;
- **ISP**: Tanto as interfaces DAO quanto as interfaces Service cuidam do acesso de dados de certa forma. No entanto, as interfaces DAO realizam seu objetivo de forma diferente das interfaces Service, além de serem restritos a uma entidade cada. Sendo assim, fica mais fácil realizar alterações no código de uma interface sem precisar alterar no das demais;
- **DIP**: Todas as alterações relacionadas às entidades são realizadas por meio das interfaces do tipo DAO e do tipo Service, cada uma delas específicas à cada entidade em questão. Isso se torna vantajoso às classes do tipo Controller, visto que para fazer alterações em uma entidade basta utilizar a interface do tipo Service responsável por tal entidade.

Após as análises acima, conclui-se que o exemplo obedece aos princípios SOLID.

## Conclusão

Embora aparentam ser complicados, os princípios SOLID acabam tornando os programas mais simples e seguros de serem não só criados como também expandidos, afirmação comprovada pelas análises do exemplo citado neste artigo. Logo, estes princípios são muito importantes para a elaboração de programas orientados a objeto decentes.


