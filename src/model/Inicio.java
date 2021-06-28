package model;

import control.Pagamento;
import jogador.IJogador;
import view.IGUI;

public class Inicio extends Celula {

	public Pagamento efeito(IJogador jogador, int casas, String[][] sr, IGUI gui) {
		gui.setOutputText("Passou pelo início, ganhe 10 créditos!");
		jogador.setCredito(10);
		return null;
	}
	
}
