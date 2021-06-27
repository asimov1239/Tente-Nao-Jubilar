package control;

import dataSet.DataReader;
import dataSet.IDataReader;
import model.ITabuleiro;
import model.Tabuleiro;
import montador.IMontador;
import montador.Montador;
import view.GUI;
import view.IGUI;

public class Main {

    public static void main(String[] args) {
    	IControle controle = new Controle();
		IGUI gui = new GUI();
    	IMontador montador = new Montador();
    	ITabuleiro tabuleiro = new Tabuleiro();
    	IDataReader dataReader = new DataReader();
    	montador.connect(dataReader);
		gui.connect(controle);
		controle.connect(gui);
    	controle.connect(montador);
    	controle.connect(tabuleiro);
    	controle.executarJogo();
    }
}
