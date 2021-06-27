package model;

import control.Pagamento;
import jogador.Jogador;
import view.IGUI;

import java.util.Random;
import java.util.Scanner;

public class Instituto extends Propriedade {
	private String[][] questoes;
	
	public void definirPropriedades(String[] props, String[][] questoes) {
		super.definirPropriedades(props, questoes);
		this.questoes = questoes;
	}
	
	public Pagamento efeito(Jogador jogador, int casas, String[][] sr, IGUI gui) {
		gui.setOutputText("Você caiu em " + nome + "!");
		Scanner teclado = new Scanner(System.in);
		Pagamento pagamento = null;
		if (!questionar(teclado, gui)) {
			jogador.setCredito(-aluguel);
		}
		else { 
			jogador.setCredito(aluguel/2);
			if (dono == null) {
				if (jogador.getCredito() > custo) {
					gui.setOutputText("Você deseja comprar " + nome + "? Lhe custará " + custo + " e você receberá " + aluguel + " de aluguel +" +
						"\n\nDigite sim ou nao.");
					String resposta = gui.getInputText();
					if (resposta.equalsIgnoreCase("sim")) {
						jogador.setCredito(-custo);
						jogador.adicionarPropriedade(this);
						this.dono = jogador.getNome();
						gui.setOutputText("Voce comprou " + nome + "!");
					}
					else {
						gui.setOutputText("Tudo bem! Quem sabe outra hora.");
					}
				}
				else {
					gui.setOutputText("Você não tem créditos suficientes para comprar essa propriedade.");
				}
			}
			else {
				if (!jogador.getNome().equals(dono)) {
					gui.setOutputText(nome + " é propriedade de " + dono + ". Lhe pague o aluguel de " + aluguel + " creditos.");
					jogador.setCredito(-aluguel);
					pagamento = new Pagamento(aluguel, dono);
				}
			}
		}
		return pagamento;
	}
	
	public boolean questionar(Scanner teclado, IGUI gui) {
		Random random = new Random();
		int indice = random.nextInt(questoes.length);
		gui.setOutputText("Responda a seguinte questão:\n" + questoes[indice][0]);
		String resposta = gui.getInputText();
		boolean acerto = (resposta.equalsIgnoreCase(questoes[indice][1]));
		if (!acerto) {
			gui.setOutputText("Errou! A resposta certa é: " + questoes[indice][1] + ". Pague " + aluguel + " créditos.");
		}
		else { 
			gui.setOutputText("Resposta Certa! Ganhe " + (aluguel/2) + " créditos.");
		}
		return acerto;
	}
	
}
