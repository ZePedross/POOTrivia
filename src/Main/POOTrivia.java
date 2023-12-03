package Main;

import Perguntas.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class POOTrivia {

    private ArrayList<String> perguntasFicheiro = new ArrayList<>();

    private ArrayList<Pergunta> perguntas = new ArrayList<>();

    private ArrayList<Player> jogadores = new ArrayList<>();

    private ArrayList<String> topJogadores = new ArrayList<>();

    private Random rand  = new Random();

    public POOTrivia() {
        lerFicheiroJogadores();
    }

    public static void main(String[] args) {

        POOTrivia pooTrivia = new POOTrivia();

        for(Player p: pooTrivia.jogadores) {
            System.out.println(p);
        }

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("POOTrivia");

        GamePanel panel = new GamePanel();
        panel.painelPrincipal();

        ButtonListener buttonListener = new ButtonListener(panel, pooTrivia, pooTrivia.perguntas, pooTrivia.jogadores);
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

    public void sortearPerguntas(){
        perguntas.clear();
        File f = new File("Perguntas.txt");
        if(f.exists() && f.isFile()){
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null){
                    perguntasFicheiro.add(linha);
                }

                while(perguntasFicheiro.size() > 5) {
                    perguntasFicheiro.remove(rand.nextInt(perguntasFicheiro.size()));
                }

                int idx = 1;
                for (String p: perguntasFicheiro) {
                    String[] infoPergunta = p.split(" / ");
                    String categoria = infoPergunta[0];
                    ArrayList<String> opcoes = new ArrayList<>(Arrays.asList(infoPergunta).subList(2, infoPergunta.length));
                    switch (categoria) {
                        case "Artes":
                            perguntas.add(new Artes(categoria, infoPergunta[1], opcoes, idx));
                            break;
                        case "Ciências":
                            perguntas.add(new Ciencia(categoria, infoPergunta[1], opcoes, idx));
                            break;
                        case "Natação":
                            perguntas.add(new Natacao(categoria, infoPergunta[1], opcoes, idx));
                            break;
                        case "Ski":
                            perguntas.add(new Ski(categoria, infoPergunta[1], opcoes, idx));
                            break;
                        case "Futebol":
                            perguntas.add(new Futebol(categoria, infoPergunta[1], opcoes, idx));
                            break;
                        default:
                            System.out.println("A categoria não existe, logo a pergunta não foi criada.");
                            break;
                    }
                    idx++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("Erro ao abrir o ficheiro de texto.");
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }
        else{
            System.out.println("O ficheiro não existe!");
        }
    }

    public void lerFicheiroJogadores() {
        File f = new File("Jogadores.txt");
        if(f.exists() && f.isFile()){
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] data = linha.split(" / ");
                    String name = data[0];
                    ArrayList<String> respostasDadas = new ArrayList<>(Arrays.asList(data).subList(1, data.length));
                    jogadores.add(new Player(name, respostasDadas));
                }
                br.close();
            } catch (FileNotFoundException e) {
                System.out.println("Erro ao abrir o ficheiro de texto.");
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }
        else{
            System.out.println("O ficheiro não existe!");
        }
    }

    public void escreverFicheiroJogadores() {
        File f = new File("Jogadores.txt");
        if(f.exists() && f.isFile()){
            try{
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Player player : jogadores) {
                    bw.write(player.name + " / ");
                    for (String resposta : player.respostasDadas) {
                        bw.write(resposta + " / ");
                    }
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                System.out.println("Erro ao abrir o ficheiro de texto.");
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }
        else{
            System.out.println("O ficheiro não existe!");
        }
    }
}