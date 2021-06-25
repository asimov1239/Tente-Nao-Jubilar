package space;

import java.util.ArrayList;
import java.util.Vector;

import actor.Jogador;

public class Inicio extends Celula {

	public ArrayList<Object> efeito(Jogador jogador, int casas) {
		jogador.setCredito(10);
		return null;
	}
	
}
