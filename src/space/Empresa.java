package space;

import java.util.ArrayList;
import java.util.Scanner;

import GUI.GUI;
import actor.Jogador;

public class Empresa extends Propriedade {
	
	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr, GUI gui) {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Object> pagamento = null;
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
			}
		}
		else if (!jogador.getNome().equals(dono)) {
			int precoTotal = casas * aluguel;
			gui.setOutputText(nome + " é propriedade de " + dono + ". Lhe pague pelos seus servicos: " + casas + " * " + aluguel + " = " + precoTotal +  " creditos.");
			jogador.setCredito(-precoTotal);
			pagamento = new ArrayList<Object>(2);
			pagamento.add(dono);
			pagamento.add(precoTotal);
		}
		teclado.close();
		return pagamento;
		
		
		
		
		
	}
	
}
