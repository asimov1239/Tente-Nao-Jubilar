package space;

import GUI.GUI;
import actor.Jogador;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Instituto extends Propriedade {
	private String[][] questoes;
	
	public void definirPropriedades(String[] props, String[][] questoes) {
		super.definirPropriedades(props, questoes);
		this.questoes = questoes;
	}
	
	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr, GUI gui) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Object> pagamento = null;
		if (!questionar(teclado, gui)) {
			jogador.setCredito(-10);
		}
		else { 
			if (dono == null) {
				if (jogador.getCredito() > custo) {
					gui.setOutputText("Voce deseja comprar " + nome + "? Lhe custará " + custo + " e você receberá " + aluguel + " de aluguel +" +
							"\n\nDigite sim ou nao.");
					String resposta = gui.getInputText();
					if (resposta.equalsIgnoreCase("sim")) {
						jogador.setCredito(-custo);
						jogador.adicionarPropriedade(this);
						this.dono = jogador.getNome();
						gui.setOutputText("Voce comprou " + nome + "!");
					}
				}	
			}
			else if (!jogador.getNome().equals(dono)) {
				gui.setOutputText(nome + " é propriedade de " + dono + ". Lhe pague o aluguel de " + aluguel + " creditos.");
				jogador.setCredito(-aluguel);
				pagamento = new ArrayList<Object>(2);
				pagamento.add(dono);
				pagamento.add(aluguel);
			}
		}
		return pagamento;
	}
	
	public boolean questionar(Scanner teclado, GUI gui) {
		Random random = new Random();
		int indice = random.nextInt(questoes.length);
		gui.setOutputText("Responda a seguinte questão:\n" + questoes[indice][0]);
		String resposta = gui.getInputText();
		boolean acerto = (resposta.equalsIgnoreCase(questoes[indice][1]));
		if (!acerto) {
			gui.setOutputText("Errou! A resposta certa é: " + questoes[indice][1] + ". Pague 10 créditos.");
		}
		else { 
			gui.setOutputText("Resposta Certa!");
		}
		return acerto;
	}
	
}
