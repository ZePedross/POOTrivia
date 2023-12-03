package Main;

import Perguntas.Pergunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ButtonListener implements ActionListener {

    private GamePanel panel;
    private POOTrivia pooTrivia;
    private ArrayList<Pergunta> perguntas;
    private ArrayList<Player> jogadores;

    private ArrayList<String> respostasDadas = new ArrayList<>();

    protected String resp;

    private int pontuacao;
    private int contaCertas;
    private int pergunta;

    public ButtonListener(GamePanel panel, POOTrivia pooTrivia, ArrayList<Pergunta> perguntas, ArrayList<Player> jogadores) {
        this.panel = panel;
        this.pooTrivia = pooTrivia;
        this.perguntas = perguntas;
        this.jogadores = jogadores;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Novo Jogo")) {
            pooTrivia.sortearPerguntas();

            panel.nome.setText("");
            respostasDadas.clear();

            pergunta = 0;
            pontuacao = 0;
            contaCertas = 0;

            novaPergunta(pergunta);
        }else if (e.getActionCommand().equals("Sair do Jogo")) {
            if (JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                pooTrivia.escreverFicheiroJogadores();
                System.exit(0);
            }
        }else if (e.getActionCommand().equals("Enviar Nome")) {
            if (!panel.nome.toString().isEmpty()) {
                jogadores.add(new Player(panel.nome.getText(), respostasDadas));
                mostrarPainelFinal(contaCertas, pontuacao);
            }else {
                JOptionPane.showMessageDialog(null, "Um nome tem que ser inserido!");
            }
        }else if (e.getActionCommand().equals(resp)) {
            pontuacao += perguntas.get(pergunta).pontuacao();
            contaCertas++;
            respostasDadas.add(perguntas.get(pergunta).getCategoria() + ", Acertou");
            if(pergunta != perguntas.size() - 1) {
                pergunta++;
                novaPergunta(pergunta);
            }else {
                mostrarPainelNomePlayer();
            }
        }else if (!e.getActionCommand().equals(resp)) {
            respostasDadas.add(perguntas.get(pergunta).getCategoria() + ", Errada");
            if (pergunta != 4) {
                pergunta++;
                novaPergunta(pergunta);
            }else {
                mostrarPainelNomePlayer();
            }
        }
    }

    public void novaPergunta(int index) {
        panel.repaint();
        String cat = perguntas.get(index).getCategoria();
        String perg = perguntas.get(index).getPergunta();
        ArrayList<String> opcoes = perguntas.get(index).getOpcoes();
        resp = perguntas.get(index).getCorreta();
        Collections.shuffle(opcoes);
        if (opcoes.size() == 2) {
            panel.painelPerguntasVF(cat, perg, pontuacao);
        } else {
            panel.painelPerguntasOpcoes(cat, perg, opcoes, pontuacao);
        }
    }

    public void mostrarPainelNomePlayer() {
        panel.repaint();
        panel.painelNomePlayer();
    }

    public void mostrarPainelFinal(int certas, int score) {
        panel.repaint();
        panel.painelFimJogo(certas, score);
    }
}

