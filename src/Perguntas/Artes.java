package Perguntas;

import java.util.ArrayList;

public class Artes extends Pergunta{

    public Artes(String categoria, String pergunta, ArrayList<String> opcoes, int index) {
        super(categoria, pergunta, opcoes, index);
    }

    public String getCorreta() {
        return getOpcoes().get(0);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += getPontuacaoBase() * 10;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
