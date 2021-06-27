package space;

import java.util.Scanner;
import GUI.IGUI;
import actor.Jogador;
import control.Pagamento;

public interface ITabuleiro {
	
	public void definirTabuleiro(Celula[][] tab, String[][] sr);
	
	public int[] direciona(String direcao, int[] coords);
	
	public boolean direcaoValida(String opcao, String escolha);
	
	public void mostrarOpcoes(IGUI gui, String opcoes, int casasRestantes);
	
	public Pagamento moverJogador(int casas, Jogador jogador, Scanner teclado, IGUI gui);
	
	/*public void imprimir(Jogador[] jogadores);*/
	
}
