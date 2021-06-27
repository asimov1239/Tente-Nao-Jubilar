package control;

import java.util.Scanner;

import GUI.IGUI;
import actor.Jogador;
import builder.IMontador;
import space.ITabuleiro;


public class Controle implements IControle {
	private Jogador jogadores[];
	private Scanner teclado = new Scanner(System.in);
	private Dados dados = new Dados();
	private IMontador montador;
	private ITabuleiro tabuleiro;
	private IGUI gui;

	public Jogador[] getJogadores(){
		return jogadores;
	}

	public void connect(IGUI gui) {
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
	
	public void realizarPagamento(Pagamento pagamento) {
		for (int k = 0; k < jogadores.length; k++) {
			if (jogadores[k].getNome().equals(pagamento.getProprietario())) {
				jogadores[k].setCredito(pagamento.getCreditos());
			}
		}
	}
	
	public void eliminarJogador(int indice) {
		Jogador[] novos = new Jogador[jogadores.length - 1];
		int k = 0;
		for (int i = 0; i < novos.length; i++) {
			if (i != indice) {
				novos[i]= jogadores[k]; 
			}
			else {
				i -= 1;
			}
			k += 1;
		}
		this.jogadores = novos;
	}
	
	public boolean conferirVitoria() {
		if (jogadores.length == 1) {
			gui.setOutputText(jogadores[0].getNome() + " foi o único a não jubilar. Parabéns!");
			return true;
		}
		for (int i = 0; i < jogadores.length; i++) {
			if (jogadores[i].getCredito() >= 2000) {
				gui.setOutputText(jogadores[i].getNome() + " conseguiu 2000 créditos. Parabéns pelo seu diploma!");
				return true;
			}
		}
		return false;
	}
	
	public void executarTurno(Jogador jogador) {
		int casas = dados.rolar();
		gui.mostrarTurno(casas);
		Pagamento pagamento = tabuleiro.moverJogador(casas, jogador, teclado, gui);
		if (pagamento != null) {
			realizarPagamento(pagamento);
		}
		gui.esperarPassar();
	}
	
	public boolean executarRodada() {
		for (int i = 0; i < jogadores.length; i++) {
			gui.setOutputText("Vez do Jogador: " + jogadores[i].getNome() + ". Role os dados.");
			if (jogadores[i].getAtraso() > 0) {
	    		jogadores[i].setAtraso(-1);
	    		gui.setOutputText(jogadores[i].getNome() + " está atrasado!");
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
	    	}
			executarTurno(jogadores[i]);
			if (jogadores[i].getCredito() == 0) {
				gui.setOutputText(jogadores[i].getNome() + " foi Jubilado! Boa sorte da próxima vez.");
				eliminarJogador(i);
			}
			if (conferirVitoria()) {
				return true;
			}
		}
		return false;
	}
	
	public void executarJogo() {
		gui.iniciarGUI();
		int numeroJogadores = gui.numeroJogadores();
		iniciarJogo(numeroJogadores);
		boolean fim = false;
		while (!fim) {
			fim = executarRodada();
		}
		gui.setOutputText("-- FIM DO JOGO! --");
	}
}
