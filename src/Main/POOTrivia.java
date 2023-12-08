package Main;

import Perguntas.*;

import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class POOTrivia implements Serializable{

    private ArrayList<String> perguntasFicheiro = new ArrayList<>();

    private ArrayList<Pergunta> perguntas = new ArrayList<>();

    private ArrayList<Player> jogadores = new ArrayList<>();

    protected ArrayList<String> topJogadores = new ArrayList<>();

    public String dataEHora(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void main(String[] args) {

        POOTrivia pooTrivia = new POOTrivia();

        Ficheiro ficheiro = new Ficheiro(pooTrivia.perguntas, pooTrivia.perguntasFicheiro, pooTrivia.jogadores);

        ficheiro.sortearPerguntas();
        ficheiro.lerFicheiroJogadores();

        pooTrivia.rankingTop3(pooTrivia.jogadores);

        for(String top3: pooTrivia.topJogadores) System.out.println(top3);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("POOTrivia");

        GamePanel panel = new GamePanel();
        panel.painelPrincipal();

        ButtonListener buttonListener = new ButtonListener(panel, ficheiro, pooTrivia, pooTrivia.perguntas, pooTrivia.jogadores);
        panel.opc1.addActionListener(buttonListener);
        panel.opc2.addActionListener(buttonListener);
        panel.opc3.addActionListener(buttonListener);
        panel.opc4.addActionListener(buttonListener);
        panel.opc5.addActionListener(buttonListener);
        panel.novoJogo.addActionListener(buttonListener);
        panel.verRank.addActionListener(buttonListener);
        panel.sairJogo.addActionListener(buttonListener);
        panel.menuPrincipal.addActionListener(buttonListener);
        panel.verdadeiro.addActionListener(buttonListener);
        panel.falso.addActionListener(buttonListener);
        panel.enviar.addActionListener(buttonListener);


        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    public void rankingTop3(ArrayList<Player> player) {
        topJogadores.clear();
        if(!player.isEmpty()){
            ArrayList<Integer> Pontuacoes = new ArrayList<>();
            for(Player p : player){
                System.out.println(p.name);
                int pontuacao = 0;
                for(Pergunta pergunta : p.getRespostasDadas()){
                    System.out.println(pergunta.getPergunta());
                    if(pergunta.isAcertou()){
                        pontuacao += pergunta.pontuacao();
                    }
                }
                Pontuacoes.add(pontuacao);
                System.out.println();
            }

            for(Integer p: Pontuacoes) System.out.print(p+" ");

            int paragem = Math.min(Pontuacoes.size(), 3);

            for(int i = 0; i < paragem; i++){
                int max = 0;
                for(int pontuacao : Pontuacoes){
                    if(pontuacao > max){
                        max = pontuacao;
                    }
                }
                topJogadores.add(jogadores.get(Pontuacoes.indexOf(max)).getName() + ": " + max);
                Pontuacoes.set(Pontuacoes.indexOf(max), -1);
            }
        }else{
            System.out.println("Ainda não existem jogadores");
        }
    }
}