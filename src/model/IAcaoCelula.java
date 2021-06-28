package model;

import control.Pagamento;
import jogador.IJogador;
import view.IGUI;

public interface IAcaoCelula {
	
	public Pagamento efeito(IJogador jogador, int casas, String[][] sr, IGUI gui);
	
}
