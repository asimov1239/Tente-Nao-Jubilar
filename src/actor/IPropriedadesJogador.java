package actor;

import space.Propriedade;

public interface IPropriedadesJogador {
	
	public int getI();
    
    public int getJ();
    
    public void setI(int i);
    
    public void setJ(int j);
    
    public void adicionarPropriedade(Propriedade novaPropriedade);
    
}
