package control;

import jogador.Jogador;
import model.ITabuleiro;
import montador.IMontador;
import view.IGUI;

public interface IAcaoControle {
	
	public Jogador[] getJogadores();

	public void connect(IGUI gui);

	public void connect(ITabuleiro tabuleiro) ;
	
	public void connect(IMontador montador);
	
	public void iniciarJogadores(int numero) ;
	
	public void iniciarTabuleiro() ;
	
	public void iniciarJogo(int numero);
	
	public void realizarPagamento(Pagamento pagamento);
	
	public void eliminarJogador(int indice) ;
	
	public boolean conferirVitoria();
	
	public void executarTurno(Jogador jogador) ;
	
	public boolean executarRodada();
	
	public void executarJogo();
	
}