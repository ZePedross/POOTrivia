package Main;

import Perguntas.*;

import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;


public class POOTrivia implements Serializable{

    private ArrayList<String> perguntasFicheiro = new ArrayList<>();

    private ArrayList<Pergunta> perguntas = new ArrayList<>();

    private ArrayList<Player> jogadores = new ArrayList<>();

    private ArrayList<String> topJogadores = new ArrayList<>();

    private ArrayList<Integer> topPontuacoes  = new ArrayList<>();

    private String dataHora;

    public String dataEHora(String dthr){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime now = LocalDateTime.now();
        dthr = dtf.format(now);
        return dthr;
    }

    public static void main(String[] args) {

        POOTrivia pooTrivia = new POOTrivia();

        Ficheiro ficheiro = new Ficheiro(pooTrivia.perguntas, pooTrivia.perguntasFicheiro, pooTrivia.jogadores);

        ficheiro.sortearPerguntas();
        ficheiro.lerFicheiroJogadores();

        for(Player p: pooTrivia.jogadores) {
            System.out.println(p);
        }

        pooTrivia.rankingTop3(pooTrivia.jogadores,pooTrivia.topPontuacoes);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("POOTrivia");

        GamePanel panel = new GamePanel();
        panel.painelPrincipal();


        ButtonListener buttonListener = new ButtonListener(panel, ficheiro, pooTrivia, pooTrivia.perguntas, pooTrivia.jogadores, pooTrivia.dataEHora(pooTrivia.dataHora));
        panel.opc1.addActionListener(buttonListener);
        panel.opc2.addActionListener(buttonListener);
        panel.opc3.addActionListener(buttonListener);
        panel.opc4.addActionListener(buttonListener);
        panel.opc5.addActionListener(buttonListener);
        panel.novoJogo.addActionListener(buttonListener);
        panel.sairJogo.addActionListener(buttonListener);
        panel.verdadeiro.addActionListener(buttonListener);
        panel.falso.addActionListener(buttonListener);
        panel.enviar.addActionListener(buttonListener);


        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    public void rankingTop3(ArrayList<Player> player, ArrayList<Integer> topPontuacoes) {
        if(!player.isEmpty()){
            ArrayList<Integer> Pontuacoes = new ArrayList<>();
            for(Player p : player){
                int pontuacao = 0;
                for(Pergunta pergunta : p.getRespostasDadas()){
                    if(pergunta.isAcertou()){
                        pontuacao += pergunta.pontuacao();
                    }
                }
                Pontuacoes.add(pontuacao);
            }

            int paragem = Math.min(Pontuacoes.size(), 3);

            for(int i = 0; i < paragem; i++){
                int max = 0;
                for(int pontuacao : Pontuacoes){
                    if(pontuacao > max){
                        max = pontuacao;
                    }
                }
                topPontuacoes.add(max);
                topJogadores.add(jogadores.get(Pontuacoes.indexOf(max)).getName());
                Pontuacoes.remove(Pontuacoes.indexOf(max));
            }
        }else{
            System.out.println("Ainda não existem jogadores");
        }
    }
}