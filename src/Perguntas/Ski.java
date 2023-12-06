package Perguntas;

import java.io.Serializable;
import java.util.ArrayList;

public class Ski extends Pergunta implements Serializable {

    protected ArrayList<String> opcoes;

    public Ski(String categoria, String pergunta, ArrayList<String> opcoes, int index) {
        super(categoria, pergunta, opcoes, index);
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

    @Override
    public String getCorreta() {
        return this.opcoes.get(0);
    }

    public int pontuacao() {
        return 3 + getPontuacaoBase() * 2;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
