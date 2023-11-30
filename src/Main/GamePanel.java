package Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    protected int screenWidth = 768;
    protected int screenHeight = 576;

    protected int center = (screenWidth / 2);

    protected JButton novoJogo, verRank, sairJogo, opc1, opc2, opc3, opc4, verdadeiro, falso;

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

    public void painelPerguntasOpcoes(String pergunta, String[] opcoes) {
        JLabel p = new JLabel(pergunta);
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.setForeground(Color.BLACK);

        int xLabel = center - (p.getPreferredSize().width / 2);
        int yLabel = 100;

        p.setBounds(xLabel, yLabel, p.getPreferredSize().width, p.getPreferredSize().height);
        this.add(p);

        int xOpc = center - 150;
        int yOpc = screenHeight / 2;

        opc1.setText(opcoes[0]);
        opc2.setText(opcoes[1]);
        opc3.setText(opcoes[2]);
        opc4.setText(opcoes[3]);

        opc1.setBounds(xOpc, yOpc - 113, 300, 50);
        opc1.setFont(new Font("Arial", Font.PLAIN, 20));

        opc2.setBounds(xOpc, yOpc - 37, 300, 50);
        opc2.setFont(new Font("Arial", Font.PLAIN, 20));

        opc3.setBounds(xOpc, yOpc + 37, 300, 50);
        opc3.setFont(new Font("Arial", Font.PLAIN, 20));

        opc4.setBounds(xOpc, yOpc + 113, 300, 50);
        opc4.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(opc1);
        this.add(opc2);
        this.add(opc3);
        this.add(opc4);
    }

    public void painelPerguntasVF(String pergunta, String[] opcoes) {
        JLabel p = new JLabel(pergunta);
        p.setFont(new Font("Arial", Font.BOLD, 20));
        p.setForeground(Color.BLACK);

        int xLabel = center - (p.getPreferredSize().width / 2);
        int yLabel = 100;

        p.setBounds(xLabel, yLabel, p.getPreferredSize().width, p.getPreferredSize().height);
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
