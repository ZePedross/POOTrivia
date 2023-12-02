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

    protected ArrayList<Pergunta> perguntas = new ArrayList<>();

    private Random rand  = new Random();

    public POOTrivia() {
        sortearPerguntas();
    }

    public static void main(String[] args) {

        POOTrivia pooTrivia = new POOTrivia();

        for(Pergunta pergunta: pooTrivia.perguntas) {
            System.out.println(pergunta);
        }

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("POOTrivia");

        GamePanel panel = new GamePanel();
        panel.painelPrincipal();

        //panel.painelPerguntasVF(pooTrivia.perguntas.get(0).getPergunta(), new String[]{"A","B"});

        ButtonListener buttonListener = new ButtonListener(panel,pooTrivia.perguntas);
        panel.opc1.addActionListener(buttonListener);
        panel.opc2.addActionListener(buttonListener);
        panel.opc3.addActionListener(buttonListener);
        panel.opc4.addActionListener(buttonListener);
        panel.opc5.addActionListener(buttonListener);
        panel.novoJogo.addActionListener(buttonListener);
        panel.sairJogo.addActionListener(buttonListener);


        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


    public void sortearPerguntas(){
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
}