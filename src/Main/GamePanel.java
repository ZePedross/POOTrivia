package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    protected int screenWidth = 768;
    protected int screenHeight = 576;

    protected int center = (screenWidth / 2);

    protected JButton novoJogo, verRank, sairJogo, opc1, opc2, opc3, opc4, opc5, verdadeiro, falso;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        novoJogo = new JButton("Novo Jogo");
        verRank = new JButton("Ver Rank");
        sairJogo = new JButton("Sair do Jogo");

        opc1 = new JButton();
        opc2 = new JButton();
        opc3 = new JButton();
        opc4 = new JButton();
        opc5 = new JButton();

        verdadeiro = new JButton("Verdadeiro");
        falso = new JButton("Falso");
    }

    public void painelPrincipal() {
        JLabel nomeJogo = new JLabel("POOTrivia");
        nomeJogo.setFont(new Font("Arial", Font.BOLD, 20));
        nomeJogo.setForeground(Color.BLACK);

        int xLabel = center - (nomeJogo.getPreferredSize().width / 2);
        int yLabel = 100;

        nomeJogo.setBounds(xLabel, yLabel, 100, 100);
        this.add(nomeJogo);

        int xButtons = center - 100;

        novoJogo.setBounds(xButtons, yLabel + 150, 200, 50);
        novoJogo.setFont(new Font("Arial", Font.PLAIN, 20));

        verRank.setBounds(xButtons, yLabel + 225, 200, 50);
        verRank.setFont(new Font("Arial", Font.PLAIN, 20));

        sairJogo.setBounds(xButtons, yLabel + 300, 200, 50);
        sairJogo.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(novoJogo);
        this.add(verRank);
        this.add(sairJogo);
    }

    public void painelPerguntasOpcoes(String categoria, String pergunta, ArrayList<String> opcoes) {
        removeAll();

        JLabel c = new JLabel(categoria);
        c.setFont(new Font("Verdana", Font.BOLD, 30));
        c.setForeground(Color.BLACK);

        JTextArea p = new JTextArea(pergunta, 3, 30);
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.setForeground(Color.BLACK);
        p.setWrapStyleWord(true);
        p.setLineWrap(true);
        p.setEditable(false);

        int xCategoria = center - (c.getPreferredSize().width / 2);
        int yCategoria = 50;

        int xPergunta = center - (p.getPreferredSize().width / 2);
        int yPergunta = 100;

        c.setBounds(xCategoria, yCategoria, c.getPreferredSize().width, c.getPreferredSize().height);
        p.setBounds(xPergunta, yPergunta, p.getPreferredSize().width, p.getPreferredSize().height);

        this.add(c);
        this.add(p);

        int xOpc = center - 150;
        int yOpc = screenHeight / 2;

        opc1.setText(opcoes.get(0));
        opc2.setText(opcoes.get(1));
        opc3.setText(opcoes.get(2));
        opc4.setText(opcoes.get(3));
        opc5.setText(opcoes.get(4));

        opc1.setBounds(xOpc, yOpc - 88, 300, 50);
        opc1.setFont(new Font("Arial", Font.PLAIN, 20));

        opc2.setBounds(xOpc, yOpc - 12, 300, 50);
        opc2.setFont(new Font("Arial", Font.PLAIN, 20));

        opc3.setBounds(xOpc, yOpc + 62, 300, 50);
        opc3.setFont(new Font("Arial", Font.PLAIN, 20));

        opc4.setBounds(xOpc, yOpc + 138, 300, 50);
        opc4.setFont(new Font("Arial", Font.PLAIN, 20));

        opc5.setBounds(xOpc, yOpc + 213, 300, 50);
        opc5.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(opc1);
        this.add(opc2);
        this.add(opc3);
        this.add(opc4);
        this.add(opc5);
    }

    public void painelPerguntasVF(String categoria, String pergunta, ArrayList<String> opcoes) {
        removeAll();

        JLabel c = new JLabel(categoria);
        c.setFont(new Font("Verdana", Font.BOLD, 30));
        c.setForeground(Color.BLACK);

        JTextArea p = new JTextArea(pergunta, 3, 30);
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.setForeground(Color.BLACK);
        p.setWrapStyleWord(true);
        p.setLineWrap(true);
        p.setEditable(false);

        int xCategoria = center - (c.getPreferredSize().width / 2);
        int yCategoria = 50;

        int xPergunta = center - (p.getPreferredSize().width / 2);
        int yPergunta = 150;

        c.setBounds(xCategoria, yCategoria, c.getPreferredSize().width, c.getPreferredSize().height);
        p.setBounds(xPergunta, yPergunta, p.getPreferredSize().width, p.getPreferredSize().height);

        this.add(c);
        this.add(p);

        int xOpc = center - 150;
        int yOpc = screenHeight / 2;

        verdadeiro.setBounds(xOpc, yOpc - 37, 300, 50);
        verdadeiro.setFont(new Font("Arial", Font.PLAIN, 20));

        falso.setBounds(xOpc, yOpc + 37, 300, 50);
        falso.setFont(new Font("Arial", Font.PLAIN, 20));


        this.add(verdadeiro);
        this.add(falso);
    }
}
