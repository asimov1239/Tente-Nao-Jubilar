package control;

import jogador.IJogador;

public interface IAcaoControle {
	
	public IJogador[] getJogadores();
	
	public boolean nomeJaEscolhido(String nome);
	
	public void iniciarJogadores(int numero) ;
	
	public void iniciarTabuleiro() ;
	
	public void iniciarJogo(int numero);
	
	public void realizarPagamento(Pagamento pagamento);
	
	public void eliminarJogador(int indice) ;
	
	public boolean conferirVitoria();
	
	public void executarTurno(IJogador jogador) ;
	
	public boolean executarRodada();
	
	public void executarJogo();
	
}