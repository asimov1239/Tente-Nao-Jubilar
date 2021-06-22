package control;

import actor.Jogador;

public interface IAcaoControle {
	
	public void iniciarJogadores(int numero);
	
	public void iniciarTabuleiro();
	
	public void iniciarJogo(int numero);
	
	public void executarTurno(Jogador jogador);
	
	public void executarRodada();
	
}