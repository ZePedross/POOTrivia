import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ficheiro {
    private ArrayList<String> linhasFicheiro = new ArrayList<>();
    private ArrayList<String[]> perguntasEscolhidas = new ArrayList<>();
    public void readFile(){
        File f = new File("Perguntas.txt");
        if(f.exists() && f.isFile()){
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) != null){
                    linhasFicheiro.add(linha);
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
        System.out.println(linhasFicheiro);
    }
    public void sortPerguntas(){
        Random rand  = new Random();
        for(int i = 0 ; i < 5; i++) {
            int sortIdx = rand.nextInt(linhasFicheiro.size());
            String linha = linhasFicheiro.get(sortIdx);
            String[] linhaDividida = linha.split("//");
            perguntasEscolhidas.add(linhaDividida);
            linhasFicheiro.remove(sortIdx);
        }
        for(String[] linha : perguntasEscolhidas){
            System.out.println(Arrays.toString(linha));
        }
    }

}
