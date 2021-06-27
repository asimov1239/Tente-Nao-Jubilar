package model;

import control.Pagamento;
import jogador.Jogador;
import view.IGUI;

public abstract class Celula implements ICelula {
	protected String direcao, tipo, nome;
	
	public void definirPropriedades(String[] props, String[][] questoes) {
		this.direcao = props[1];
		this.tipo = props[2];
		this.nome = props[3];
	}
	
	public String getDirecao() {
		return direcao;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public abstract Pagamento efeito(Jogador jogador, int casas, String[][] sr, IGUI gui);
	
}
