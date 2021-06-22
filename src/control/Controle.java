package control;

import java.util.Scanner;

import actor.Jogador;
import builder.IMontador;
import space.ITabuleiro;
import space.Tabuleiro;

public class Controle implements IControle {
	private Jogador jogadores[] = new Jogador[3];
	private Scanner teclado = new Scanner(System.in);
	private Dados dados = new Dados();
	private IMontador montador;
	private ITabuleiro tabuleiro;
	
	public void connect(ITabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public void connect(IMontador montador) {
		this.montador = montador;
	}
	
	public void iniciarJogadores(int numero) {
		for (int i = 0; i < numero; i++) {
			String nome = teclado.nextLine();
			jogadores[i] = new Jogador(nome);
		}
	}
	
	public void iniciarTabuleiro() {
		tabuleiro.definirTabuleiro(montador.requisitarTabuleiro());
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
