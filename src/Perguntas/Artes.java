package Perguntas;

import java.util.ArrayList;

public class Artes extends Pergunta{

    protected ArrayList<String> opcoes;

    public Artes(String categoria, String pergunta, ArrayList<String> opcoes, int index) {
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
        return getPontuacaoBase() * 10;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
