package model;

import control.Pagamento;
import jogador.Jogador;
import view.IGUI;

public interface IAcaoCelula {
	
	public Pagamento efeito(Jogador jogador, int casas, String[][] sr, IGUI gui);
	
}
