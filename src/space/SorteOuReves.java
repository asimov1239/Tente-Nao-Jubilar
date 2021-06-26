package space;

import java.util.ArrayList;
import java.util.Random;

import GUI.GUI;
import actor.Jogador;

public class SorteOuReves extends Celula {
	
	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr, GUI gui) {
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
