package jogador;

import java.util.ArrayList;

import model.Propriedade;

public class Jogador implements IJogador {
    private String nome, ultimaBifurcacao;
    private int credito, atraso;
    private ArrayList<Propriedade> posses;
    private int i, j;
    private int id;

    public Jogador(String nome) {
        this.nome = nome;
        this.i = 0;
        this.j = 0;
        this.atraso = 0;
        this.credito = 1000;
        this.ultimaBifurcacao = null;
        this.posses = new ArrayList<Propriedade>();
    }

    public ArrayList<Propriedade> getPosses() {
        return posses;
    }

    public int getID () {
        return id;
    }

    public void setID (int id) {
        this.id = id;
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
    	if (this.credito < 0) {
    		this.credito = 0;
    	}
    }
    
    public void setUltimaBifurcacao(String bifurcacao) {
    	this.ultimaBifurcacao = bifurcacao;
    }

}