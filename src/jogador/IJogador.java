package jogador;

import java.util.ArrayList;

import model.Propriedade;

public interface IJogador {
	
	public ArrayList<Propriedade> getPosses();

    public int getID ();

    public void setID (int id);

    public void adicionarPropriedade(Propriedade nova);
    public int getI();
    public int getJ();
    
    public int getAtraso();
    
    public String getNome();
    
    public String getUltimaBifurcacao();
    
    public int getCredito();
    
    public void setI(int i);
    
    public void setJ(int j);
    
    public void setAtraso(int qtde);
    
    public void setCredito(int qtde);
    
    public void setUltimaBifurcacao(String bifurcacao);
}
