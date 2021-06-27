package view;

import control.IControle;
import jogador.Jogador;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements IGUI {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControle controle;
//    private JLabel[] displays;
    private JLabel[] pecas = new JLabel[3];
    private JPanel panelTab, panelConsole;
    private JButton botaoDados, botaoAns;
    private JButton[] playerButtons;
    private boolean[] playerButtonsStatus = {true,true,true};
    private JTextField inputField;
    private JTextArea textArea;
    private int jogadores;
    private int event;
    private String outputText = "", inputText = "";
    private boolean aux;
    private String[] cor = {"vermelha", "verde", "azul"};


    public void setTabuleiro() {
        panelTab = new JPanel();
        panelTab.setBackground(Color.gray);
        panelTab.setBounds(0,0, 450, 450);
        panelTab.setLayout(null);
        setPecas();
        JLabel tabuleiro = new JLabel(new ImageIcon("assets/Tabuleiro.jpg"));
        tabuleiro.setBounds(0,0,450,450);
        panelTab.add(tabuleiro);
    }

    public void setPlayerButtons() {
        playerButtons = new JButton[3];
        for(int i = 0; i < 3; i++) {
            playerButtons[i] = new JButton();
            playerButtons[i].setHorizontalTextPosition(JButton.LEFT);
            playerButtons[i].setFont(new Font("Calibri", Font.BOLD, 9));
            playerButtons[i].setBounds(125, 30 + 30*i, 70, 25);
            playerButtons[i].setFocusable(false);
            playerButtons[i].setEnabled(true);
            playerButtons[i].addActionListener(this);
            playerButtons[i].setVisible(false);
            if(i == 0) {
                playerButtons[i].setForeground(Color.RED);
            } else if (i == 1) {
                playerButtons[i].setForeground(Color.GREEN);
            } else if (i == 2) {
                playerButtons[i].setForeground(Color.BLUE);
            }
            panelConsole.add(playerButtons[i]);

        }
    }

    public void setButtons() {
        botaoDados = new JButton("Rolar dados");
        botaoDados.setHorizontalTextPosition(JButton.CENTER);
        botaoDados.setFont(new Font("Calibri", Font.BOLD, 12));
        botaoDados.setBounds(20, 20, 100, 60);
        botaoDados.setFocusable(false);
        botaoDados.setEnabled(false);
        botaoDados.addActionListener(this);
        panelConsole.add(botaoDados);
        setPlayerButtons();
    }

    public void setConsole() {
        panelConsole = new JPanel();
        panelConsole.setBackground(Color.gray);
        panelConsole.setBounds(0, 450, 450, 300);
        panelConsole.setLayout(null);
        setButtons();
        setInputField();
        setTextField();
    }

    public void setTextField() {
        textArea = new JTextArea();
        textArea.setBounds(200, 10, 220, 130);
        textArea.setFont(new Font("Calibri", Font.PLAIN, 11));
        textArea.setMargin(new Insets(2,4,2,5));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setText("");
        panelConsole.add(textArea);
    }

    public void setInputField() {
        inputField = new JTextField();
        inputField.setBounds(20, 90, 100, 30);
        inputField.setText("Escreva aqui");
        inputField.setFont(new Font("Calibri", Font.PLAIN, 14));
        inputField.setHorizontalAlignment(SwingConstants.CENTER);
        inputField.setBorder(BorderFactory.createLineBorder(Color.white));
        inputField.setPreferredSize(new Dimension(250,40));
        botaoAns = new JButton("Enviar");
        botaoAns.addActionListener(this);
        botaoAns.setFont(new Font("Calibri", Font.ITALIC, 8));
        botaoAns.setHorizontalTextPosition(JButton.CENTER);
        botaoAns.setBounds(20, 120, 100, 20);
        panelConsole.add(inputField);
        panelConsole.add(botaoAns);
    }

    public void setPecas() {
        pecas[0] = new JLabel(new ImageIcon("assets/RED.png"));
        pecas[1] = new JLabel(new ImageIcon("assets/GREEN.png"));
        pecas[2] = new JLabel(new ImageIcon("assets/BLUE.png"));
        pecas[0].setBounds(50,30,50,50);
        pecas[1].setBounds(55,30,50,50);
        pecas[2].setBounds(45,30,50,50);
        panelTab.add(pecas[0]);
        panelTab.add(pecas[1]);
        panelTab.add(pecas[2]);
        pecas[0].setVisible(false);
        pecas[1].setVisible(false);
        pecas[2].setVisible(false);
    }

    public void iniciarGUI(){
        setConsole();
        setTabuleiro();
        this.setLayout(null);
        this.add(panelTab);
        this.add(panelConsole);
        setSize(465,650);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tente Não Jubilar!");
        this.setVisible(true);
    }

    public void setOutputText(String text) {
        textArea.setText(text);
        gameWait(1500);
    }

    public int numeroJogadores() {
        this.jogadores = 0;
        this.event = 1;
        setOutputText("Bem vindo ao Tente Não Jubilar!" +
                " O simulador super realista de sobrevivência na UNICAMP! " +
                "Quantos jogadores vão participar dessa loucura? (Escolha 2 ou 3)\n" +
                "\nBOA SORTE!");

        while(jogadores == 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.event = 2;
        return jogadores;
    }

    public void gameWait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String lerJogadores(Jogador jogador, int num) {
        inputText = null;
        setOutputText("\nQual o nome do jogador da peça\n" + cor[num] + " ?\n" + outputText);

        while(inputText == null) {
            gameWait(200);
        }
        playerButtons[num].setText(inputText);
        playerButtons[num].setVisible(true);
        mostrarPeca(num);
        outputText += cor[num] + ": " + inputText + "\n";
        return inputText;
    }

    public void mostrarPeca(int num) {
        pecas[num].setVisible(true);
    }

    public void connect(IControle controle) {
        this.controle = controle;
    }

    public void mostrarTurno(int casas) {
        this.event = 3;
        aux = true;
        botaoDados.setEnabled(true);
        botaoDados.setText("Rodar Dados");
        while(aux) {
            gameWait(200);
        }
        botaoDados.setText("Passar Turno");
        outputText = "Voce tirou " + casas + " nos dados!";
        setOutputText(outputText);
    }

    public void moverPeca(int id, String direcao){
        int x = (int)pecas[id].getBounds().getX();
        int y = (int)pecas[id].getBounds().getY();
        if(direcao.equals("d")) {
            x += 50;
        } else if (direcao.equals("b")) {
            y += 50;
        } else if (direcao.equals("e")) {
            x -= 50;
        } else {
            y -= 50;
        }
        gameWait(500);
        pecas[id].setBounds(x, y, 50, 50);
    }

    public String tomarDecisao(String direcao) {
        inputText = "x";
        event = 2;
        while (!(inputText.charAt(0) == direcao.charAt(0)) && !(inputText.charAt(0) == direcao.charAt(1))) {
            gameWait(200);
        }
        return inputText;
    }

    public String getInputText() {
        event = 2;
        this.aux = true;
        while(aux) {
            gameWait(200);
        }
        return inputText;
    }

    public void esperarPassar() {
        event = 3;
        aux = true;
        while (aux) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource() == botaoAns) && event == 1){
            try {
                this.jogadores = Integer.parseInt(inputField.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Not a valid number!");
            }
        } else if((e.getSource() == botaoAns) && event == 2) {
            this.inputText = inputField.getText();
            this.aux = false;
            System.out.println(inputText);
        } else if((e.getSource() == botaoDados) && event == 3) {
            this.aux = false;
        } else {
            Jogador[] jogadores = controle.getJogadores();
            for(int i = 0; i < jogadores.length; i++) {
                if(e.getSource() == playerButtons[i]) {
                    if(playerButtonsStatus[i] == true) {
                        outputText = textArea.getText();
                        String text = "Créditos: " + jogadores[i].getCredito() +
                                "\nEssas são as seguintes possessões:\n";
                        for (int j = 0; j < jogadores[i].getPosses().size(); j++) {
                            text += jogadores[i].getPosses().get(j).getNome() + "  ";
                        }
                        for(int k = 0; k < jogadores.length;k++){
                            if(i!=k)
                                playerButtons[k].setEnabled(false);
                        }
                        textArea.setText(text);
                        botaoDados.setEnabled(false);
                        playerButtonsStatus[i] = false;
                        playerButtons[i].setText("Voltar");
                    } else {
                        for(int k = 0; k < jogadores.length; k++) {
                            playerButtons[k].setEnabled(true);
                        }
                        botaoDados.setEnabled(true);
                        textArea.setText(outputText);
                        playerButtonsStatus[i] = true;
                        playerButtons[i].setText(jogadores[i].getNome());
                    }
                }
            }
        }
    }

}
