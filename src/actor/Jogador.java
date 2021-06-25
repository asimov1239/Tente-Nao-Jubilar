package actor;

import java.util.ArrayList;

import space.Propriedade;

public class Jogador implements IJogador {
    private String nome, ultimaBifurcacao;
    private int credito, atraso;
    private ArrayList<Propriedade> posses;
    private int i, j;
    private boolean jubilado;

    public Jogador(String nome) {
        this.nome = nome;
        this.i = 0;
        this.j = 0;
        this.atraso = 0;
        this.credito = 250;
        this.ultimaBifurcacao = null;
        this.jubilado = false;
        this.posses = new ArrayList<Propriedade>();
    }

    public void adicionarPropriedade(Propriedade nova) {
    	posses.add(nova);
    }
    
    public int getI() {
    	return i;
    }
    
    public int getJ() {
    	return j;
    }
    
    public int getAtraso() {
    	return atraso;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public String getUltimaBifurcacao() {
    	return ultimaBifurcacao;
    }
    
    public int getCredito() {
    	return credito;
    }

    public boolean getJubilado() {
    	return jubilado;
    }
    
    public void setI(int i) {
    	this.i = i;
    }
    
    public void setJ(int j) {
    	this.j = j;
    }
    
    public void setAtraso(int qtde) {
    	this.atraso = atraso + qtde;
    }
    
    public void setCredito(int qtde) {
    	this.credito = credito + qtde;
    	if (credito < 0) {
    		credito = 0;
    		jubilado = true;
    	}
    }
    
    public void setUltimaBifurcacao(String bifurcacao) {
    	this.ultimaBifurcacao = bifurcacao;
    }
    
}