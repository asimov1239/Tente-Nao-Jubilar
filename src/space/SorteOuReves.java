package space;

import java.util.ArrayList;
import java.util.Random;

import actor.Jogador;

public class SorteOuReves extends Celula {
	
	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr) {
		Random random = new Random();
		int indice = random.nextInt(sr.length);
		System.out.println(sr[indice][0]);
		int pagar = Integer.parseInt(sr[indice][1]);
		int ganhar = Integer.parseInt(sr[indice][2]);
		jogador.setCredito(ganhar-pagar);
		return null;
	}
}
