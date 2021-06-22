package space;

public class Propriedade extends Celula {
	private String[][] questoes;
	private int aluguel, custo;
	
	public void definirPropriedades(String[] props, String[][] questoes) {
		super.definirPropriedades(props, questoes);
		this.aluguel = Integer.parseInt(props[4]);
		this.custo = Integer.parseInt(props[5]);
		this.questoes = questoes;
	}
}
