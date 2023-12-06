package Perguntas;

import java.io.Serializable;
import java.util.ArrayList;

public class Ciencia extends Pergunta implements Serializable {

    protected ArrayList<String> opcoes;

    public Ciencia(String categoria, String pergunta, ArrayList<String> opcoes, int index) {
        super(categoria, pergunta, opcoes, index);
        this.opcoes = escolheOpcoes(opcoes);
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

    public ArrayList<String> escolheOpcoes(ArrayList<String> opcoes) {
        if (getIndex() < 3) {
            opcoes.subList(5,9).clear();
        }else {
            opcoes.subList(1, 5).clear();
        }
        return opcoes;
    }

    public int pontuacao() {
        return getPontuacaoBase() + 5;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
