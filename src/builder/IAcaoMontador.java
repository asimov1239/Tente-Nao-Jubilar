package builder;

import dataSet.IDataReader;
import space.Celula;

public interface IAcaoMontador {
	public void connect(IDataReader dataReader);
	
	public void guardarTabuleiro();
	
	public void guardarQuestoes(String arquivo);
	
	public void montarTabuleiro();
	
	public Celula[][] requisitarTabuleiro();
}
