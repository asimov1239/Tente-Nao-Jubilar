package space;

import java.util.ArrayList;
import java.util.Vector;

import actor.Jogador;

public interface IAcaoCelula {
	
	public ArrayList<Object> efeito(Jogador jogador, int casas, String[][] sr);
	
}
