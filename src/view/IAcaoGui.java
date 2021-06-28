package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface IAcaoGui extends ActionListener {
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
    
    public void gameWait(int ms);

    public String lerJogadores(int num);

    public void mostrarPeca(int num);

    public void mostrarTurno(int casas);

    public void moverPeca(int id, String direcao);

    public String tomarDecisao(String direcao);

    public String getInputText();

    public void esperarPassar();

    @Override
    public void actionPerformed(ActionEvent e);
}
