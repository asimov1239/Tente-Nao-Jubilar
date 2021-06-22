## Arquivo para Anotar o Progresso do Lab :D


### Update 1
- Escrevi um pouco sobre as classes e escrevi uma matriz das células com suas respectivas herdeiras;
- Falta definir um padrão monetário para o custo e o aluguel;

### Update 2
- Englobei as classes Instituto e Empresa na classe-mãe Propriedade, e ajustei as mencões à ela nas outras partes do código;
- Escrevi um pouco da classe Controle, basicamente a inicializacão do jogo e um pouco da movimentacão do Jogador;
- Criei a classe Montador, para montar o tabuleiro, é necessário implementá-la;
- Criei a classe Dados, uma classe simples para gerar int's aleatórios de 1 a 12;
- Adicionei getters e setters ao Jogador;

### Update 3
- Criado o tabuleiro (quase completo, falta 2 células de empresas) junto com as peças necessárias;
- Segue a legenda das células:  
1) Verde Claro: IB, FCF, IQ;  
2) Rosa Claro: IEL, IA, IFCH;  
3) Verde Escuro: FEA, FEAGRI, FEQ;  
4) Azul Claro: FEM, FEEC, IQ;  
5) Azul Escuro: IFGW, IMECC;  
6) Laranja: FCM, FEF;  

### Major Update 4
- Redefinida a estrutura de pacotes do projeto, agora divido nos seguintes componentes:  
1) actor: representa o jogador;  
2) builder: representa o montador do tabuleiro;  
3) control: representa o controle (que executará o jogo);  
4) dataSet: engloba a classe de leitura dos arquivos de entrada;  
5) space: representa o espaço celular, envolvendo tabuleiro, célula e suas herdeiras;  
6) view: representará a implementação da interface gráfica (ainda não iniciada).  
- Os métodos foram passados para as devidas interfaces. Também foram criadas as interfaces requeridas e feitas as conexões entre diferentes componentes;
- Montador do tabuleiro implementado;
- DataReader implementado;