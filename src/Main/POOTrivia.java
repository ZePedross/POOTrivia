package Main;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
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
                    perguntas.add(new Pergunta(infoPergunta));
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