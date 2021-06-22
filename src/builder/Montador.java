package builder;

import dataSet.IDataReader;
import space.Bandeco;
import space.Celula;
import space.Empresa;
import space.Exame;
import space.Instituto;
import space.SorteOuReves;

public class Montador implements IMontador {
	private IDataReader dataReader;
	private String[][] tabuleiro = null, questoes = null;
	private Celula[][] tab;
	
	public void connect(IDataReader dataReader) {
		this.dataReader = dataReader;
	}
	
	public void guardarTabuleiro() {
		dataReader.setDataSourceBoard("../data/tabuleiro.csv");
		tabuleiro = dataReader.requestBoard();
	}
	
	public void guardarQuestoes(String arquivo) {
		dataReader.setDataSourceQuestions(arquivo);
		questoes = dataReader.requestQuestions();
	}
	
	public void montarTabuleiro() {
		guardarTabuleiro();
		for (int k = 0; k < tabuleiro.length; k++) {
			int i = Integer.parseInt(tabuleiro[k][0].substring(0, 1));
	    	int j = Integer.parseInt(tabuleiro[k][0].substring(2, 3));
			String tipo = tabuleiro[k][2];
			if (tipo.equals("pi")) {
				String nome = tabuleiro[k][3];
				String arquivo = nome + ".csv";
				guardarQuestoes(arquivo);
				tab[i][j] = new Instituto(); 
			}
			else if (tipo.equals("pe")) {
				String nome = tabuleiro[k][3];
				String arquivo = nome + ".csv";
				guardarQuestoes(arquivo);
				tab[i][j] = new Empresa(); 
			}
			else if (tipo.equals("sr")) {
				tab[i][j] = new SorteOuReves();
			}
			else if (tipo.equals("ex")) {
				tab[i][j]= new Exame(); 
			}
			else if (tipo.equals("ban")) {
				tab[i][j]= new Bandeco(); 
			}
			tab[i][j].definirPropriedades(tabuleiro[k], questoes);
		}
	}
	
	public Celula[][] requisitarTabuleiro() {
		return tab;
	}
}
