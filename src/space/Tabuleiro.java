package space;

import java.util.ArrayList;
import java.util.Scanner;

import actor.Jogador;

public class Tabuleiro implements ITabuleiro {
    private Celula[][] tab;
    
    public void definirTabuleiro(Celula[][] tab) {
    	this.tab = tab;
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
    
    public ArrayList<Object> moverJogador(int casas, Jogador jogador, Scanner teclado) {
    	int coords[] = {jogador.getI(), jogador.getJ()};
    	while (casas > 0) {
    		String direcao = tab[coords[0]][coords[1]].getDirecao();
    		if (direcao.length() == 1) {
    			coords = direciona(direcao, coords);
    		}
    		else if (direcao.equals("db") || direcao.equals("ec")) {
    			System.out.println("Que caminho deseja tomar?");
    			String escolha = teclado.nextLine();
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
    	return tab[coords[0]][coords[1]].efeito(jogador, casas);
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
