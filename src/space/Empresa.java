package space;

import java.util.Scanner;
import GUI.IGUI;
import actor.Jogador;
import control.Pagamento;

public class Empresa extends Propriedade {
	
	public Pagamento efeito(Jogador jogador, int casas, String[][] sr, IGUI gui) {
		gui.setOutputText("Você caiu em " + nome + "!");
		Scanner teclado = new Scanner(System.in);
		Pagamento pagamento = null;
		if (dono == null) {
			if (jogador.getCredito() > custo) {
				gui.setOutputText("Voce deseja comprar " + nome + "? Lhe custará " + custo + " e você receberá " + aluguel + " de aluguel" +
						"\n\n Digite e envie um sim ou nao!");
				String resposta  = gui.getInputText();
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
			if ((!jogador.getNome().equals(dono))) {
				int precoTotal = casas * aluguel;
				gui.setOutputText(nome + " é propriedade de " + dono + ". Lhe pague pelos seus servicos: " + casas + " * " + aluguel + " = " + precoTotal +  " creditos.");
				jogador.setCredito(-precoTotal);
				pagamento = new Pagamento(precoTotal, dono);
			}
		}
		teclado.close();
		return pagamento;	
	}
	
}
