package Perguntas;

import java.util.ArrayList;

public class Futebol extends Pergunta{

    public Futebol(String categoria, String pergunta, ArrayList<String> opcoes, int index) {
        super(categoria, pergunta, opcoes, index);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += 4;
    }

    public String getCorreta() {
        if (getIndex() < 3) {
            return getOpcoes().get(0);
        }else {
            return getOpcoes().get(5);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nCorreta: " + getCorreta() + "\n";
    }
}
