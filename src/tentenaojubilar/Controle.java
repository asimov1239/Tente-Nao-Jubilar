package tentenaojubilar;

import java.util.Scanner;

public class Controle {
	private Jogador jogadores[] = new Jogador[3];
	private Tabuleiro tabuleiro = new Tabuleiro();
	private Scanner teclado = new Scanner(System.in);
	private Dados dados = new Dados();
	
	public void iniciarJogadores(int numero) {
		for (int i = 0; i < numero; i++) {
			String nome = teclado.nextLine();
			jogadores[i] = new Jogador(nome);
		}
	}
	
	public void iniciarTabuleiro() {
		Montador montador = new Montador();
		montador.montarTabuleiro(tabuleiro);
	}
	
	public void iniciarJogo(int numero) {
		iniciarJogadores(numero);
		iniciarTabuleiro();
	}
	
	public void executarTurno(Jogador jogador) {
		int casas = dados.rolar();
		tabuleiro.moverJogador(casas,jogador, teclado);
	}
	
	public void executarRodada() {
		for (int i = 0; i < jogadores.length; i++) {
			executarTurno(jogadores[i]);
		}
	}
	
	public void executarJogo() {
		int numeroJogadores = teclado.nextInt();
		iniciarJogo(numeroJogadores);
		boolean fim = false;
		while (!fim) {
			executarRodada();
		}
	}
}
