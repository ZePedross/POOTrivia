package Perguntas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Futebol extends Pergunta implements Serializable {

    protected ArrayList<String> opcoes;

    public Futebol(String categoria, String pergunta, ArrayList<String> opcoes, int index, int pontuacaoBase) {
        super(categoria, pergunta, opcoes, index, pontuacaoBase);
        this.opcoes = escolheOpcoes(opcoes);
    }

    @Override
    public ArrayList<String> getOpcoes() {
            return this.opcoes;
    }

    @Override
    public void setOpcoes(ArrayList<String> opcoes) {
        this.opcoes = opcoes;
    }

    @Override
    public String getCorreta() {
        return this.opcoes.get(0);
    }

    public ArrayList<String> escolheOpcoes(ArrayList<String> opcoes) {
        if (getIndex() < 3) {
            opcoes.subList(5, 10).clear();
        }else {
            opcoes.subList(0, 5).clear();
        }
        return opcoes;
    }

    public int pontuacao() {
        return getPontuacaoBase() + 4;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
