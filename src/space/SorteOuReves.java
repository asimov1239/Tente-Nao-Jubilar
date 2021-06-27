package space;

import java.util.Random;

import GUI.IGUI;
import actor.Jogador;
import control.Pagamento;

public class SorteOuReves extends Celula {
	
	public Pagamento efeito(Jogador jogador, int casas, String[][] sr, IGUI gui) {
		gui.setOutputText("Sorte Ou Revés!");
		Random random = new Random();
		int indice = random.nextInt(sr.length);
		gui.setOutputText(sr[indice][0]);
		int pagar = Integer.parseInt(sr[indice][1]);
		int ganhar = Integer.parseInt(sr[indice][2]);
		if(pagar > ganhar) {
			gui.setOutputText(sr[indice][0] + "\n\n Vai ter que pagar " + pagar + " créditos!");
		} else {
			gui.setOutputText(sr[indice][0] + "\n\n Ganhou " + ganhar + " créditos!");
		}
		jogador.setCredito(ganhar-pagar);
		return null;
	}
}
