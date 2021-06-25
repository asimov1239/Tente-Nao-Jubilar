package space;

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
	
	public ArrayList<Object> efeito(Jogador jogador, int casas) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Object> pagamento = null;
		if (!questionar(teclado)) {
			jogador.setCredito(-10);
		}
		else { 
			if (dono == null) {
				if (jogador.getCredito() > custo) {
					System.out.println("Voce deseja comprar " + nome + "? Lhe custará " + custo + " e você receberá " + aluguel + " de aluguel");
					String resposta = teclado.nextLine();
					if (resposta.equalsIgnoreCase("sim")) {
						jogador.setCredito(-custo);
						jogador.adicionarPropriedade(this);
						this.dono = jogador.getNome();
						System.out.println("Voce comprou " + nome + "!");
					}
				}	
			}
			else if (!jogador.getNome().equals(dono)) {
				System.out.println(nome + " é propriedade de " + dono + ". Lhe pague o aluguel de " + aluguel + " creditos."); 
				jogador.setCredito(-aluguel);
				pagamento = new ArrayList<Object>(2);
				pagamento.add(dono);
				pagamento.add(aluguel);
			}
		}
		return pagamento;
	}
	
	public boolean questionar(Scanner teclado) {
		Random random = new Random();
		int indice = random.nextInt(questoes.length);
		System.out.println(questoes[indice][0]);
		String resposta = teclado.nextLine();
		boolean acerto = (resposta.equalsIgnoreCase(questoes[indice][1]));
		if (!acerto) {
			System.out.println("Errou! A resposta certa é: " + questoes[indice][1] + ". Pague 10 créditos.");
		}
		else { 
			System.out.println("Resposta Certa!");
		}
		return acerto;
	}
	
}
