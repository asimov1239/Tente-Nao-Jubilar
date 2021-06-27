package montador;

import dataSet.IDataReader;
import model.Atraso;
import model.Celula;
import model.Empresa;
import model.Inicio;
import model.Instituto;
import model.SorteOuReves;

public class Montador implements IMontador {
	private IDataReader dataReader;
	private String[][] tabuleiro = null, questoes = null, sr = null;
	private Celula[][] tab = new Celula[7][7];
	
	public void connect(IDataReader dataReader) {
		this.dataReader = dataReader;
	}
	
	public String[][] guardarInformacoes(String dataSource, int linhas, int colunas, String sep) {
		dataReader.setDataSource(dataSource);
		dataReader.readData(linhas, colunas, sep);
		return dataReader.requestData();
	}
	
	public void guardarQuestoes(String arquivo) {
		questoes = guardarInformacoes(arquivo, 5, 2, ",&");
	}
	
	public void guardarTabuleiro() {
		tabuleiro = guardarInformacoes("data/tabuleiro.csv", 34, 6, ",");
	}
	
	public void guardarSorteOuReves() {
		sr = guardarInformacoes("data/sr.csv", 21, 3, ",&");
	}
	
	public void montarTabuleiro() {
		guardarTabuleiro();
		for (int k = 0; k < tabuleiro.length-1; k++) {
			int i = Integer.parseInt(tabuleiro[k][0].substring(0, 1));
	    	int j = Integer.parseInt(tabuleiro[k][0].substring(2, 3));
			String tipo = tabuleiro[k][2];
			if (tipo.equals("pi")) {
				String nome = tabuleiro[k][3];
				String arquivo = "data/" + nome + ".csv";
				guardarQuestoes(arquivo);
				tab[i][j] = new Instituto(); 
			}
			else if (tipo.equals("pe")) {
				tab[i][j] = new Empresa(); 
			}
			else if (tipo.equals("sr")) {
				tab[i][j] = new SorteOuReves();
			}
			else if (tipo.equals("ex")) {
				tab[i][j]= new Atraso(2); 
			}
			else if (tipo.equals("ba")) {
				tab[i][j]= new Atraso(1); 
			}
			else if (tipo.equals("nn")) {
				tab[i][j] = new Atraso(0);
			}
			else if (tipo.equals("in")){
				tab[i][j]= new Inicio(); 
			}
			else {
				System.out.println("Nao tem tipo");
			}
			tab[i][j].definirPropriedades(tabuleiro[k], questoes);
		}
	}
	
	public Celula[][] requisitarTabuleiro() {
		montarTabuleiro();
		return tab;
	}
	
	public String[][] requisitarSR() {
		guardarSorteOuReves();
		return sr;
	}
	
}
