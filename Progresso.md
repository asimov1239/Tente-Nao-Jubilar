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

### Update 5
- Determinado os valores das propriedades, das empresas e do aluguel;
- Finalizado o tabuleiro, agora já pronto em assets;
- Finalizado todas as tabelas com as perguntas, respostas e o sorte-ou-revés;
- Verde Claro: IB 200, FCF 220, IQ 200;
- Rosa Claro: IEL 200, IA 220, IFCH 200;
- Verde Escuro: FEA 150, FEAGRI 200, FEQ 150;
- Azul Claro: FEM 300, FEEC 250, IC 250;
- Azul Escuro: IFGW 150, IMECC 200;
- Laranja: FCM 400, FEF 300;
- As empresas são as seguintes junto com os alugueis: BCCL (40), CONPEC(50), CASA DO LAGO(40) e DAC(50);
- O aluguel de uma empresa é calculada pegando o número dos dados e multiplicando pelo valor;

### Update 6
- Implementados: movimentacao do jogador, execucao dos efeitos de cada tipo de células, como: perguntas e respostas, pagamento de aluguel, compra de propriedades, atraso, entre outros;
- Classes Celula e Propriedade agora são classes abstratas, pois o método `efeito` é diferente para cada herdeira;
- Criada classe Atraso, herdeira de Celula;
- Foi feito um método para exibicão do tabuleiro no console, apenas temporário (haverá interface gráfica);
- Inicio da fase de debugging, vários pequenos erros ajustados;
- Foi utilizada a classe dinâmica ArrayList para representar os Pagamentos e o conjunto de Propriedades de um Jogador;
- OBS: na linha 52 do Controle.java foi feito um Cast. Posteriormente Será estudada uma melhor alternativa;
- Falta: implementar o efeito do Sorte ou Reves, implementar a interface gráfica, definir excecões;

### Major Update 7
- Interface criada usando JFrame!
- Classe GUI criada e System.out substituidos por setOutputText;
- Várias criações de botões, paineis e tabuleiro;
- falta fazer diversos testes, além de arrumar a posição do peão azul;
- Falta retirar o botão comprar!

### Update 8
- Continuacão da fase de testes;
- Ajuste de pequenos erros, mensagens, definicão das condicões de vitória, efeito do Sorte Ou Reves e outras celulas, eliminacão de jogadores, entre outros;
- Criada Classe Pagamento para realizar a cobranca de aluguel;
- Classe GUI agora implementa a interface IGUI (para fins de adequacão ao restante do projeto);
- Faltam: pequenos detalhes relacionados à interface gráfica, fase final do projeto.
