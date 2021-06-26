package space;

public abstract class Propriedade extends Celula {
	protected int aluguel, custo;
	protected String dono;
	
	public void definirPropriedades(String[] props, String[][] questoes) {
		super.definirPropriedades(props, questoes);
		this.custo = Integer.parseInt(props[4]);
		this.aluguel = Integer.parseInt(props[5]);
		this.dono = null;
	}
	
}
