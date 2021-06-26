package space;

import java.util.ArrayList;
import java.util.Vector;

import actor.Jogador;

public class Atraso extends Celula {
	private int rodadas;
	
	public Atraso(int rodadas) {
		this.rodadas = rodadas;
	}
	
	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr) {
		jogador.setAtraso(rodadas);
		return null;
	}
	
}
