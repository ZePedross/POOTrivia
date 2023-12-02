package Perguntas;

import java.util.ArrayList;

public class Natacao extends Pergunta{

    protected ArrayList<String> opcoes;

    public Natacao(String categoria, String pergunta, ArrayList<String> opcoes, int index) {
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

    public String getCorreta() {
        return this.opcoes.get(0);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += getPontuacaoBase() + 13;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
