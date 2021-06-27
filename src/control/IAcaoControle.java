package control;

import actor.Jogador;

public interface IAcaoControle {
	
	public Jogador[] getJogadores();
	
	public void iniciarJogadores(int numero);
	
	public void iniciarTabuleiro();
	
	public void iniciarJogo(int numero);
	
	public void realizarPagamento(Pagamento pagamento);
	
	public boolean conferirVitoria();
	
	public void eliminarJogador(int indice);
	
	public void executarTurno(Jogador jogador);
	
	public boolean executarRodada();
	
	public void executarJogo();
	
}