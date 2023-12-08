package Main;

import Perguntas.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ficheiro implements Serializable {

    private ArrayList<Pergunta> perguntas;

    private ArrayList<String> perguntasFicheiro;

    private ArrayList<Player> jogadores;

    public Ficheiro(ArrayList<Pergunta> perguntas, ArrayList<String> perguntasFicheiro, ArrayList<Player> jogadores) {
        this.perguntas = perguntas;
        this.perguntasFicheiro = perguntasFicheiro;
        this.jogadores = jogadores;
    }

    public String nomeFicheiro(String iniciaisNome, String dataHora){
        return "pootrivia_jogo_" + dataHora + "_" + iniciaisNome;
    }

    public void sortearPerguntas(){
        Random rand = new Random();
        perguntas.removeAll(perguntas);
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
                    ArrayList<String> opcoes = new ArrayList<>(Arrays.asList(infoPergunta).subList(3, infoPergunta.length));
                    switch (categoria) {
                        case "Artes":
                            perguntas.add(new Artes(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                            break;
                        case "Ciências":
                            perguntas.add(new Ciencia(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                            break;
                        case "Natação":
                            perguntas.add(new Natacao(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                            break;
                        case "Ski":
                            perguntas.add(new Ski(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
                            break;
                        case "Futebol":
                            perguntas.add(new Futebol(categoria, infoPergunta[2], opcoes, idx, Integer.parseInt(infoPergunta[1])));
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
        try {
            File f = new File("Jogadores.txt");
            if (f.createNewFile()) {
                System.out.println("Ficheiro Jogadores.txt foi criado!");
            }

            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null) {
                    if(lerFicheiroObjetos(linha) != null) {
                        Player player = lerFicheiroObjetos(linha);
                        jogadores.add(player);
                    }
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }catch (IOException e) {
            System.out.println("Problema ao criar o ficheiro Jogadores.txt!");
        }
    }

    public void escreverFicheiroJogadores() {
        try {
            File f = new File("Jogadores.txt");
            if (f.createNewFile()) {
                System.out.println("Ficheiro Jogadores.txt foi criado!");
            }

            try {
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Player player : jogadores) {
                    bw.write(nomeFicheiro(player.iniciaisNome, player.getDataeHora()) + ".obj");
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro de texto.");
            }
        }catch (IOException e) {
            System.out.println("Erro ao criar o ficheiro Jogadores.txt!");
        }
    }

    public void escreverFicheiroObjetos(String nomeFicheiro, Player player){
        try {
            File f = new File(nomeFicheiro +".obj");
            if (f.createNewFile()) {
                System.out.println(nomeFicheiro + ".obj foi criado!");
            }
            try {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(player);
                oos.close();
            } catch (IOException ex) {
                System.out.println("Erro a escrever para o ficheiro.");
            }
        }catch (IOException e){
            System.out.println("Erro ao criar ficheiro.");
        }

    }

    public Player lerFicheiroObjetos(String nomeFicheiro) {
        File f = new File(nomeFicheiro);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Player player = (Player) ois.readObject();
            ois.close();
            return player;
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return null;
    }
}
