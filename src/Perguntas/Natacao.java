package Perguntas;

import java.util.ArrayList;

public class Natacao extends Pergunta{

    public Natacao(String categoria, String pergunta, ArrayList<String> opcoes, int index) {
        super(categoria, pergunta, opcoes, index);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += 13;
    }


    public String getCorreta() {
        return getOpcoes().get(0);
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
