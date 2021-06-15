package tentenaojubilar;

import java.util.Scanner;

public class Tabuleiro {
    private Celula[][] tab;
    
    public void moverJogador(int casas, Jogador jogador, Scanner teclado) {
    	int i = jogador.getI();
    	int j = jogador.getJ();
    	while (casas > 0) {
    		String direcao = tab[i][j].getDirecao();
    		
    		if (direcao.equals("D")) {
    			j += 1;
    		}
    		else if (direcao.equals("E")) {
    			j -= 1;
    		}
    		else if (direcao.equals("B")) {
    			i += 1;
    		}
    		else if (direcao.equals("C")) {
    			i -= 1;
    		}
    		else if (direcao.equals("DB")) {
    			String escolha = teclado.nextLine();
    			if (escolha.equals("D")) {
    				j += 1;
    			}
    			else if (escolha.equals("B")) {
    				i += 1;
    			}
    		}
    		else if (direcao.equals("EC")) {
    			String escolha = teclado.nextLine();
    			if (escolha.equals("E")) {
    				j -= 1;
    			}
    			else if (escolha.equals("C")) {
    				i -= 1;
    			}
    		}
    		casas -= 1;
    	}
    	jogador.setI(i);
    	jogador.setJ(j);
    }
    
}
