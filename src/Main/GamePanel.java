package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    protected int screenWidth = 768;
    protected int screenHeight = 576;

    protected int center = (screenWidth / 2);

    protected JButton novoJogo, verRank, sairJogo, opc1, opc2, opc3, opc4, opc5, verdadeiro, falso, enviar;
    protected JTextField nome;

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

        enviar = new JButton("Enviar Nome");

        nome = new JTextField();
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

    public void painelPerguntasOpcoes(String categoria, String pergunta, ArrayList<String> opcoes, int score) {
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

        JLabel s = new JLabel("Score: " + score);
        s.setFont(new Font("Arial", Font.BOLD, 15));
        s.setForeground(Color.BLACK);

        int xCategoria = center - (c.getPreferredSize().width / 2);
        int yCategoria = 50;

        int xPergunta = center - (p.getPreferredSize().width / 2);
        int yPergunta = 100;

        int xScore = center - (s.getPreferredSize().width / 2);
        int yScore = screenHeight - 20;

        c.setBounds(xCategoria, yCategoria, c.getPreferredSize().width, c.getPreferredSize().height);
        p.setBounds(xPergunta, yPergunta, p.getPreferredSize().width, p.getPreferredSize().height);
        s.setBounds(xScore, yScore, s.getPreferredSize().width, s.getPreferredSize().height);

        this.add(c);
        this.add(p);
        this.add(s);

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

    public void painelPerguntasVF(String categoria, String pergunta, int score) {
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

        JLabel s = new JLabel("Score: " + score);
        s.setFont(new Font("Arial", Font.BOLD, 15));
        s.setForeground(Color.BLACK);

        int xCategoria = center - (c.getPreferredSize().width / 2);
        int yCategoria = 50;

        int xPergunta = center - (p.getPreferredSize().width / 2);
        int yPergunta = 100;

        int xScore = center - (s.getPreferredSize().width / 2);
        int yScore = screenHeight - 20;

        c.setBounds(xCategoria, yCategoria, c.getPreferredSize().width, c.getPreferredSize().height);
        p.setBounds(xPergunta, yPergunta, p.getPreferredSize().width, p.getPreferredSize().height);
        s.setBounds(xScore, yScore, s.getPreferredSize().width, s.getPreferredSize().height);

        this.add(c);
        this.add(p);
        this.add(s);

        int xOpc = center - 150;
        int yOpc = screenHeight / 2;

        verdadeiro.setBounds(xOpc, yOpc - 37, 300, 50);
        verdadeiro.setFont(new Font("Arial", Font.PLAIN, 20));

        falso.setBounds(xOpc, yOpc + 37, 300, 50);
        falso.setFont(new Font("Arial", Font.PLAIN, 20));


        this.add(verdadeiro);
        this.add(falso);
    }

    public void painelNomePlayer() {
        removeAll();

        JLabel nomeTexto = new JLabel("Escreve o teu nome no campo a baixo!");
        nomeTexto.setFont(new Font("Verdana", Font.PLAIN, 30));
        nomeTexto.setForeground(Color.BLACK);

        int xNomeTexto = center - (nomeTexto.getPreferredSize().width / 2);
        int yNomeTexto = 200;

        nomeTexto.setBounds(xNomeTexto, yNomeTexto, nomeTexto.getPreferredSize().width, nomeTexto.getPreferredSize().height);

        this.add(nomeTexto);

        int xNome = center - 150;
        int yNome = (screenHeight / 2) - (nome.getPreferredSize().height / 2);

        nome.setBounds(xNome, yNome, 300, 25);
        nome.setEditable(true);

        this.add(nome);

        int xEnviar = center - 100;
        int yEnviar = screenHeight / 2 + 50;

        enviar.setBounds(xEnviar, yEnviar , 200, 50);
        enviar.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(enviar);
    }

    public void painelFimJogo(int certas, int score) {
        removeAll();

        JLabel parabens = new JLabel("Parabéns acertaste um total de " + certas + " perguntas!");
        parabens.setFont(new Font("Verdana", Font.PLAIN, 30));
        parabens.setForeground(Color.BLACK);

        JLabel pontuacao = new JLabel("O teu score foi de: " + score);
        pontuacao.setFont(new Font("Verdana", Font.PLAIN, 30));
        pontuacao.setForeground(Color.BLACK);

        JLabel ranking = new JLabel("TOP 3 JOGADORES");
        ranking.setFont(new Font("Arial", Font.BOLD, 25));
        ranking.setForeground(Color.BLACK);

        int xParabens = center - (parabens.getPreferredSize().width / 2);
        int yParabens = 50;

        int xScore = center - (pontuacao.getPreferredSize().width / 2);
        int yScore = 100;

        int xRanking = center - (ranking.getPreferredSize().width / 2);
        int yRanking = 175;

        parabens.setBounds(xParabens, yParabens, parabens.getPreferredSize().width, parabens.getPreferredSize().height);
        pontuacao.setBounds(xScore, yScore, pontuacao.getPreferredSize().width, pontuacao.getPreferredSize().height);
        ranking.setBounds(xRanking, yRanking, ranking.getPreferredSize().width, ranking.getPreferredSize().height);


        this.add(parabens);
        this.add(pontuacao);
        this.add(ranking);

        novoJogo.setBounds(screenWidth - 205, screenHeight - 55, 200, 50);
        novoJogo.setFont(new Font("Arial", Font.PLAIN, 20));

        sairJogo.setBounds(5, screenHeight - 55, 200, 50);
        sairJogo.setFont(new Font("Arial", Font.PLAIN, 20));

        this.add(novoJogo);
        this.add(sairJogo);
    }
}
