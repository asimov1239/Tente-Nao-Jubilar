package space;

import GUI.IGUI;
import actor.Jogador;
import control.Pagamento;

public interface IAcaoCelula {
	
	public Pagamento efeito(Jogador jogador, int casas, String[][] sr, IGUI gui);
	
}
