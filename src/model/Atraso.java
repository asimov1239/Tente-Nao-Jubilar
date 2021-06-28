package model;

import control.Pagamento;
import jogador.IJogador;
import view.IGUI;

public class Atraso extends Celula {
	private int rodadas;
	
	public Atraso(int rodadas) {
		this.rodadas = rodadas;
	}
	
	public Pagamento efeito(IJogador jogador, int casas, String[][] sr, IGUI gui) {
		if(rodadas == 1) {
			gui.setOutputText("Hora de comer aquele misto de carnes gostoso.\n\n Vai atrasar um turno!");
		} else if (rodadas == 2) {
			gui.setOutputText("Ficou sem estudar... olha no que deu!\n\n Vai atrasar DOIS turnos.");
		}

		jogador.setAtraso(rodadas);
		return null;
	}
	
}
