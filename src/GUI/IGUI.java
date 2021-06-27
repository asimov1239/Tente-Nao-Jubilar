package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import actor.Jogador;

public interface IGUI extends ActionListener, IRControle {

	public void setTabuleiro();

    public void setPlayerButtons();

    public void setButtons();

    public void setConsole();

    public void setTextField();

    public void setInputField();

    public void setPecas();

    public void iniciarGUI();

    public void setOutputText(String text);

    public int numeroJogadores();

    public String lerJogadores(Jogador jogador, int num);

    public void mostrarPeca(int num);

    public void mostrarTurno(int casas);

    public void moverPeca(int id, String direcao);

    public String tomarDecisao(String direcao);

    public String getInputText();

    public void esperarPassar();

    @Override
    public void actionPerformed(ActionEvent e);
	
}
