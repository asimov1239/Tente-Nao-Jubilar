package builder;

import dataSet.IDataReader;
import space.Celula;

public interface IAcaoMontador {
	public void connect(IDataReader dataReader);
	
	public void guardarTabuleiro();
	
	public String[][] guardarInformacoes(String dataSource, int linhas, int colunas, String sep);
	
	public void montarTabuleiro();
	
	public Celula[][] requisitarTabuleiro();
	
	public String[][] requisitarSR();
}
