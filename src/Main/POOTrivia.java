package Main;

import Perguntas.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class POOTrivia {

    private ArrayList<String> perguntasFicheiro = new ArrayList<>();

    private static ArrayList<Pergunta> perguntas = new ArrayList<>();

    private Random rand  = new Random();

    public POOTrivia() {
        sortearPerguntas();
    }

    public static void main(String[] args) {

        POOTrivia pooTrivia = new POOTrivia();

        for(Pergunta pergunta: perguntas) {
            System.out.println(pergunta);
        }

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("POOTrivia");

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(768, 576));
        panel.setBackground(Color.WHITE);
        panel.setDoubleBuffered(true);
        panel.setFocusable(true);

        window.add(panel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void painelPergunta(String Pergunta, String[] opcoes) {

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