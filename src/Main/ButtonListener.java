package Main;

import Perguntas.Pergunta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ButtonListener implements ActionListener {

    private String dataHora;

    private GamePanel panel;

    private Ficheiro ficheiro;

    private POOTrivia pooTrivia;

    private ArrayList<Pergunta> perguntas;

    private ArrayList<Player> jogadores;

    private ArrayList<Pergunta> respostasDadas;

    private String resp;

    private int pontuacao;

    private int contaCertas;

    private int pergunta;


    public ButtonListener(GamePanel panel, Ficheiro ficheiro, POOTrivia pooTrivia, ArrayList<Pergunta> perguntas, ArrayList<Player> jogadores) {
        this.panel = panel;
        this.pooTrivia = pooTrivia;
        this.perguntas = perguntas;
        this.jogadores = jogadores;
        this.ficheiro = ficheiro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Novo Jogo")) {
            this.dataHora = pooTrivia.dataEHora();
            ficheiro.sortearPerguntas();

            panel.nome.setText("");
            respostasDadas = new ArrayList<>();

            novaPergunta(pergunta);
        } else if (e.getActionCommand().equals("Ver Rank")) {
            mostarPainelTop3();

        } else if (e.getActionCommand().equals("Menu Principal")) {
            mostrarPainelPrincipal();
        } else if (e.getActionCommand().equals("Sair do Jogo")) {
            if (JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                ficheiro.escreverFicheiroJogadores();
                System.exit(0);
            }
        } else if (e.getActionCommand().equals("Enviar Nome")) {
            if (!panel.nome.getText().isEmpty()) {
                if(panel.nome.getText().charAt(0) == ' ' || Character.isDigit(panel.nome.getText().charAt(0))){
                    JOptionPane.showMessageDialog(null, "Não é permitido usar espaços ou números antes do nome!");
                } else{
                    jogadores.add(new Player(panel.nome.getText(), respostasDadas, dataHora));
                    pooTrivia.rankingTop3(jogadores);
                    for(Player player: jogadores) {
                        if(player.getName().equals(panel.nome.getText())) {
                            mostrarPainelFinal(contaCertas, pontuacao, player);
                        }
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null, "Um nome tem que ser inserido!");
            }
        }else if (e.getActionCommand().equals(resp)) {
            pontuacao += perguntas.get(pergunta).pontuacao();
            contaCertas++;
            respostasDadas.add(perguntas.get(pergunta));
            JOptionPane.showMessageDialog(null, "Acertou!");
            perguntas.get(pergunta).setAcertou();
            if(pergunta != perguntas.size() - 1) {
                pergunta++;
                novaPergunta(pergunta);
            }else {
                mostrarPainelNomePlayer();
            }
        }else if (!e.getActionCommand().equals(resp)) {
            respostasDadas.add(perguntas.get(pergunta));
            JOptionPane.showMessageDialog(null, "Errou!");
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
        } else if (opcoes.size() == 3) {
            panel.painelPerguntasOpcoesArtes(cat, perg, opcoes, pontuacao);
        } else {
            panel.painelPerguntasOpcoes(cat, perg, opcoes, pontuacao);
        }
    }

    public void mostrarPainelNomePlayer() {
        panel.repaint();
        panel.painelNomePlayer();
    }

    public void mostrarPainelPrincipal(){
        panel.repaint();
        panel.painelPrincipal();
    }

    public void mostrarPainelFinal(int certas, int score, Player player) {
        panel.repaint();
        panel.painelFimJogo(certas, score, pooTrivia.topJogadores);
        String nomeFicheiro = ficheiro.nomeFicheiro(player.getIniciaisNome(), this.dataHora);
        ficheiro.escreverFicheiroObjetos(nomeFicheiro, player);

        pergunta = 0;
        pontuacao = 0;
        contaCertas = 0;
    }

    public void mostarPainelTop3(){
        panel.repaint();
        panel.painelTop3(pooTrivia.topJogadores);
    }
}

