package space;

import java.util.ArrayList;
import java.util.Vector;

import actor.Jogador;

public class Inicio extends Celula {

	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr) {
		jogador.setCredito(10);
		return null;
	}
	
}
