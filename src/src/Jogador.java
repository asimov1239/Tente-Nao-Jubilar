package src;

//import java.util.ArrayList;

public class Jogador {
    private String nome;
    private int credito;
    private Propriedade[] posses;
    private int i, j;

    public Jogador(String nome) {
        this.nome = nome;
        this.i = 0;
        this.j = 0;
    }

    public void adicionarPropriedade(Propriedade novaPropriedade) {
        int novoTamanho = this.posses.length + 1;
        Propriedade[] novo = new Propriedade[novoTamanho];
        int j = 0;
        for (int i = 0; i < this.posses.length; i++) {
            novo[i] = posses[j];
            j++;
        }
        novo[j] = novaPropriedade; 
        this.posses = novo;
    }

    public int getI() {
    	return i;
    }
    
    public int getJ() {
    	return j;
    }
    
    public void setI(int i) {
    	this.i = i;
    }
    
    public void setJ(int j) {
    	this.j = j;
    }
    
}