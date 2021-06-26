package space;

import java.util.ArrayList;

import GUI.GUI;
import actor.Jogador;

public class Inicio extends Celula {

	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr, GUI gui) {
		jogador.setCredito(10);
		return null;
	}
	
}
