package Perguntas;

import java.util.ArrayList;

public class Ciencia extends Pergunta{

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
            for(int o = 0; o < 4; o++) {
                opcoes.remove(5);
            }
        }else {
            for(int o = 0; o < 4; o++) {
                opcoes.remove(1);
            }
        }
        return opcoes;
    }

    public void pontuacao(int pontuacao) {
        pontuacao += getPontuacaoBase() + 5;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
