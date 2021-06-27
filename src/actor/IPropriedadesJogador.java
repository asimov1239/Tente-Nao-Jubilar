package actor;

import java.util.ArrayList;

import space.Propriedade;

public interface IPropriedadesJogador {
	
	public ArrayList<Propriedade> getPosses();
	
	public void adicionarPropriedade(Propriedade nova);
	
	public int getI();
    
    public int getJ();
    
    public String getNome();
    
    public String getUltimaBifurcacao();
    
    public int getAtraso();
    
    public int getCredito();
    
    public int getID ();

    public void setID (int id);
    
    public void setI(int i);
    
    public void setJ(int j);
    
    public void setAtraso(int qtde);
    
    public void setCredito(int qtde);
    
    public void setUltimaBifurcacao(String bifurcacao);
    
}
