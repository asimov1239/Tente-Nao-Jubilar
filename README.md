# Projeto Tente Nao Jubilar

# Descrição Resumida do Projeto/Jogo
O Tente Não Jubilar é uma versão adaptada do Monopólio (Ou Banco Imobiliário) para o mundo universitário, em que o objetivo é acumular Créditos através de fazer aulas e provas, seus adversários deverão parar nos institutos também para fazer as aulas que você já fez, gerando mais créditos! Vence o indíviduo que conseguir uma certa quantidade de créditos para passar de ano sem jubilar.

# Equipe
* Gabriel Bonfim Silva de Moraes - 216111
* Leandro Ponsano Corimbaba - 239084

# Vídeos do Projeto

> Segue o [vídeo do projeto.](https://drive.google.com/file/d/1C1yYbuWAi0JLtMh-GVp5yADwuRK5mTpg/view?usp=sharing)

# Slides do Projeto

> Segue os [slides do projeto.](/assets/outdated_assets/TrabalhoMC322.pptx)

# Documentação dos Componentes
## Diagramas
### Diagrama Geral do Projeto
Será atualizado até o fim do projeto.
![Diagrama](assets/outdated_assets/Diagrama.jpeg)

### Diagrama Geral de Componentes
![DiagramaComponentes](assets/outdated_assets/DiagramaComponentes.png)

### Componente Celula
Representa cada célula do tabuleiro, e pode ser do tipo Instituto, Empresa, Sorte Ou Revés e outros. Armazenará os preços de compra e aluguel.
![Celula](assets/outdated_assets/DiagramaCelula.png)

### Componente Tabuleiro
Sera compostO por uma matriz de células, e fará a movimentacão dos jogadores, bem como lhe oferecer a compra de propriedades.
![Tabuleiro](assets/outdated_assets/DiagramaTabuleiro.png)
#### Ficha Técnica

### Componente Jogador
Representa cada universitário, e armazena sua quantidade de créditos e as propriedades que possui.
![Jogador](assets/outdated_assets/DiagramaJogador.png)

### Componente Controle
Será o responsável por conduzir o jogo, as rodadas e os turnos.
![Controle](assets/outdated_assets/DiagramaControle.png)

### Componente Montador
Será o responsável por criar as células e montar o tabuleiro.
![Montador](assets/outdated_assets/DiagramaMontador.png)

### Componente DataSet
Esse componente fará o intermédio entre os outros componentes e os arquivos na pasta `data` (arquivos de entrada).
![DataSet](assets/outdated_assets/DiagramaDataSEt.png)

# Tabuleiro e Peças Utilizadas

## Tabuleiro Antigo:
![Tabuleiro](assets/outdated_assets/tabuleiro_antigo.png)

## Tabuleiro Atualizado:
Atualizamos o tabuleiro para deixa-lo mais complexo, criando atalhos e novas instituições.

![Tabuleiro](assets/Tabuleiro.jpg)

![Peça Verde](assets/GREEN.png)
![Peça Vermelha](assets/RED.png)
![Peça Azul](assets/BLUE.png)
