package src;

public class Propriedade extends Celula {
	private String nome;
	private int aluguel;
	private int custo;
	
	public Propriedade(String nome, int aluguel, int custo) {
		this.nome = nome;
		this.aluguel = aluguel;
		this.custo = custo;
	}
}
