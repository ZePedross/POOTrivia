package Perguntas;

import java.io.Serializable;
import java.util.ArrayList;

public class Natacao extends Pergunta implements Serializable {

    protected ArrayList<String> opcoes;

    public Natacao(String categoria, String pergunta, ArrayList<String> opcoes, int index, int pontuacaoBase) {
        super(categoria, pergunta, opcoes, index, pontuacaoBase);
        this.opcoes = opcoes;
    }

    @Override
    public ArrayList<String> getOpcoes() {
        return opcoes;
    }

    @Override
    public void setOpcoes(ArrayList<String> opcoes) {
        this.opcoes = opcoes;
    }

    public String getCorreta() {
        return this.opcoes.get(0);
    }

    public int pontuacao() {
        return getPontuacaoBase() + 13;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
