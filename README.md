# Projeto Tente Não Jubilar

# Descrição Resumida do Projeto/Jogo
O Tente Não Jubilar é uma versão do Monopólio (ou Banco Imobiliário) adaptada para o mundo universitário, em que o objetivo é acumular créditos fazendo aulas e provas. Seus adversários também deverão parar nos institutos da Unicamp para fazer as aulas que você já fez, gerando mais créditos! Vence o indivíduo que conseguir 2000 créditos para passar de ano sem jubilar.

# Equipe
* Gabriel Bonfim Silva de Moraes - 216111
* Leandro Ponsano Corimbaba - 239084

# Vídeos do Projeto
## Vídeo da Prévia
Segue o [vídeo da prévia.](https://drive.google.com/file/d/1C1yYbuWAi0JLtMh-GVp5yADwuRK5mTpg/view?usp=sharing)
## Vídeo do Jogo
Segue o [vídeo do jogo.](https://drive.google.com/file/d/1OBoeM81OLcTqqpvcwPD5f4qA_j5-4lNh/view?usp=sharing)

# Slides do Projeto
## Slides da Prévia
Segue os [slides da prévia.](assets/outdated_assets/TrabalhoMC322.pptx)
## Slides da Apresentação Final
Segue os [slides da apresentação.](assets/TrabalhoMC322.pdf)
## Relatório de Evolução
Inicialmente, não haviam as perguntas e respostas, e o tabuleiro era menor e mais simples. Após aconselhamento, o tabuleiro foi ampliado e também se aumentou a complexidade do jogo.  
O projeto foi iniciado de forma apressada: começamos a criar classes sem definir nossa estrutura de componentes, o que dificultou muito o desenvolvimento inicial do jogo. Apenas depois de distinguirmos os componentes, usando o padrão MVC, é que o trabalho progrediu. Ainda assim, houveram mudanças, por exemplo o Jogador, que deixou de ser um componente próprio e foi integrado ao Model.    
Em determinado momento, optamos por utilizar um `ArrayList<Object>` para representar um pagamento, e era necessário o uso de casts. Por ser uma má prática de programação, mudamos de rota e criamos uma classe a parte `Pagamento`. Para mais detalhes veja o [progresso](Progresso.md).    
A maior lição aprendida foi, sem dúvidas, que é de extrema importância um planejamento prévio, de "cima para baixo", antes de iniciar a implementação do código.  
No geral, a condução de um projeto próprio em sua totalidade foi uma experiência marcante, divertida e cativante. Pretende-se ainda refatorar o código com novos patterns aprendidos, a exemplo do Factory Pattern, além de adicionar um plano de exceções (não feito por questões de tempo) e outros features, tais como: mais jogadores, negociações, hipotecas, efeitos sonoros e outros. Mais ainda, o trabalho despertou a vontade de usar os conhecimentos obtidos em Programação Orientada a Objetos para criar novos projetos.

# Destaques de Código
## Destaque 1 - Herança e Polimorfismo
Nesse trecho destacamos como foi explorado o polimorfismo durante a criação das células.

```
	String tipo = tabuleiro[k][2];
	if (tipo.equals("pi")) {
		String nome = tabuleiro[k][3];
		String arquivo = "data/" + nome + ".csv";
		guardarQuestoes(arquivo);
		tab[i][j] = new Instituto(); 
	}
	else if (tipo.equals("pe")) {
		tab[i][j] = new Empresa(); 
	}
	else if (tipo.equals("sr")) {
		tab[i][j] = new SorteOuReves();
	}
	else if (tipo.equals("ex")) {
		tab[i][j]= new Atraso(2); 
	}
	else if (tipo.equals("ba")) {
		tab[i][j]= new Atraso(1); 
	}
	else if (tipo.equals("nn")) {
		tab[i][j] = new Atraso(0);
	}
	else if (tipo.equals("in")){
		tab[i][j]= new Inicio(); 
	}
```

## Destaque 2 - Uso de Classes Abstratas e Sobrecarga de Métodos
Aqui se destaca o uso de classe abstrata para `Celula` e `Propriedade`, já que cada herdeira tem sua própria implementação do método `efeito`. Já o método `definirPropriedades` é sobrecarregado.

```
public abstract class Celula implements ICelula {
	protected String direcao, tipo, nome;
	(...)
	public void definirPropriedades(String[] props, String[][] questoes) {
		this.direcao = props[1];
		this.tipo = props[2];
		this.nome = props[3];
	}
	public abstract Pagamento efeito(IJogador jogador, int casas, String[][] sr, IGUI gui);	
}
	
public abstract class Propriedade extends Celula {
	protected int aluguel, custo;
	protected String dono;
	public void definirPropriedades(String[] props, String[][] questoes) {
		super.definirPropriedades(props, questoes);
		this.custo = Integer.parseInt(props[4]);
		this.aluguel = Integer.parseInt(props[5]);
		this.dono = null;
	}
	(...)
}
```

## Destaque 3 - Uso de Interfaces Providas/Requeridas
Esse destaque mostra a conexão entre diferentes componentes por meio de métodos `connect`.

```
public class Main {
    public static void main(String[] args) {
    	IControle controle = new Controle();
	IGUI gui = new GUI();
    	IMontador montador = new Montador();
    	ITabuleiro tabuleiro = new Tabuleiro();
    	IDataReader dataReader = new DataReader();
    	montador.connect(dataReader);
	gui.connect(controle);
	controle.connect(gui);
    	controle.connect(montador);
    	controle.connect(tabuleiro);
    	controle.executarJogo();
    }
}
```

# Conclusões e Trabalhos Futuros
A maior conclusão tirada do projeto é de que é de extrema importância pensar de baixo por cima, isto é, fazer um planejamento dos componentes e do design do projeto antes de implementá-lo. Por questões de tempo não foi possível adicionar algumas funcionalidades, em especial uma animação para os dados e um plano de exceções. Embora saibamos da importância deste último, sua ausência não compromete o funcionamento do jogo.  
Poderia, também, ter sido usado o Factory Pattern, que pode vir a ser utilizado em uma futura refatoração do jogo.

# Documentação dos Componentes

# Diagramas

## Diagrama Geral de Componentes
![DiagramaComponentes](assets/DiagramaGeralComponentes.png)

## Componente dataSet
Responsável pela leitura dos arquivos de entrada, que contém informações importantes como: mapa do tabuleiro, custos e aluguéis, perguntas e respostas, efeitos do Sorte ou Revés e outros.  
![dataSet](assets/DiagramaDataSet.png)  
**Ficha Técnica**
* Classe: `src/dataSet/DataReader.java`
* Autores: Leandro Ponsano Corimbaba e André Santanche
* Interfaces: `src/dataSet/IDataReader.java`

## Componente Montador
Responsável por montar o tabuleiro, recebendo as informações do dataSet e passando a matriz de célula para o tabuleiro. É "contratado" pelo Control.  
![Montador](assets/DiagramaMontador.png)  
**Ficha Técnica**
* Classe: `src/montador/Montador.java`
* Autores: Leandro Ponsano Corimbaba
* Interfaces: `src/montador/IMontador.java`, `src/montador/IAcaoMontador.java` e `src/montador/IRDataReader.java`  
Interface agregadora do componente em java:

```
public interface IMontador extends IAcaoMontador, IRDataReader {
}
```

## Componente Model
Representa o espaço celular, ou seja, o tabuleiro e as células. Realiza a movimentação dos jogadores e executa o efeito de cada célula.  
Obs.: o Jogador pertence ao componente model embora, no projeto, esteja em um pacote separado (`jogador`).  
![Model](assets/DiagramaModel.png)  
**Ficha Técnica**
* Classe: `src/model/Tabuleiro.java`, `src/model/Celula.java`, `src/model/Propriedade.java`, `src/model/Inicio.java`, `src/model/Instituto.java`, `src/model/Empresa.java`, `src/model/Atraso.java`, `src/model/SorteOuReves.java` e `src/jogador/Jogador.java`.  
* Autores: Leandro Ponsano Corimbaba e Gabriel Bonfim Silva de Moraes
* Interfaces: `src/model/ITabuleiro.java`, `src/model/IAcaoCelula.java` , `src/model/IPropriedadesCelula.java`, `src/model/ICelula.java` e `src/jogador/IJogador.java`.  
Interface agregadora do componente em java:

```
public interface ICelula extends IAcaoCelula, IPropriedadesCelula {	
}
```

## Componente Control
Será o responsável por conduzir o jogo, as rodadas e os turnos.  
![Control](assets/DiagramaControl.png)  
**Ficha Técnica**
* Classe: `src/control/Controle.java`, `src/control/Dados.java`, `src/control/Pagamento.java` e `src/control/Main.java`
* Autores: Leandro Ponsano Corimbaba e Gabriel Bonfim Silva de Moraes
* Interfaces: `src/control/IAcaoControle.java`, `src/control/IControle.java`, `src/control/IRGUI.java`, `src/control/IRMontador.java` e `src/control/IRTabuleiro.java`  
Interface agregadora do componente em java:

```
public interface IControle extends IAcaoControle, IRMontador, IRTabuleiro, IRGUI {
}
```

## Componente View
Contratado pelo Control, é quem transporta o jogo para a interface gráfica criada.  
![View](assets/DiagramaView.png)  
**Ficha Técnica**
* Classe: `src/view/GUI.java`
* Autores: Gabriel Bonfim Silva de Moraes
* Interfaces: `src/view/IGUI.java`, `src/view/IAcaoGUI.java` e `src/IRControle/.java`  
Interface agregadora do componente em java:

```
public interface IGUI extends IAcaoGui, IRControle {	
}
```

## Detalhamento das Interfaces

### Interface IDataReader
Interface provida para a leitura de arquivos de entrada.

```
public interface IDataReader {
	public void setDataSource(String dataSource);
	public void readData(int lines, int columns, String sep);
	public String[][] requestData();
}
```
* `setDataSource`: define o caminho do arquivo a retirar informações.
* `readData`: lê o arquivo definido pelo método anterior e guarda suas informações.
* `requestData`: retorna as informações guardadas pelo método anterior, em forma de `String[][]`.

### Interface IRDataReader
Interface requerida para leitura de arquivos de entrada.

```
public interface IRDataReader {
	public void connect(IDataReader dataReader);		
}
```
* `connect`: conecta o objeto em questão (no caso, o Montador) a um objeto da classe DataReader. 

### Interface IAcaoMontador
Interface provida para montagem do tabuleiro.

```
public interface IAcaoMontador {
	public String[][] guardarInformacoes(String dataSource, int linhas, int colunas, String sep);
	public void guardarQuestoes(String arquivo);
	public void guardarTabuleiro();
	public void guardarSorteOuReves();
	public void montarTabuleiro();
	public Celula[][] requisitarTabuleiro();
	public String[][] requisitarSR();
}
```
* `guardarInformacoes`: usa o serviço de um `DataReader` para guardar as informações em dataSource. As informações são obtidas na forma de uma `String[linhas][colunas]`.
* `guardarQuestoes`: método guardarInformacoes com os parâmetros adequados.
* `guardarTabuleiro`: método guardarInformacoes com os parâmetros adequados.
* `guardarSorteOuReves`: método guardarInformacoes com os parâmetros adequados.
* `montarTabuleiro`: usa as informações obtidas pelo método `guardarTabuleiro` para montar uma matriz de `Celula`.
* `requisitarTabuleiro`: retorna a matriz de `Celula` criada pelo método anterior.
* `requisitarSr`: retorna a matriz de String criada pelo método `guardarSorteOuReves`.

### Interface ITabuleiro
Interface provida para a movimentação dos jogadores dentro do tabuleiro.

```
public interface ITabuleiro {
	public void definirTabuleiro(Celula[][] tab, String[][] sr);
	public int[] direciona(String direcao, int[] coords);
	public boolean direcaoValida(String opcao, String escolha);
	public void mostrarOpcoes(IGUI gui, String opcoes, int casasRestantes);
	public Pagamento moverJogador(int casas, IJogador jogador, Scanner teclado, IGUI gui);
	
```
* `definirTabuleiro`: armazena a matriz de `Celula` criada por um `Montador`, bem como a matriz de String contendo os efeitos do Sorte Ou Revés.  
* `direciona`: recebe uma String representando uma direção (ex: "d" para direita) e altera as coordenadas do jogador adequadamente.
* `direcaoValida`: verifica se a escolha de uma direção condiz com a bifurcação em questão.
* `mostrarOpcoes`: mostra ao jogador as direções que pode tomar em uma bifurcação.
* `moverJogador`: direciona o jogador ao longo do tabuleiro e executa o efeito da célula final. Devolve um objeto da classe Pagamento. Se não houver Pagamento envolvido na jogada, retorna null.

### Interface IAcaoCelula
Interface provida para executar o efeito específico da célula.

```
public interface IAcaoCelula {	
	public Pagamento efeito(IJogador jogador, int casas, String[][] sr, IGUI gui);
}
```
* `efeito`: executa seu efeito, que é específico para cada herdeira de `Celula`, como: questionar, realizar cobranças, sortear uma carta SorteOuRevés etc. Mesmo retorno do método `ITabuleiro.moverJogador()` 

### Interface IPropriedadesCelula
Interface provida para definir e obter propriedades de um objeto `Celula`.

```
public interface IPropriedadesCelula {
	public void definirPropriedades(String[] props, String[][] questoes);
	public String getDirecao();
	public String getTipo(); 
	public String getNome();	
}
```
* `definirPropriedades`: um "setter generalizado". 
* `getDirecao`: retorna o atributo `direcao`.
* `getTipo`: retorna o atributo `tipo`. 
* `getNome`: retorna o atributo `nome`.

### Interface IAcaoControle
Interface provida para a condução do jogo.

```
public interface IAcaoControle {
	public IJogador[] getJogadores();
	public boolean nomeJaEscolhido(String nome);
	public void iniciarJogadores(int numero) ;
	public void iniciarTabuleiro() ;
	public void iniciarJogo(int numero);
	public void realizarPagamento(Pagamento pagamento);
	public void eliminarJogador(int indice) ;
	public boolean conferirVitoria();
	public void executarTurno(IJogador jogador) ;
	public boolean executarRodada();
	public void executarJogo();
}
```
* `getJogadores`: retorna o atributo `jogadores`. 
* `connect`: métodos sobrecarregados: conecta o objeto em questão (no caso, um `Controle`) a um objeto `GUI`, `Montador` ou `Tabuleiro`.
* `nomeJaEscolhido`: verifica se o jogador escolheu para si um nome repetido. Se sim, pede que escolha outro nome.
* `iniciarJogadores`: inicia o atributo `jogadores`, um vetor de Jogadores.
* `iniciarTabuleiro`: requisita ao `Montador` que monte o `Tabuleiro`.
* `inicarJogo`: chama os 2 métodos anteriores.
* `realizarPagamento`: efetua a cobrança recebida pelo método `ITabuleiro.moverJogador()`, contanto que seja diferente de null.  
* `eliminarJogador`: elimina um jogador do vetor `jogadores`, se ele houver atingido 0 créditos.
* `conferirVitoria`: verifica se só sobrou um jogador, ou se um deles atingiu 2000 cŕeditos. Se sim , retorna `true` e o jogo é terminado.
* `executarTurno`: pede ao `Tabuleiro` que execute a vez de um jogador.
* `executarRodada`: chama o método anterior para cada um dos jogadores.
* `executarJogo`: chama o método anterior até que `conferirVitoria` retorne `true`. 

### Interface IJogador
Contém apenas getters e setters para os atributos do jogador.  

```
public interface IJogador {
    public ArrayList<Propriedade> getPosses();
    public int getID ();
    public void setID (int id);
    public void adicionarPropriedade(Propriedade nova);
    public int getI();
    public int getJ();
    public int getAtraso();
    public String getNome();
    public String getUltimaBifurcacao();    
    public int getCredito();    
    public void setI(int i);    
    public void setJ(int j);    
    public void setAtraso(int qtde);
    public void setCredito(int qtde);    
    public void setUltimaBifurcacao(String bifurcacao);
}
```
* `getPosses`: retorna o atributo `posses` (vetor de Propriedades);  
* `getID`: retorna o ID (número) do jogador;  
* `setID`: define o ID do jogador;  
* `adicionarPropriedade`: adiciona uma `Propriedade` ao atributo `posses`;  
* `getI`: retorna a posição i do jogador (linha na matriz do tabuleiro);  
* `getJ`: retorna a posição j do jogador (coluna na matriz do tabuleiro);  
* `getAtraso`: retorna o atributo `atraso` (quantidade de turnos que um jogador está suspenso);  
* `getUltimaBifurcacao`: retorna o atributo `ultimaBifurcacao`, que armazena a última escolha de direção feita pelo jogador (só é chamado quando o jogador está na casa central (3, 3));  
* `getCredito`: retorna a quantidade de crédito que o jogador possui;  
* `setI`: atualiza a coordenada i do jogador;  
* `setJ`: atualiza a coordenada j do jogador;  
* `setAtraso`: atualiza o atributo `atraso`;  
* `setCredito`: adiciona ou retira créditos do jogador;  
* `setUltimaBifurcacao`: armazena a última escolha de direção feita pelo jogador.   

### Interface IRGUI
Interface requerida para apresentação da interface gráfica.

```
public interface IRGUI {
	public void connect(IGUI gui);	
}
```
* `connect`: conecta o objeto em questão (no caso, um `Controle`) a um objeto `GUI`.

### Interface IRMontador
Interface requerida para montagem do tabuleiro.

```
public interface IRMontador {
	public void connect(IMontador montador);	
}
```
* `connect`: conecta o objeto em questão (no caso, um `Controle`) a um objeto `Montador`.

### Interface IRTabuleiro
Interface requerida para execução da movimentação do jogador no tabuleiro.

```
public interface IRTabuleiro {
	public void connect(ITabuleiro tabuleiro);	
}
```
* `connect`: conecta o objeto em questão (no caso, um `Controle`) a um objeto `Tabuleiro`.

### Interface IAcaoGUI
Interface provida para apresentação da interface gráfica.

```
public interface IAcaoGUI extends ActionListener {
    public void setTabuleiro();
    public void setPlayerButtons();
    public void setButtons();
    public void setConsole();
    public void setTextField();
    public void setInputField();
    public void setPecas();
    public void iniciarGUI();
    public void setOutputText(String text);
    public int numeroJogadores();
    public void gameWait(int ms);
    public String lerJogadores(int num);
    public void mostrarPeca(int num);
    public void mostrarTurno(int casas);
    public void moverPeca(int id, String direcao);
    public String tomarDecisao(String direcao);
    public String getInputText();
    public void esperarPassar();
    @Override
    public void actionPerformed(ActionEvent e);	
}
```
* `setTabuleiro`: define a apresentação do tabuleiro na interface gráfica.
* `setPlayerButtons`: define a apresentação dos botões do jogador na interface gráfica.
* `setButtons`: define a apresentação de todos os botões na interface gráfica.
* `setConsole`: define a apresentação do console  geral na interface gráfica.
* `setTextField`: define a apresentação do painel de mensagens na interface gráfica.
* `setInputField`: define a apresentação do painel de inserção de texto na interface gráfica.
* `setPecas`: define a apresentação das peças dos jogadores na interface gráfica.
* `inicarGUI`: inicia a interface, chamando os métodos anteriores.
* `setOutputText`: define a mensagem a ser exibida no painel.
* `numeroJogadores`: recebe o numero de jogadores.
* `gameWait`: provoca um pequeno "delay" para exibição das mensagens.
* `lerJogadores`: recebe o nome dos jogadores.
* `mostrarPeca`: torna visível a peça de um jogador específico.
* `mostrarTurno`: torna visível os botões de rolar dados e passar, nos momentos adequados.
* `moverPeca`: realiza a "animação" da peça se movendo pelo Tabuleiro.
* `tomarDecisao`: recebe decisão de direção do jogador.
* `getInputText`: retorna o texto obtido pelo painel de inserção de texto.
* `esperarPassar`: "aguarda" até que o jogador aperte no botão "Passar".
* `actionPerformed`: recebe o evento e associa uma ação correspondente ao evento.

### Interface IRControle
Interface requerida para condução do jogo.

```
public interface IRControle {
	public void connect(IControle controle);	
}
```
* `connect`: conecta o objeto em questão (no caso, um `GUI`) a um objeto `Controle`.




