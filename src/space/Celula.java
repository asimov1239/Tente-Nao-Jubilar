package space;

public class Celula implements ICelula {
	private String direcao, tipo, nome;
	
	public void definirPropriedades(String[] props, String[][] questoes) {
		this.direcao = props[1];
		this.tipo = props[2];
		this.nome = props[3];
	}
	
	public String getDirecao() {
		return direcao;
	}
	
}
