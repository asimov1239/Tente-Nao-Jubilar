package space;

import java.util.Scanner;

import actor.Jogador;

public class Tabuleiro implements ITabuleiro {
    private Celula[][] tab;
    
    public void definirTabuleiro(Celula[][] tab) {
    	this.tab = tab;
    }
    
    public void moverJogador(int casas, Jogador jogador, Scanner teclado) {
    	int i = jogador.getI();
    	int j = jogador.getJ();
    	while (casas > 0) {
    		String direcao = tab[i][j].getDirecao();
    		
    		if (direcao.equals("d")) {
    			j += 1;
    		}
    		else if (direcao.equals("e")) {
    			j -= 1;
    		}
    		else if (direcao.equals("b")) {
    			i += 1;
    		}
    		else if (direcao.equals("c")) {
    			i -= 1;
    		}
    		else if (direcao.equals("db")) {
    			String escolha = teclado.nextLine();
    			if (escolha.equals("d")) {
    				j += 1;
    			}
    			else if (escolha.equals("b")) {
    				i += 1;
    			}
    		}
    		else if (direcao.equals("ec")) {
    			String escolha = teclado.nextLine();
    			if (escolha.equals("e")) {
    				j -= 1;
    			}
    			else if (escolha.equals("c")) {
    				i -= 1;
    			}
    		}
    		casas -= 1;
    	}
    	jogador.setI(i);
    	jogador.setJ(j);
    }
    
}
