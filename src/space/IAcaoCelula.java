package space;

import java.util.ArrayList;

import GUI.GUI;
import actor.Jogador;

public interface IAcaoCelula {
	
	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr, GUI gui);
	
}
