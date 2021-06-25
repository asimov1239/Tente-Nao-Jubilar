package control;

import builder.IMontador;
import builder.Montador;
import dataSet.DataReader;
import dataSet.IDataReader;
import space.ITabuleiro;
import space.Tabuleiro;

public class Main {

    public static void main(String[] args) {
    	Controle controle = new Controle();
    	IMontador montador = new Montador();
    	ITabuleiro tabuleiro = new Tabuleiro();
    	IDataReader dataReader = new DataReader();
    	montador.connect(dataReader);
    	controle.connect(montador);
    	controle.connect(tabuleiro);
    	controle.executarJogo();
    }
}
