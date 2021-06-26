package control;

import java.util.ArrayList;
import java.util.Scanner;

import GUI.GUI;
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
	private GUI gui;

	public Jogador[] getJogadores(){
		return jogadores;
	}

	public void connect(GUI gui) {
		this.gui = gui;
	}

	public void connect(ITabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public void connect(IMontador montador) {
		this.montador = montador;
	}
	
	public void iniciarJogadores(int numero) {
		jogadores = new Jogador[numero];
		for (int i = 0; i < numero; i++) {
			String nome = gui.lerJogadores(jogadores[i], i);
			jogadores[i] = new Jogador(nome);
			jogadores[i].setID(i);
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
		gui.mostrarTurno(casas);
//		System.out.println("Voce tirou " + casas + " nos dados!");
		ArrayList<Object> pagamento = tabuleiro.moverJogador(casas, jogador, teclado, gui);
		if (pagamento != null) {
			for (int k = 0; k < jogadores.length; k++) {
				if (jogadores[k].getNome().equals(pagamento.get(0))) {
					jogadores[k].setCredito((int)pagamento.get(1));
				}
			}
		}
		gui.esperarPassar();
	}
	
	public void executarRodada() {
		for (int i = 0; i < jogadores.length; i++) {
			gui.setOutputText("Vez do Jogador: " + jogadores[i].getNome());
			if (jogadores[i].getAtraso() > 0) {
	    		jogadores[i].setAtraso(-1);
	    		gui.setOutputText("Está atrasado!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
	    	}
			executarTurno(jogadores[i]);
		}
	}
	
	public void executarJogo() {
		gui.iniciarGUI();
		int numeroJogadores = gui.numeroJogadores();
//		System.out.println("Quantos Jogadores?");
//		int numeroJogadores = Integer.parseInt(teclado.nextLine());
		iniciarJogo(numeroJogadores);
		boolean fim = false;
		for (int i = 0; i < 100; i++) {
			System.out.println("-------RODADA " + (i+1) + " -------\n");
			executarRodada();
		}
	}
}
