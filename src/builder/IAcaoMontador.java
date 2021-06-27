package builder;

import dataSet.IDataReader;
import space.Celula;

public interface IAcaoMontador {
	public void connect(IDataReader dataReader);
	
	public void guardarQuestoes(String arquivo);
	
	public void guardarTabuleiro();
	
	public void guardarSorteOuReves();
	
	public String[][] guardarInformacoes(String dataSource, int linhas, int colunas, String sep);
	
	public void montarTabuleiro();
	
	public Celula[][] requisitarTabuleiro();
	
	public String[][] requisitarSR();
}
