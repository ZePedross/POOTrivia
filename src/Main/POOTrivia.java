package Main;

import Perguntas.Artes;
import Perguntas.Pergunta;

import javax.swing.*;
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

        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta);
        }

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("POOTrivia");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

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

                for(int p = 0; p < perguntasFicheiro.size() - 5; p++) {
                    perguntasFicheiro.remove(rand.nextInt(perguntasFicheiro.size()));
                }

                for (String p : perguntasFicheiro) {
                    String[] infoPergunta = perguntasFicheiro.get(rand.nextInt(perguntasFicheiro.size())).split(" / ");
                    ArrayList<String> opcoes = new ArrayList<>(Arrays.asList(infoPergunta).subList(2, infoPergunta.length));
                    perguntas.add(new Artes(infoPergunta[0], infoPergunta[1], opcoes, opcoes.get(0)));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Erro ao abrir o ficheiro de texto.");
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }
        else{
            System.out.println("O ficheiro não existe");
        }
    }
}