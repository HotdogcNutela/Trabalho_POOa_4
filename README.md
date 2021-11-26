# Princípios SOLID

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

![Diagrama1](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/Esquema%20DAO.png)

Enquanto isso, cada interface DAO é encarregada de administrar uma entidade diferente, como a interface [IClienteDAO](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/dao/IClienteDAO.java) que cuida de Cliente. Tais interfaces, em seguida, são utilizadas nas [classes do tipo Service](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/service/impl), as quais implementam as [interfaces Service](https://github.com/HotdogcNutela/Trabalho_POOa_4/tree/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/service/spec). A interface IClienteDAO, por exemplo, é utilizada por [ClienteService](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/service/impl/ClienteService.java), a qual implementa a interface [IClienteService](https://github.com/HotdogcNutela/Trabalho_POOa_4/blob/main/PacotesTuristicos/src/main/java/br/ufscar/dc/dsw/service/spec/IClienteService.java). Logo, o diagrama deve ficar assim:

