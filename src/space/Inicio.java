package space;

import GUI.IGUI;
import actor.Jogador;
import control.Pagamento;

public class Inicio extends Celula {

	public Pagamento efeito(Jogador jogador, int casas, String[][] sr, IGUI gui) {
		gui.setOutputText("Passou pelo início, ganhe 10 créditos!");
		jogador.setCredito(10);
		return null;
	}
	
}
