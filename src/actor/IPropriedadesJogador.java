package actor;

import space.Propriedade;

public interface IPropriedadesJogador {
	
	public void adicionarPropriedade(Propriedade nova);
	
	public int getI();
    
    public int getJ();
    
    public String getNome();
    
    public String getUltimaBifurcacao();
    
    public int getAtraso();
    
    public int getCredito();
    
    public boolean getJubilado();
    
    public void setI(int i);
    
    public void setJ(int j);
    
    public void setAtraso(int qtde);
    
    public void setCredito(int qtde);
    
    public void setUltimaBifurcacao(String bifurcacao);
    
}
