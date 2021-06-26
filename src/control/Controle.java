package control;

import java.util.ArrayList;
import java.util.Scanner;

import actor.Jogador;
import builder.IMontador;
import space.ITabuleiro;
import space.Tabuleiro;

public class Controle implements IControle {
	private Jogador jogadores[];
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
		jogadores = new Jogador[numero];
		for (int i = 0; i < numero; i++) {
			System.out.println("Digite o nome do jogador " + (i+1));
			String nome = teclado.nextLine();
			jogadores[i] = new Jogador(nome);
		}
	}
	
	public void iniciarTabuleiro() {
		tabuleiro.definirTabuleiro(montador.requisitarTabuleiro(), montador.requisitarSR());
	}
	
	public void iniciarJogo(int numero) {
		iniciarJogadores(numero);
		iniciarTabuleiro();
	}
	
	public void executarTurno(Jogador jogador) {
		tabuleiro.imprimir(jogadores);
		int casas = dados.rolar();
		System.out.println("Voce tirou " + casas + " nos dados!");
		ArrayList<Object> pagamento = tabuleiro.moverJogador(casas, jogador, teclado);
		if (pagamento != null) {
			for (int k = 0; k < jogadores.length; k++) {
				if (jogadores[k].getNome().equals(pagamento.get(0))) {
					jogadores[k].setCredito((int)pagamento.get(1));
				}
			}
		}
	}
	
	public void executarRodada() {
		for (int i = 0; i < jogadores.length; i++) {
			System.out.println("VEZ DO JOGADOR " + jogadores[i].getNome());
			if (jogadores[i].getAtraso() > 0) {
	    		jogadores[i].setAtraso(-1);
	    		System.out.println("Está atrasado!");
	    		continue;
	    	}
			executarTurno(jogadores[i]);
		}
	}
	
	public void executarJogo() {
		System.out.println("Quantos Jogadores?");
		int numeroJogadores = Integer.parseInt(teclado.nextLine());
		iniciarJogo(numeroJogadores);
		boolean fim = false;
		for (int i = 0; i < 100; i++) {
			System.out.println("-------RODADA " + (i+1) + " -------\n");
			executarRodada();
		}
	}
}
