package Perguntas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Artes extends Pergunta implements Serializable {

    protected ArrayList<String> opcoes;

    public Artes(String categoria, String pergunta, ArrayList<String> opcoes, int index, int pontuacaoBase) {
        super(categoria, pergunta, opcoes, index, pontuacaoBase);
        this.opcoes = esolheOpcoes(opcoes);
    }

    @Override
    public ArrayList<String> getOpcoes() {
        return opcoes;
    }

    @Override
    public void setOpcoes(ArrayList<String> opcoes) {
        this.opcoes = opcoes;
    }

    @Override
    public String getCorreta() {
        return this.opcoes.get(0);
    }

    public int pontuacao() {
        return getPontuacaoBase() * 10;
    }

    public ArrayList<String> esolheOpcoes(ArrayList<String> opcoes){
        Random rand = new Random();
        if(getIndex() < 3){
            opcoes.remove(rand.nextInt(1, opcoes.size()));
            opcoes.remove(rand.nextInt(1, opcoes.size()));
        }
        return opcoes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
