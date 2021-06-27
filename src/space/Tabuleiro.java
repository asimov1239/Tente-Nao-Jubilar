package space;

import java.util.Scanner;
import GUI.IGUI;
import actor.Jogador;
import control.Pagamento;

public class Tabuleiro implements ITabuleiro {
    private Celula[][] tab;
    private String[][] sr;
    
    public void definirTabuleiro(Celula[][] tab, String[][] sr) {
    	this.tab = tab;
    	this.sr = sr;
    }
    
    public int[] direciona(String direcao, int[] coords) {
    	if (direcao.equals("d")) {
			coords[1] += 1;
		}
		else if (direcao.equals("e")) {
			coords[1] -= 1;
		}
		else if (direcao.equals("b")) {
			coords[0] += 1;
		}
		else if (direcao.equals("c")) {
			coords[0] -= 1;
		}
    	return coords;
    }
    
    public boolean direcaoValida(String opcao, String escolha) {
    	return (escolha.equals(opcao.substring(0, 1)) || escolha.equals(opcao.substring(1,  2)));
    }
    
    public void mostrarOpcoes(IGUI gui, String opcoes, int casasRestantes) {
    	String[] dir = new String[2];
    	for (int i = 0; i < opcoes.length(); i++) {
    		if (opcoes.charAt(i) == 'd') {
    			dir[i]= "a direita";
    		}
    		if (opcoes.charAt(i) == 'e') {
    			dir[i] = "a esquerda";
    		}
    		if (opcoes.charAt(i) == 'c') {
    			dir[i] = "cima";
    		}
    		if (opcoes.charAt(i) == 'b') {
    			dir[i] = "baixo";
    		}
    	}
    	gui.setOutputText("Que caminho deseja tomar?\n\nEscreva e envie a letra '" + opcoes.charAt(0) + "' se quiser ir para " + dir[0]
    			+ " ou '" + opcoes.charAt(1) + "' se quiser ir para " + dir[1] + ". Você ainda tem " + casasRestantes + " casa(s) para andar.");
    }
    
    public Pagamento moverJogador(int casas, Jogador jogador, Scanner teclado, IGUI gui) {
    	int coords[] = {jogador.getI(), jogador.getJ()};
    	int casasDado = Integer.valueOf(casas);
    	while (casas > 0) {
    		String direcao = tab[coords[0]][coords[1]].getDirecao();
    		if (direcao.length() == 1) {
    			coords = direciona(direcao, coords);
    			gui.moverPeca(jogador.getID(), direcao);
    		}
    		else if (direcao.equals("db") || direcao.equals("ec")) {
    			boolean valido = false;
    			String escolha = null;
				mostrarOpcoes(gui, direcao, casas);
    			do {
					escolha = gui.tomarDecisao(direcao);
    				valido = direcaoValida(direcao, escolha);
    			} while (!valido);
    			jogador.setUltimaBifurcacao(escolha);
    			coords = direciona(escolha, coords);
    			gui.moverPeca(jogador.getID(),escolha);
    		}
    		else if (direcao.equals("de")) {
    			String ultimaBifurcacao = jogador.getUltimaBifurcacao();
    			if (ultimaBifurcacao.equals("b")) {
    				coords = direciona("d", coords);
					gui.moverPeca(jogador.getID(),"d");
    			}
    			else if (ultimaBifurcacao.equals("c")) {
    				coords = direciona("e", coords);
					gui.moverPeca(jogador.getID(),"e");
    			}
    		}
    		casas -= 1;
    	}
    	jogador.setI(coords[0]);
    	jogador.setJ(coords[1]);
    	return tab[coords[0]][coords[1]].efeito(jogador, casasDado, sr, gui);
    }
    
    
    /*
    public void imprimir(Jogador[] jogadores) {
    	for (int i = 0; i < tab.length; i++) {
    		for (int j = 0; j < tab[i].length; j++) {
    			String casa = "";
    			for (int k = 0; k < jogadores.length; k++) {
    				if (jogadores[k].getI() == i && jogadores[k].getJ() == j) {
    					casa = Integer.toString(k) + " ";
    				}
    			}
    			if (casa == "") {
    				if (tab[i][j] != null) {
	    			casa = tab[i][j].getTipo();
		    		}
		    		else {
		    			casa = "  ";
		    		}
    			}
    			System.out.print(casa + " ");
    		}
    		System.out.print("\n");
    	}
    	System.out.print("\n");
    	for (int k = 0; k < jogadores.length; k++) {
    		System.out.println(jogadores[k].getNome() + ": " + jogadores[k].getCredito());
    	}
    }
    */
}
