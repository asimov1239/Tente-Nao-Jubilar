package space;

import java.util.ArrayList;
import java.util.Scanner;

import actor.Jogador;
import exceptions.DirecaoInvalida;

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
    
    public ArrayList<Object> moverJogador(int casas, Jogador jogador, Scanner teclado) {
    	int coords[] = {jogador.getI(), jogador.getJ()};
    	while (casas > 0) {
    		String direcao = tab[coords[0]][coords[1]].getDirecao();
    		if (direcao.length() == 1) {
    			coords = direciona(direcao, coords);
    		}
    		else if (direcao.equals("db") || direcao.equals("ec")) {
    			boolean valido = false;
    			String escolha = null;
    			do {
    				System.out.println("Que caminho deseja tomar?");
    				escolha = teclado.nextLine();
    				valido = direcaoValida(direcao, escolha);
    			} while (!valido);
    			jogador.setUltimaBifurcacao(escolha);
    			coords = direciona(escolha, coords);
    		}
    		else if (direcao.equals("de")) {
    			String ultimaBifurcacao = jogador.getUltimaBifurcacao();
    			if (ultimaBifurcacao.equals("b")) {
    				coords = direciona("d", coords);
    			}
    			else if (ultimaBifurcacao.equals("c")) {
    				coords = direciona("e", coords);
    			}
    		}
    		casas -= 1;
    	}
    	jogador.setI(coords[0]);
    	jogador.setJ(coords[1]);
    	return tab[coords[0]][coords[1]].efeito(jogador, casas, sr);
    }
    
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
    
}
