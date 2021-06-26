package space;

import java.util.ArrayList;
import java.util.Scanner;

import actor.Jogador;

public interface ITabuleiro {
	
	public void definirTabuleiro(Celula[][] tab, String[][] sr);
	
	public ArrayList<Object> moverJogador(int casas, Jogador jogador, Scanner teclado); 
	
	public void imprimir(Jogador[] jogadores);
	
}
