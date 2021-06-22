package space;

import java.util.Scanner;

import actor.Jogador;

public interface ITabuleiro {
	
	public void definirTabuleiro(Celula[][] tab);
	
	public void moverJogador(int casas, Jogador jogador, Scanner teclado); 
	
}
